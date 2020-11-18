import request from '../utils/auth-request';

export default {
	/********************************* 测试例子 ******************************/
	login: data => {
		return request({
			url: '/login',
			method: 'post',
			data: data
		});
	},
	logout: query => {
		return request({
			url: '/logout',
			method: 'get',
			params: query
		});
	}
}
