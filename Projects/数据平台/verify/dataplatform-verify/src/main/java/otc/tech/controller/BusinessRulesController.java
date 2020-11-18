package otc.tech.controller;

import com.github.pagehelper.PageHelper;

import otc.tech.base.controller.BaseController;
import otc.tech.model.BusinessRules;
import otc.tech.model.BusinessRules;
import otc.tech.page.PageDomain;
import otc.tech.page.TableDataInfo;
import otc.tech.page.TableSupport;
import otc.tech.service.IBusinessRulesService;
import otc.tech.service.IBusinessRulesService;
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
@RequestMapping("/business")
public class BusinessRulesController extends BaseController {
	private String prefix = "business";
	@Autowired
	private IBusinessRulesService businessRulesService;


	@GetMapping()
	public String Menu() {
		return prefix + "/rule";
	}

	/**
	 * 查询参数配置列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BusinessRules rule) {
		PageDomain pageDomain = TableSupport.buildPageRequest();
		Integer pageNum = pageDomain.getPageNum();
		Integer pageSize = pageDomain.getPageSize();
		String orderBy = "".equals(pageDomain.getOrderBy()) ? "id" : pageDomain.getOrderBy();
		if (pageNum == 0 && pageSize == 0) {
			// 不做分页
		} else {
			PageHelper.startPage(pageNum, pageSize, orderBy);
		}
		Example example = new Example(BusinessRules.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(rule.getrKey())) {
			criteria.andLike("rKey", rule.getrKey() + "%");
		}
		if (StringUtils.isNotBlank(rule.getrName())) {
			criteria.andLike("rName", "%" + rule.getrName() + "%");
		}

		List<BusinessRules> list = businessRulesService.selectByExample(example);
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
	public AjaxResult addSave(BusinessRules rule) {
		try {
			return toAjax(businessRulesService.insert(rule));
		} catch (Exception e) {
			return error("新增错误，请联系技术人员！");
		}
		
	}

	/**
	 * 修改参数配置
	 */
	@GetMapping("/edit/{rId}")
	public String edit(@PathVariable("rId") String rId, ModelMap mmap) {
		mmap.put("rule", businessRulesService.selectByPrimaryKey(rId));
		return prefix + "/edit";
	}

	/**
	 * 修改保存参数配置
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BusinessRules rule) {
		try {
			return toAjax(businessRulesService.updateByPrimaryKey(rule));
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
		Example example = new Example(BusinessRules.class);
		Example.Criteria criteria = example.createCriteria();
		String[] strs = Convert.toStrArray(ids);
		List<String> list= Arrays.asList(strs);
		criteria.andIn("rId", list);
		return toAjax(businessRulesService.deleteByExample(example));
	}

	/**
	 * 校验参数键名
	 */
	@PostMapping("/checBusinessRulesUnique")
	@ResponseBody
	public String checkReortUnique(BusinessRules rule) {
		return businessRulesService.checBusinessRulesUnique(rule);
	}
}
