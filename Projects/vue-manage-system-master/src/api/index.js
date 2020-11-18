import request from '../utils/request';
/*
export const fetchData = query => {
    return request({
        url: './table.json',
        method: 'get',
        params: query
    });
};
*/
export default {
	/********************************* 测试例子 ******************************/
	fetchData: query => {
		return request({
			url: './table.json',
			method: 'get',
			params: query
		});
	},
	//底稿信息查看接口
	getManuscriptInfo: query => {
		return request({
			url: '/ManuscriptInfo/get',
			method: 'post',
			params: query
		});
	},
	//底稿信息上传及录入接口
	addManuscriptInfo: data => {
		return request({
			url: '/ManuscriptInfo/upload',
			method: 'post',
			data: data
		});
	},
	//项目目录树展示接口
	viewTree: query => {
		return request({
			url: '/ProjectDirectory/viewTree',
			method: 'post',
			params: query
		});
	},
}
