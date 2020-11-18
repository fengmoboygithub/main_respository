package otc.tech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import otc.tech.base.service.impl.BaseServiceImpl;
import otc.tech.mapper.TemplateMapper;
import otc.tech.model.Template;
import otc.tech.service.ITemplateService;
import otc.tech.util.StringUtils;
@Service
public class TemplateServiceImpl  extends BaseServiceImpl<Template> implements ITemplateService {
	
	@Autowired
	private TemplateMapper templateMapper;
	
	@Override
	public List<Template> findAllByTemplateType(String templateType) {
		Template te = new Template();
		te.settTemplateType(templateType);
		te.setStatus(0);
		List<Template> list = templateMapper.select(te);
		return list;
	}
	
//	@Override
//	public List<Template> findRootElement(String templateType) {
//		Template te = new Template();
//		te.settTemplateType(templateType);
//		te.setStatus(0);
//		List<Template> list = templateMapper.select(te);
//		return list;
//	}
	
	@Override
	public List<Template> findLeafElement(String templateType,String tupleTabName) {
		Template te = new Template();
		te.settTemplateType(templateType);
		te.setdTupleUpName(tupleTabName);
		te.setStatus(0);
		List<Template> list = templateMapper.select(te);
		return list;
	}
	
	@Override
	public List<Template> findByTemplateType(String templateType) {
		List<Template> roots = this.findAllByTemplateType(templateType);//查出该模块全部

		
		for (Template tupleTabParent : roots) {
			
			if (tupleTabParent.gettControlType().equals(4)) {// 查出虚拟上级名称
				List<Template> children = new ArrayList<Template>();
				tupleTabParent.setIsAbstract(true);
				String parentName = tupleTabParent.getdField();
				if("HHQYSYYJT".equals(parentName)) {
					System.out.println();
				}
				for (Template template : roots) {
					if (template.getdTupleUpName() != null && template.getdTupleUpName().equals(parentName)) {
						template.setParent(tupleTabParent);
						children.add(template);
					}
				}
				tupleTabParent.setChildren(children);
			}
		}
		
		
//		Template te = new Template();
//		te.settTemplateType(templateType);
//		List<String> tupleTabNames = this.templateMapper.selectTupleName(te);//查出虚拟上级名称
//		for (String tupleTabName : tupleTabNames) {
//			Template abstractElement = new Template();
//			abstractElement.setIsAbstract(true);
//			//abstractElement.setdTableName(tupleTabName);//并不是表名有用？
//			abstractElement.setdField(tupleTabName);
//			abstractElement.settControlType(4);
//			List<Template> leafs = this.findLeafElement(templateType, tupleTabName);//查出该虚拟字段的下级（在循环里查询）
//			for (Template leaf : leafs) {//目前并无作用但可以做上级提示
//				leaf.setParent(abstractElement);//把虚拟上级添加到每个子集
//			}
//			abstractElement.setChildren(leafs);//把子集放到虚拟字段里
//			roots.add(abstractElement);//有虚拟和真实所有字段
//		}
		return roots;
	}
	
	@Override
	public String checkTemplateUnique(Template template) {
		Integer configId = StringUtils.isNull(template.getId()) ? -1 : template.getId();
		template.setId(null);
		 Template info = templateMapper.selectOne(template);
	        if (StringUtils.isNotNull(info) && !info.getId().toString().equals(configId.toString()))
	        {
	            return "1";
	        }
	        return "0";
	    }

}
