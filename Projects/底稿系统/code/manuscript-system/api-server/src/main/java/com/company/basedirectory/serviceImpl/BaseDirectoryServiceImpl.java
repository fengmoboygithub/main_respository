package com.company.basedirectory.serviceImpl;

import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.basedirectory.dao.BaseDirectoryMapper;
import com.company.basedirectory.model.BaseDirectory;
import com.company.basedirectory.model.BaseDirectoryExample;
import com.company.basedirectory.model.BaseDirectoryExample.Criteria;
import com.company.basedirectory.service.BaseDirectoryService;
import com.company.enums.ProjectDirectoryType;
import com.company.projectdirectory.view.ProjectDirectoryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BaseDirectoryServiceImpl extends BaseServiceImpl<BaseDirectory, BaseDirectoryExample> implements BaseDirectoryService<BaseDirectory, BaseDirectoryExample>{

    @Autowired
    private BaseDirectoryMapper mapper;
	
	public IBaseDao<BaseDirectory, BaseDirectoryExample> getMapper(){
		return mapper;
	}

	/**
	 * 递归删除基础目录信息
	 * @param id 基础目录ID
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor= BaseException.class)
	public void deleteForDeep(String id) throws BaseException{
		BaseDirectoryExample example = new BaseDirectoryExample();
		Criteria criteria = example.createCriteria();
		if("-1".equals(id)){
			criteria.andParentidIsNull();
		} else {
			criteria.andParentidEqualTo(id);
		}
		List<BaseDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(BaseDirectory baseDirectory : tempList){
				this.deleteForDeep(baseDirectory.getId());
			}
		}
		int success = getMapper().deleteByPrimaryKey(id);
		if (success <= 0) {
			logger.error("根据主键删除基础目录信息错误{}", id);
			throw new RuntimeException("删除基础目录信息错误");
		}
	}

//	@Cacheable(value="basedirectorys")
	@Override
	public List<ProjectDirectoryTree> viewTreeForMe(String projecttype, String projectStage) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		//获取项目id和适用并且父id为null的数据--递归获取此项目下的所有数据
		BaseDirectoryExample example = new BaseDirectoryExample();
		example.setOrderByClause(" DIRENTORYNO asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(projecttype);
		criteria.andProjectstageLessThanOrEqualTo(projectStage);
		criteria.andParentidIsNull();
		List<BaseDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(BaseDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projecttype1 = pd.getProjecttype();
				String directoryid1 = pd.getId();
				String stage1 = pd.getProjectstage();
				pdt.setProjecttype(projecttype1);
				pdt.setId(directoryid1);
				pdt.setStage(stage1);
				pdt.setName(pd.getFullname());
				pdt.setPid("-1");
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setIsapp(pd.getIsapp());
				pdt.setNocheck(true);
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeByBaseDirectoryForDeepForMe(projecttype1, directoryid1, projectStage);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		ProjectDirectoryTree pdt = new ProjectDirectoryTree();
		pdt.setId("-1");
		pdt.setName("根目录");
		pdt.setPid(null);
		pdt.setType(ProjectDirectoryType.ROOT.getCode());
		pdt.setNocheck(true);
		list.add(pdt);
		return list;
	}

	/**
	 * 获取基础目录信息树类型对象用于递归
	 * @param projecttype
	 * @param directoryid
	 * @return
	 */
	public List<ProjectDirectoryTree> viewTreeByBaseDirectoryForDeepForMe(String projecttype, String directoryid, String stage) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		BaseDirectoryExample example = new BaseDirectoryExample();
		example.setOrderByClause(" DIRENTORYNO asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(projecttype);
		criteria.andParentidEqualTo(directoryid);
		criteria.andProjectstageLessThanOrEqualTo(stage);
		List<BaseDirectory> tempList = mapper.selectByExample(example);
		//获取项目类型id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(BaseDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projecttype1 = pd.getProjecttype();
				String directoryid1 = pd.getId();
				String stage1 = pd.getProjectstage();
				pdt.setProjecttype(projecttype1);
				pdt.setId(directoryid1);
				pdt.setStage(stage1);
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setIsapp(pd.getIsapp());
				pdt.setNocheck(true);
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeByBaseDirectoryForDeepForMe(projecttype1, directoryid1, stage);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor= BaseException.class)
	public void export(File file, String projectType) throws BaseException {
		//入参需要有项目类型
		StringBuilder result = new StringBuilder();
		String level1name = "";
		String level1id = "";
		int level1no = 1;
		String level2name = "";
		String level2id = "";
		int level2no = 1;
		String level3name = "";
		String level3id = "";
		int level3no = 1;
		String level4name = "";
		String level4id = "";
		int level4no = 1;
		String parentid = "";
		List list = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {	//使用readLine方法，一次读一行
				BaseDirectory baseDirectory = new BaseDirectory();
				/*
					首先需要
				 */
//				result.append(System.lineSeparator() + s);
				if(s.contains("第") && s.contains("部分")){
					String ss[] = s.split("　");
					level1name = ss[1];
					level1id = UUID.randomUUID().toString().replace("-","");
					baseDirectory.setParentid(null);
					baseDirectory.setId(level1id);
					baseDirectory.setFullname(s);
					baseDirectory.setSname(s);
					baseDirectory.setDirentoryno(level1no++);
					baseDirectory.setProjecttype(projectType);
					baseDirectory.setIsapp(1);
					baseDirectory.setLevel("1");
					baseDirectory.setProjectstage("100");
					level2no = 1;
					level3no = 1;
					level4no = 1;
				}
				if(s.contains("第") && s.contains("章")){
					String ss[] = s.split("　");
					level2name = ss[1];
					level2id = UUID.randomUUID().toString().replace("-","");
					baseDirectory.setParentid(level1id);
					baseDirectory.setId(level2id);
					baseDirectory.setFullname(s);
					baseDirectory.setSname(s);
					baseDirectory.setDirentoryno(level2no++);
					baseDirectory.setProjecttype(projectType);
					baseDirectory.setIsapp(1);
					baseDirectory.setLevel("2");
					baseDirectory.setProjectstage("100");
					level3no = 1;
					level4no = 1;
				}
				if(s.split("　")[0].contains("-")){
					String ss[] = s.split("　")[0].split("-");
					if(ss.length==2){
						level3name = s.split("　")[1];
						level3id = UUID.randomUUID().toString().replace("-","");
						baseDirectory.setParentid(level2id);
						baseDirectory.setId(level3id);
						baseDirectory.setFullname(s);
						baseDirectory.setSname(s);
						baseDirectory.setDirentoryno(level3no++);
						baseDirectory.setProjecttype(projectType);
						baseDirectory.setIsapp(1);
						baseDirectory.setLevel("3");
						baseDirectory.setProjectstage("100");
						level4no = 1;
					}else if(ss.length==3){
						level4name = s.split("　")[1];
						level4id = UUID.randomUUID().toString().replace("-","");
						baseDirectory.setParentid(level3id);
						baseDirectory.setId(level4id);
						baseDirectory.setFullname(s);
						baseDirectory.setSname(s);
						baseDirectory.setDirentoryno(level4no++);
						baseDirectory.setProjecttype(projectType);
						baseDirectory.setIsapp(1);
						baseDirectory.setLevel("4");
						baseDirectory.setProjectstage("100");
					}
				}
				list.add(baseDirectory);
			}
			mapper.batchInsertSelective(list);
			br.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(700%800);
	}
}