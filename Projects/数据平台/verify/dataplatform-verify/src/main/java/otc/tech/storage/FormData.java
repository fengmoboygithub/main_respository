package otc.tech.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


public class FormData {
	private String sheetName;
	private List<CellValue> cellValues = new ArrayList<CellValue>();
	private List<CellGroup> cellGroups = new ArrayList<CellGroup>();
	/**
	 * groupName ==> List&lt;groupId>
	 */
	private Map<String, List<String>> orderedGroups = new HashMap<String, List<String>>();

	/**
	 * 删除CellGroup对象根据groupId
	 * 
	 * @param groupId
	 */
	public void removeGroup(String groupId) {
		if (StringUtils.isBlank(groupId)) {
			return;
		}
		cellGroups.remove(this.getCellGroupMap().get(groupId));
		for (Map.Entry<String, List<String>> entry : orderedGroups.entrySet()) {
			entry.getValue().remove(groupId);
		}
	}

	public List<CellValue> getCellValues() {
		return cellValues;
	}

	public void setCellValues(List<CellValue> cellValues) {
		this.cellValues = cellValues;
	}

	public List<CellGroup> getCellGroups() {
		return cellGroups;
	}

	public void setCellGroups(Collection<CellGroup> cellGroups) {
		this.cellGroups.clear();
		this.cellGroups.addAll(cellGroups);
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * group's Name (Excel Name) ==> List&lt;groupId>
	 * 
	 * @return
	 */
	public Map<String, List<String>> getOrderedGroups() {
		if (orderedGroups == null) {
			orderedGroups = new HashMap<String, List<String>>();
		}
		return orderedGroups;
	}

	/**
	 * group's Name (Excel Name) ==> List&lt;groupId>
	 * 
	 * @param orderedGroups
	 */
	public void setOrderedGroups(Map<String, List<String>> orderedGroups) {
		this.orderedGroups = orderedGroups;
	}

	/**
	 * 获取cell数据，根据groupId
	 * 
	 * @param groupId
	 * @return
	 */
	public Map<String, CellValue> getCellValuesByGroupId(String groupId) {
		if (StringUtils.isBlank(groupId)) {
			return new HashMap<String, CellValue>(0);
		}
		Map<String, CellValue> _cellValues = new HashMap<String, CellValue>();
		for (CellValue c : this.cellValues) {
			if (StringUtils.equals(groupId, c.getGroupId())) {
				_cellValues.put(c.getName(), c);
			}
		}
		return _cellValues;
	}

	/**
	 * 获取cell数据
	 * 
	 * @param groupId
	 * @param conceptName
	 * @return
	 */
	public CellValue getCellValue(String groupId, String conceptName) {
		CellValue cellValue = null;
		if (StringUtils.isNotBlank(groupId)) {
			Map<String, CellValue> cellValues = getCellValuesByGroupId(groupId);
			if (cellValues != null && cellValues.containsKey(conceptName)) {
				cellValue = cellValues.get(conceptName);
			}
		} else {
			for (CellValue c : this.cellValues) {
				if (StringUtils.equals(c.getName(), conceptName)) {
					return c;
				}
			}
		}
		return cellValue;
	}

	public Map<String, CellGroup> getCellGroupMap() {
		Map<String, CellGroup> map = new HashMap<String, CellGroup>();
		if (cellGroups == null) {
			return map;
		}
		for (CellGroup cg : cellGroups) {
			map.put(cg.getId(), cg);
		}
		return map;
	}

	public String getCellGroupName(String parentId, String conceptName) {
		for (CellGroup g : this.getCellGroups()) {
			if (StringUtils.isNotBlank(conceptName)) {
				conceptName = conceptName.replaceAll("_", ":");
			}
			if (StringUtils.equals(parentId, g.getParentId())
					&& StringUtils.equals(conceptName, g.getConceptName())) {
				return g.getName();
			}
		}
		return "";
	}

	/**
	 * 将FormData对象转换为Map格式数据
	 * 
	 * 格式如下： { qspp_xxx : value, qspp_sss : value, qspp_yyy : { groupId1:{
	 * qspp_zzz:value, ... }, groupId2:{ qspp_zzz:value, ... } }}
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> adapterMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		for (CellValue e : this.cellValues) {
			if (e == null) {
				continue;
			}
			String name = e.getName();
			String value = e.getValue();
			String groupId = e.getGroupId();
			if (StringUtils.isBlank(groupId)) {
				map.put(name, value);
			} else {
				CellGroup group = this.getCellGroupMap().get(groupId);
				if (group == null) {
					continue;
				}
				String tupleName = StringUtils.replace(group.getConceptName(),
						":", "_");
				Object obj = map.get(tupleName);
				Map<String, Map<String, String>> childrenMap = null;
				if (obj != null) {
					childrenMap = (Map<String, Map<String, String>>) obj;
				} else {
					childrenMap = new HashMap<String, Map<String, String>>();
					map.put(tupleName, childrenMap);
				}

				Map<String, String> ccMap = childrenMap.get(groupId);
				if (ccMap == null) {
					ccMap = new HashMap<String, String>();
					childrenMap.put(groupId, ccMap);
				}
				ccMap.put(name, value);
			}
		}
		return map;
	}

	/**
	 * 获取指定元素值
	 * 
	 * @param conceptName
	 * @return
	 */
	public String getCellValue(String conceptName) {
		CellValue value = this.getCellValue("", conceptName);
		if (value == null) {
			return "";
		}
		return value.getValue();
	}

}
