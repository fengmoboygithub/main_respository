package com.company.base.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.dao.IBaseDao;
import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yangyanchao
 * 基类Service实现类
 * @param <T>
 * @param <E>
 */
public class BaseServiceImpl<T extends BaseModel,E extends BaseExample> implements IBaseService<T,E>{
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private IBaseDao<T,E> mapper;
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 	描述: 子类重写方法
	 * @param: 
	 * @return: IBaseDao<T,E>  
	 */
	public IBaseDao<T,E> getMapper(){
		return mapper;
	}

	public Logger getLogger() {
		return logger;
	}

	@Override
	public T get(Serializable id) throws BaseException {
		T model = getMapper().selectByPrimaryKey(id);
        if (model == null) {
            logger.error("获取实体数据错误，查询参数：{}", id);
            throw new BaseException("获取实体数据错误");
        }
        return model;
	}

	@Override
	public void save(T model) throws BaseException {
		
		int success = getMapper().insertSelective(model);
        if (success <= 0) {
            logger.error("新增实体错误{}",  model.toString());
            throw new BaseException("新增实体错误");
        }
        return;
	}

	@Override
	public void update(T model) throws BaseException {
		
		int success = getMapper().updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("更新实体错误{}",  model.toString());
            throw new BaseException("更新实体错误");
        }
        return;
		
	}

	@Override
	public void deleteByPrimaryKey(Serializable id) throws BaseException {
		int success = getMapper().deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("根据主键删除实体错误{}", id);
            throw new RuntimeException("删除实体错误");
        }
        return;
		
	}

	@Override
	public void deleteByExample(E example) throws BaseException {
		
		int success = getMapper().deleteByExample(example);
        if (success <= 0) {
            logger.error("根据查询条件删除实体错误{}", example);
            throw new RuntimeException("删除实体错误");
        }
        return;
		
	}

	@Override
	public long countByExample(E example) throws BaseException {

		return getMapper().countByExample(example);
		
	}

	@Override
	public PageInfo<T> getListByPage(int currentPage, int itemsPerPage, E example) throws BaseException {

        List<T> list = null;
        PageInfo<T> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = getMapper().selectByExample(example);
			page = new PageInfo<T>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("分页查询失败");
		}
		return page;
		
	}

	@Override
	public List<T> getList(E example) throws BaseException {

		 return getMapper().selectByExample(example);
	
	}
	
	

	@Override
	public void batchDeleteByPrimaryKey(List<Map<String, Object>> keyList) throws BaseException {
		
		int success = getMapper().batchDeleteByPrimaryKey(keyList);
        if (success <= 0) {
            logger.error("批量删除实体错误{}", keyList);
            throw new RuntimeException("批量删除实体错误");
        }
        return;
	}

	@Override
	public int batchInsert(List<T> itemList, String mapperClass) throws BaseException {
		
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);//关闭session的自动提交 
		int result = 0;
		try { 
			int i=0; 
			
			for (T item : itemList) { 
				
				result += session.insert(mapperClass, item);
				if (i % 1000 == 0 || i == itemList.size()-1) { 
					//手动每5000个一提交，提交后无法回滚 
					session.commit(); 
					session.clearCache();
					//注意，如果没有这个动作，可能会导致内存崩溃。 
				} 
				i++; 
			} 
		} catch (Exception e) { 
			//没有提交的数据可以回滚 
			session.rollback(); 
			result = 0;
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage(), e);
		} 
		finally{ 
			session.close(); 
		}
		return result;
	}

	@Override
	public List<T> select(String sql, E example) throws BaseException {
		return getMapper().select(sql, example);
	}
	
	@Override
	public PageInfo<T> getListByPage(int currentPage, int itemsPerPage, String sql, E example) throws BaseException {

        List<T> list = null;
        PageInfo<T> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = getMapper().select(sql, example);
			page = new PageInfo<T>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("分页查询失败");
		}
		return page;
		
	}

//	@Override
//	public Long getDataByBatchToFile(E example, OutputFileInfo outputFileInfo, JobParam jobParam) throws BaseException {
//		//根据查询条件获取总条数
//		PageInfo<T> pageInfo1 = this.getListByPage(0, jobParam.getPageSize(), example);
//		long totalNumber = pageInfo1.getTotal();
//		//输出文件路径
//		String filePath = jobParam.getOutputPath()+outputFileInfo.toString();
//		if(totalNumber > 0){
//			//根据总条数(totalNumber)和每页最多条数(jobParam.getPageSize())算出
//			//总页数
//			long totalPage = totalNumber % jobParam.getPageSize() == 0 ? totalNumber
//					/ jobParam.getPageSize() : totalNumber / jobParam.getPageSize() + 1;
//			for(int i = 0; i < totalPage; i++){
//				PageInfo<T> pageInfo = this.getListByPage(i, jobParam.getPageSize(), example);
//				String oneBatchStr = this.pageInfoToString(pageInfo, jobParam);
//				FileUtils.writeFile(new File(filePath), oneBatchStr);
//			}
//		} else {
//			FileUtils.writeFile(new File(filePath), "");
//		}
//		return totalNumber;
//	}
	
//	private String pageInfoToString(PageInfo<T> pageInfo, JobParam jobParam)throws BaseException {
//		String resuls = "";
//		if(pageInfo != null && pageInfo.getList() != null 
//				&& pageInfo.getList().size() > 0){
//			for(T t: pageInfo.getList()){
//				t.setLinefeed(jobParam.getLinefeed());
//				t.setSeparator(jobParam.getSeparator());
//				resuls += t.toString();
//			}
//		}
//		return resuls;
//	}
}