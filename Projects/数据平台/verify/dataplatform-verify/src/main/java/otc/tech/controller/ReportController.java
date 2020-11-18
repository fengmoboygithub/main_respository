package otc.tech.controller;

import com.github.pagehelper.PageHelper;

import otc.tech.base.controller.BaseController;
import otc.tech.model.ReportTypes;
import otc.tech.page.PageDomain;
import otc.tech.page.TableDataInfo;
import otc.tech.page.TableSupport;
import otc.tech.service.IReportTypesService;
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
@RequestMapping("/report")
public class ReportController extends BaseController {
	private String prefix = "report";
	@Autowired
	private IReportTypesService reportTypesService;


	@GetMapping()
	public String Menu() {
		return prefix + "/report";
	}

	/**
	 * 查询参数配置列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ReportTypes report) {
		PageDomain pageDomain = TableSupport.buildPageRequest();
		Integer pageNum = pageDomain.getPageNum();
		Integer pageSize = pageDomain.getPageSize();
		String orderBy = "".equals(pageDomain.getOrderBy()) ? "id" : pageDomain.getOrderBy();
		if (pageNum == 0 && pageSize == 0) {
			// 不做分页
		} else {
			PageHelper.startPage(pageNum, pageSize, orderBy);
		}
		Example example = new Example(ReportTypes.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(report.getTypeCodeInterface())) {
			criteria.andLike("typeCodeInterface", report.getTypeCodeInterface() + "%");
		}
		if (StringUtils.isNotBlank(report.getTypeName())) {
			criteria.andLike("typeName", "%" + report.getTypeName() + "%");
		}

		List<ReportTypes> list = reportTypesService.selectByExample(example);
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
	public AjaxResult addSave(ReportTypes report) {
		try {
			if (report.getTypeCodeInterface().isEmpty() || report.gettTemplateType().isEmpty()) {
				return error("报告编码或模板编号未填写");
			}
			return toAjax(reportTypesService.insert(report));
		} catch (Exception e) {
			return error("新增错误，请联系技术人员！");
		}

	}

	/**
	 * 修改参数配置
	 */
	@GetMapping("/edit/{typeId}")
	public String edit(@PathVariable("typeId") String typeId, ModelMap mmap) {
		mmap.put("report", reportTypesService.selectByPrimaryKey(typeId));
		return prefix + "/edit";
	}

	/**
	 * 修改保存参数配置
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ReportTypes report) {
		try {
			if (report.getTypeCodeInterface().isEmpty() || report.gettTemplateType().isEmpty()) {
				return error("报告编码或模板编号未填写");
			}
			return toAjax(reportTypesService.updateByPrimaryKey(report));
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
		Example example = new Example(ReportTypes.class);
		Example.Criteria criteria = example.createCriteria();
		String[] strs = Convert.toStrArray(ids);
		List<String> list= Arrays.asList(strs);
		criteria.andIn("typeId", list);
		return toAjax(reportTypesService.deleteByExample(example));
	}

	/**
	 * 校验参数键名
	 */
	@PostMapping("/checkReortUnique")
	@ResponseBody
	public String checkReortUnique(ReportTypes report) {
		return reportTypesService.checkReportUnique(report);
	}
}
