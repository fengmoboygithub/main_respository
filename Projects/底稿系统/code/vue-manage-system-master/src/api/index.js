import request from '../utils/request';
import srequest from '../utils/system-request';
import configMe from "@/config";
export default {
	/********************************* 测试例子 ******************************/
	fetchData: query => {
		return request({
			baseURL: '',
			url: './table.json',
			method: 'get',
			params: query
		});
	},
	/********************************* 登录 ******************************/
	// 登录
	login_getUser: query => {
		return request({
			url: '/UserControl/getUserInfo',
			method: 'post',
			params: query
		});
	},
	// 跨终端登录
	system_login: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/user/login',
			method: 'get',
			params: query
		});
	},
	// 根据userid获取用户信息，来获取roleid
	user_selectUserById: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/user/selectUserById',
			method: 'get',
			params: query
		});
	},
	// 根据roleid获取菜单树
	menu_selectMenusByRole: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: `/api/system/menu/selectMenusByRole/${query.roleId}`,
			method: 'get',
			params: query
		});
	},
	/********************************* 数据项管理接口 ******************************/
	// 唯一性验证
	checkDataGatherNameUnique: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/dataitem/checkDataGatherNameUnique',
			method: 'post',
			params: query
		});
	},
	// 修改
	dataitem_edit: query => {
		return srequest({
            baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/dataitem/edit',
			method: 'post',
			params: query
		});
	},
	// 新增
	dataitem_insert: query => {
		return srequest({
            baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/dataitem/insert',
			method: 'post',
			params: query
		});
	},
	// 分页查询
	dataitem_select: query => {
		return srequest({
            baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/dataitem/selectDataGatherList',
			method: 'post',
			data: query
		});
	},
	/********************************* 用户管理接口 ******************************/
	// 分页查询
	user_selectUserList: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/user/selectUserList',
			method: 'post',
			data: query
		});
	},
	// 登录名唯一性验证
	user_checkLoginNameUnique: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/user/checkLoginNameUnique',
			method: 'get',
			params: query
		});
	},
	// 修改
	user_updateUser: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/user/updateUser',
			method: 'post',
			data: query
		});
	},
	// 保存用户信息
	user_insertUser: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/user/insertUser',
			method: 'post',
			data: query
		});
	},
	// 批量删除用户
	user_deleteUserByIds: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/user/deleteUserByIds',
			method: 'get',
			params: query
		});
	},
	/********************************* 角色管理接口 ******************************/
	// 根据ID查询角色信息
	role_selectRoleById: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/role/selectRoleById',
			method: 'get',
			params: query
		});
	},
	// 根据ID删除角色信息
	role_deleteRoleById: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/role/deleteRoleById',
			method: 'get',
			params: query
		});
	},
	// 分页查询
	role_selectRoleList: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/role/selectRoleList',
			method: 'post',
			data: query
		});
	},
	// 修改
	role_updateRole: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/role/updateRole',
			method: 'post',
			data: query
		});
	},
	// 新增
	role_insertRole: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/role/insertRole',
			method: 'post',
			data: query
		});
	},
	// 角色名唯一性验证
	role_checkRoleNameUnique: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/role/checkRoleNameUnique',
			method: 'post',
			params: query
		});
	},
	/********************************* 菜单管理接口 ******************************/
	// 查询
	menu_selectMenuList: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/menu/selectMenuList',
			method: 'post',
			params: query
		});
	},
	// 查询
	menu_selectMenuAll: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/menu/selectMenuAll',
			method: 'post',
			data: query
		});
	},
	// 新增
	menu_insertMenu: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/menu/insertMenu',
			method: 'post',
			data: query
		});
	},
	// 修改
	menu_updateMenu: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/menu/updateMenu',
			method: 'post',
			data: query
		});
	},
	// 删除menuId
	menu_deleteMenuById: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: `/api/system/menu/deleteMenuById/${query.menuId}`,
			method: 'get',
			params: query
		});
	},
	// 查询menuId
	menu_selectMenuById: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: `/api/system/menu/selectMenuById/${query.menuId}`,
			method: 'get',
			params: query
		});
	},
	// 校验菜单名称是否唯一
	menu_checkMenuNameUnique: query => {
		return srequest({
			baseURL: configMe.SYSTEM_BASEURL,
			url: '/api/system/menu/checkMenuNameUnique',
			method: 'post',
			params: query
		});
	},
	/********************************* 流程相关的接口信息 ******************************/
	// 项目类型信息查询
	projectInfo_getListByPage: query => {
		return request({
			url: '/ProjectTypeInfo/getListByPage',
			method: 'post',
			params: query
		});
	},
	// 项目阶段信息查询
	ProcessInfo_getStageByType: query => {
		return request({
			url: '/ProcessInfo/getStageByType',
			method: 'post',
			params: query
		});
	},
	// 流程节点列表信息查询
	ProcessInfo_getProcessNodeList: query => {
		return request({
			url: '/ProcessInfo/getProcessNodeList',
			method: 'post',
			params: query
		});
	},
    // 流程列表信息查询
    ProcessInfo_getProcessList: query => {
		return request({
			url: '/ProcessInfo/getProcessList',
            method: 'post',
            params: query
        });
	},
	// 流程图像数据查询
    ProcessInfo_getGraphInfo: query => {
		return request({
			url: '/ProcessInfo/getGraphInfo',
            method: 'post',
            params: query
        });
    },
	// 保存流程图像数据
	ProcessInfo_saveGraphInfo: data => {
		return request({
			url: '/ProcessInfo/saveGraphInfo',
			method: 'post',
			data: data
		});
	},
	/********************************* 待办信息 ******************************/
	//分页查询待办信息
	getListByPageForDealt_ProjectInfo: query => {
		return request({
			url: '/ProjectInfo/getListByPageForDealt',
			method: 'post',
			params: query
		});
	},
	/********************************* 底稿信息 ******************************/
	//底稿信息查看接口
	get_ManuscriptInfo: query => {
		return request({
			url: '/ManuscriptInfo/get',
			method: 'post',
			params: query
		});
	},
	//获取该项目目录下该用户上传的底稿信息查询接口
	viewManuscriptListByUserId: query => {
		return request({
			url: '/ManuscriptInfo/viewManuscriptListByUserId',
			method: 'post',
			params: query
		});
	},
	//底稿信息上传及录入接口
	add_ManuscriptInfo: data => {
		return request({
			url: '/ManuscriptInfo/upload',
			method: 'post',
			data: data
		});
	},
	//修改底稿信息接口
	update_ManuscriptInfo: data => {
		return request({
			url: '/ManuscriptInfo/update',
			method: 'put',
			data: data
		});
	},
	//底稿信息删除接口
	del_ManuscriptInfo: query => {
		return request({
			url: '/ManuscriptInfo/del',
			method: 'delete',
			params: query
		});
	},
	/********************************* 项目目录树 ******************************/
	//项目目录树含底稿文件(适用)展示接口
	viewTree: query => {
		return request({
			url: '/ProjectDirectory/viewTree',
			method: 'post',
			params: query
		});
	},
	//项目目录树含底稿文件(全部)展示接口
	viewTreeForMe: query => {
		return request({
			url: '/ProjectDirectory/viewTreeForMe',
			method: 'post',
			params: query
		});
	},
	//项目目录树用于导出某时间节点的数据展示接口
	viewTreeForExport: query => {
		return request({
			url: '/ProjectDirectory/viewTreeForExport',
			method: 'post',
			params: query
		});
	},
	/********************************* 项目目录信息 ******************************/
	//查询项目目录信息详情
	get_ProjectDirectory: query => {
		return request({
			url: '/ProjectDirectory/get',
			method: 'post',
			params: query
		});
	},
	//项目目录名称或简称查询唯一性
	getNameOrSnameForOnly_ProjectDirectory: query => {
		return request({
			url: '/ProjectDirectory/getNameOrSnameForOnly',
			method: 'post',
			params: query
		});
	},
	//新增项目目录信息数据
	add_ProjectDirectory: data => {
		return request({
			url: '/ProjectDirectory/add',
			method: 'post',
			data: data
		});
	},
	//修改项目目录信息数据
	update_ProjectDirectory: data => {
		return request({
			url: '/ProjectDirectory/update',
			method: 'put',
			data: data
		});
	},
	//删除项目目录信息数据
	del_ProjectDirectory: query => {
		return request({
			url: '/ProjectDirectory/delDirctoryById',
			method: 'delete',
			params: query
		});
	},
	// //监管报送--项目目录信息数据
	// export_ProjectDirectory: query => {
	// 	return request({
	// 		url: '/ProjectDirectory/export',
	// 		method: 'get',
	// 		responseType: 'blob',
	// 		params: query,
	// 		headers: {'content-type': 'application/zip;charset=UTF-8'},
	// 	});
	// },
	//项目目录信息数据--适用性修改
	updateIsapp_ProjectDirectory: query => {
		return request({
			url: '/ProjectDirectory/updateIsapp',
			method: 'put',
			params: query
		});
	},
	/********************************* 项目类型信息 ******************************/
	//分页查询项目类型信息
	getListByPage_ProjectTypeInfo: query => {
		return request({
			url: '/ProjectTypeInfo/getListByPage',
			method: 'post',
			params: query
		});
	},
	//项目类型名称查询唯一性
	getTypeNameForOnly_ProjectTypeInfo: query => {
		return request({
			url: '/ProjectTypeInfo/getTypeNameForOnly',
			method: 'post',
			params: query
		});
	},
	//查询项目类型信息详情
	get_ProjectTypeInfo: query => {
		return request({
			url: '/ProjectTypeInfo/get',
			method: 'post',
			params: query
		});
	},
	//新增项目类型信息数据
	add_ProjectTypeInfo: data => {
		return request({
			url: '/ProjectTypeInfo/add',
			method: 'post',
			data: data
		});
	},
	//修改项目类型信息数据
	update_ProjectTypeInfo: data => {
		return request({
			url: '/ProjectTypeInfo/update',
			method: 'put',
			data: data
		});
	},
	//删除项目类型信息数据
	del_ProjectTypeInfo: query => {
		return request({
			url: '/ProjectTypeInfo/del',
			method: 'delete',
			params: query
		});
	},
	/********************************* 项目阶段信息 ******************************/
	//同一项目类型下项目阶段ID查询唯一性
	getStageIdForOnly_ProjectStageInfo: query => {
		return request({
			url: '/ProjectStageInfo/getStageIdForOnly',
			method: 'post',
			params: query
		});
	},
	//同一项目类型下项目阶段名称查询唯一性
	getStageNameForOnly_ProjectStageInfo: query => {
		return request({
			url: '/ProjectStageInfo/getStageNameForOnly',
			method: 'post',
			params: query
		});
	},
	//分页查询项目阶段信息
	getListByPage_ProjectStageInfo: query => {
		return request({
			url: '/ProjectStageInfo/getListByPage',
			method: 'post',
			params: query
		});
	},
	//根据项目类型查询最小项目阶段信息
	getListByMin_ProjectStageInfo: query => {
		return request({
			url: '/ProjectStageInfo/getListByMin',
			method: 'post',
			params: query
		});
	},
	//查询项目阶段信息详情
	get_ProjectStageInfo: query => {
		return request({
			url: '/ProjectStageInfo/get',
			method: 'post',
			params: query
		});
	},
	//新增项目阶段信息数据
	add_ProjectStageInfo: data => {
		return request({
			url: '/ProjectStageInfo/add',
			method: 'post',
			data: data
		});
	},
	//修改项目阶段信息数据
	update_ProjectStageInfo: data => {
		return request({
			url: '/ProjectStageInfo/update',
			method: 'put',
			data: data
		});
	},
	//删除项目阶段信息数据
	del_ProjectStageInfo: query => {
		return request({
			url: '/ProjectStageInfo/del',
			method: 'delete',
			params: query
		});
	},
	/********************************* 项目信息 ******************************/
	//分页查询项目信息
	getListByPage_ProjectInfo: query => {
		return request({
			url: '/ProjectInfo/getListByPage',
			method: 'post',
			params: query
		});
	},
	//查询项目信息详情
	get_ProjectInfo: query => {
		return request({
			url: '/ProjectInfo/get',
			method: 'post',
			params: query
		});
	},
	//同一项目下项目名称或编号查询唯一性
	getProjectForOnly_ProjectInfo: query => {
		return request({
			url: '/ProjectInfo/getProjectForOnly',
			method: 'post',
			params: query
		});
	},
	//新增项目信息数据
	add_ProjectInfo: data => {
		return request({
			url: '/ProjectInfo/add',
			method: 'post',
			data: data
		});
	},
	//修改项目信息数据
	update_ProjectInfo: data => {
		return request({
			url: '/ProjectInfo/update',
			method: 'put',
			data: data
		});
	},
	/********************************* 项目人员信息 ******************************/
	//分页查询项目人员信息数据(从统一用户系统获取)
	getListByPageForUserSys_PersonnelInfo: query => {
		return request({
			url: '/PersonnelInfo/getListByPageForUserSys',
			method: 'post',
			params: query
		});
	},
	//分页查询项目人员信息
	getListByPage_PersonnelInfo: query => {
		return request({
			url: '/PersonnelInfo/getListByPage',
			method: 'post',
			params: query
		});
	},
	//查询项目人员信息详情
	get_PersonnelInfo: query => {
		return request({
			url: '/PersonnelInfo/get',
			method: 'post',
			params: query
		});
	},
	//新增项目人员信息数据
	add_PersonnelInfo: data => {
		return request({
			url: '/PersonnelInfo/add',
			method: 'post',
			data: data
		});
	},
	//修改项目人员信息数据
	update_PersonnelInfo: data => {
		return request({
			url: '/PersonnelInfo/update',
			method: 'put',
			data: data
		});
	},
	/********************************* 基础目录信息 ******************************/
	//基础目录树含底稿文件(全部)展示接口
	baseViewTreeForMe: query => {
		return request({
			url: '/BaseDirectory/viewTreeForMe',
			method: 'post',
			params: query
		});
	},
	//基础目录名称或简称查询唯一性
	getNameOrSnameForOnly_BaseDirectory: query => {
		return request({
			url: '/BaseDirectory/getNameOrSnameForOnly',
			method: 'post',
			params: query
		});
	},
	//查询基础目录信息详情
	get_BaseDirectory: query => {
		return request({
			url: '/BaseDirectory/get',
			method: 'post',
			params: query
		});
	},
	//新增基础目录信息数据
	add_BaseDirectory: data => {
		return request({
			url: '/BaseDirectory/add',
			method: 'post',
			data: data
		});
	},
	//修改基础目录信息数据
	update_BaseDirectory: data => {
		return request({
			url: '/BaseDirectory/update',
			method: 'put',
			data: data
		});
	},
	//删除基础目录信息数据
	del_BaseDirectory: query => {
		return request({
			url: '/BaseDirectory/del',
			method: 'delete',
			params: query
		});
	},
	/********************************* 底稿文件搜索信息 ******************************/
	//底稿文件搜索展示接口
	searchByPage_Es: query => {
		return request({
			url: '/es/searchByPage',
			method: 'post',
			params: query
		});
	},
	/********************************* 页面流程节点映射数据操作接口 ******************************/
	//获取页面流程节点映射数据操作接口
	getList_PageProcessnodeMap: query => {
		return request({
			url: '/PageProcessnodeMap/getList',
			method: 'post',
			params: query
		});
	},
	/********************************* 流程处理信息或者发起内核 ******************************/
	//流程处理
	updateProcess_ProcessNodeInfo: data => {
		return request({
			url: '/ProcessNodeInfo/updateProcess',
			method: 'post',
			data: data
		});
	},
	/********************************* 历史意见信息 ******************************/
	//获取暂存的意见
	get_DirectoryOpinion: query => {
		return request({
			url: '/DirectoryOpinion/get',
			method: 'post',
			params: query
		});
	},
	//获取历史意见列表
	getListByPage_DirectoryOpinion: query => {
		return request({
			url: '/DirectoryOpinion/getListByPage',
			method: 'post',
			params: query
		});
	},
	/********************************* 内核历史意见信息 ******************************/
	//获取内核历史意见列表
	getListByPage_InternalAuditReviewResult: query => {
		return request({
			url: '/InternalAuditReviewResult/getListByPage',
			method: 'post',
			params: query
		});
	},
	/********************************* 内核--同意或不同意 ******************************/
	//内核--同意或不同意
	add_InternalAuditReviewResult: query => {
		return request({
			url: '/InternalAuditReviewResult/add',
			method: 'post',
			params: query
		});
	},
	/********************************* 历史版本信息 ******************************/
	//获取历史版本信息列表
	getListByPage_ManuscriptVersion: query => {
		return request({
			url: '/ManuscriptVersion/getListByPage',
			method: 'post',
			params: query
		});
	},
	/********************************* 消息管理信息 ******************************/
	//查询消息信息
	getList_MessageCenter: query => {
		return request({
			url: '/MessageCenter/getList',
			method: 'post',
			params: query
		});
	},
	//分页查询消息信息
	getListByPage_MessageCenter: query => {
		return request({
			url: '/MessageCenter/getListByPage',
			method: 'post',
			params: query
		});
	},
	//查询消息信息详情
	get_MessageCenter: query => {
		return request({
			url: '/MessageCenter/get',
			method: 'post',
			params: query
		});
	},
	//新增消息信息数据
	add_MessageCenter: data => {
		return request({
			url: '/MessageCenter/add',
			method: 'post',
			data: data
		});
	},
	//修改消息信息数据
	update_MessageCenter: data => {
		return request({
			url: '/MessageCenter/update',
			method: 'put',
			data: data
		});
	},
	//删除消息信息数据
	del_MessageCenter: query => {
		return request({
			url: '/MessageCenter/del',
			method: 'delete',
			params: query
		});
	},
	/********************************* 消息中心信息 ******************************/
	//分页查询消息中心信息数据
	getListByPage_UserMessageRela: query => {
		return request({
			url: '/UserMessageRela/getListByPage',
			method: 'post',
			params: query
		});
	},
	//查询消息中心信息详情
	get_UserMessageRela: query => {
		return request({
			url: '/UserMessageRela/get',
			method: 'post',
			params: query
		});
	},
	//发布消息数据
	add_UserMessageRela: data => {
		return request({
			url: '/UserMessageRela/add',
			method: 'post',
			data: data
		});
	},
	//根据消息ID查询用户列表
	getUserListByMgId_UserMessageRela: query => {
		return request({
			url: '/UserMessageRela/getUserListByMgId',
			method: 'post',
			params: query
		});
	},
	//全部撤回消息
	reCallForAll_UserMessageRela: data => {
		return request({
			url: '/UserMessageRela/reCallForAll',
			method: 'post',
			data: data
		});
	},
	//部分撤回消息
	reCallForPart_UserMessageRela: data => {
		return request({
			url: '/UserMessageRela/reCallForPart',
			method: 'post',
			data: data
		});
	},
	//更新关系信息状态
	update_UserMessageRela: data => {
		return request({
			url: '/UserMessageRela/update',
			method: 'post',
			data: data
		});
	},
	//更新整体状态
	allChangeState_UserMessageRela: query => {
		return request({
			url: '/UserMessageRela/allChangeState',
			method: 'post',
			params: query
		});
	},
}
