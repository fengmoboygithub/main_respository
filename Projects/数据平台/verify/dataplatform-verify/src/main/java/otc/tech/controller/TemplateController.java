package otc.tech.controller;

import com.github.pagehelper.PageHelper;

import otc.tech.base.controller.BaseController;
import otc.tech.model.Template;
import otc.tech.model.Template;
import otc.tech.page.PageDomain;
import otc.tech.page.TableDataInfo;
import otc.tech.page.TableSupport;
import otc.tech.service.ITemplateService;
import otc.tech.service.ITemplateService;
import otc.tech.util.AjaxResult;
import otc.tech.util.Convert;
import otc.tech.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/template")
public class TemplateController extends BaseController {
	private String prefix = "field";
	@Autowired
	private ITemplateService templateService;


	@GetMapping()
	public String Menu() {
		return prefix + "/field";
	}

	/**
	 * 查询参数配置列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Template template) {
		PageDomain pageDomain = TableSupport.buildPageRequest();
		Integer pageNum = pageDomain.getPageNum();
		Integer pageSize = pageDomain.getPageSize();
		String orderBy = "".equals(pageDomain.getOrderBy()) ? "id" : pageDomain.getOrderBy();
		if (pageNum == 0 && pageSize == 0) {
			// 不做分页
		} else {
			PageHelper.startPage(pageNum, pageSize, orderBy);
		}
		Example example = new Example(Template.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(template.gettTemplateType())) {
			criteria.andLike("tTemplateType", template.gettTemplateType() + "%");
		}
		if (StringUtils.isNotBlank(template.gettElementName())) {
			criteria.andLike("tElementName", "%" + template.gettElementName() + "%");
		}

		List<Template> list = templateService.selectByExample(example);
		return getDataTable(list);
	}

//	@PostMapping("/export")
//	@ResponseBody
//	public AjaxResult export(SysConfig config) {
//		TableDataInfo list = configService.selectConfigList(0, 0, "null", config);
//		ExcelUtil<SysConfig> util = new ExcelUtil<SysConfig>(SysConfig.class);
//		String jsonlist = JSON.toJSONString(list.getRows());
//		List<SysConfig> listexport = JSONArray.parseArray(jsonlist, SysConfig.class);
//		return util.exportExcel(listexport, "config");
//	}
//
	/**
	 * 新增参数配置
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存参数配置
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Template template) {
		try {
			return toAjax(templateService.insert(template));
		} catch (Exception e) {
			return error("新增错误，请联系技术人员！");
		}
		
	}

	/**
	 * 修改参数配置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String typeId, ModelMap mmap) {
		mmap.put("template", templateService.selectByPrimaryKey(typeId));
		return prefix + "/edit";
	}

	/**
	 * 修改保存参数配置
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Template template) {
		try {
			return toAjax(templateService.updateByPrimaryKey(template));
		} catch (Exception e) {
			return error("修改错误，请联系技术人员！");
		}
	}

	/**
	 * 删除参数配置
	 */
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		Example example = new Example(Template.class);
		Example.Criteria criteria = example.createCriteria();
		String[] strs = Convert.toStrArray(ids);
		List<String> list= Arrays.asList(strs);
		criteria.andIn("id", list);
		return toAjax(templateService.deleteByExample(example));
	}

	/**
	 * 校验参数键名
	 */
	@PostMapping("/checkTemplateUnique")
	@ResponseBody
	public String checkReortUnique(Template template) {
		return templateService.checkTemplateUnique(template);
	}
}
