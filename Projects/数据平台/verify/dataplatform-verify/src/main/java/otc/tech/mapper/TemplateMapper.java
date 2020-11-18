package otc.tech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import otc.tech.base.mapper.BaseMapper;
import otc.tech.model.Template;
@Mapper
public interface TemplateMapper extends BaseMapper<Template> {
	/**查出虚拟上级名称
	 */
	public List<String> selectTupleName(Template template);
}
