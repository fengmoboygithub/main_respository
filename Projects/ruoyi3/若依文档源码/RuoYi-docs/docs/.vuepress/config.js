module.exports = {
	title : 'RuoYi',
	description : '使用若依快速构建web应用程序',
	port : 3000,
	head : [
		[
			'link', {
				rel : 'icon',
				href : '/images/favicon.ico'
			}

		],
		[
			'link', {
				rel : 'stylesheet',
				href : '/css/ruoyi.css'
			}
		],
		[
			'script', {
				charset : 'utf-8',
				src : '/js/ruoyi.js'
			}
		]
	],
	base : '',
	markdown : {
		lineNumbers : true // 代码块是否显示行号
	},
	themeConfig : {
		sidebarDepth : 3,
		algolia : {
			// 使用官方注册key无需appId
			appId: 'YDP9KZMGO2',
			// 官方注册默认 key 017ae7acde5e01882ca2985797787d06
			apiKey : 'c841514e21bbde012990423504390975',
			indexName : 'ruoyi',
			algoliaOptions : {
				hitsPerPage : 5,
				facetFilters : ""
			}
		},
		nav : [// 导航栏配置
			{
				text : '文档',
				link : '/ruoyi/'
			}, {
				text : '前后端分离',
				link : '/ruoyi-vue/'
			}, {
				text : '生态系统',
				items : [{
						text : '帮助',
						items : [{
								text : '我要提问',
								link : 'https://gitee.com/y_project/RuoYi/issues'
							}, {
								text : '常见问题',
								link : '/ruoyi/other/faq'
							}, {
								text : '加入QQ群',
								link : 'https://jq.qq.com/?_wv=1027&k=56vYdle'
							}
						]
					}, {
						text : '项目扩展',
						items : [{
								text : 'Oracle版本（同步）',
								link : 'https://github.com/yangzongzhuan/RuoYi-Oracle'
							}, {
								text : 'SQLServer版本',
								link : 'https://gitee.com/gzizi/RuoYi-Sqlserver'
							}, {
								text : 'Ant-Design-Vue微服务',
								link : 'https://gitee.com/zhangmrit/ruoyi-cloud'
							}, {
								text : 'Activiti工作流',
								link : 'https://gitee.com/calvinhwang123/RuoYi-Process'
							}, {
								text : 'Jwt版本',
								link : 'https://gitee.com/zhangmrit/RuoYi'
							}, {
								text : 'Cloud版本',
								link : 'https://gitee.com/aimeng2017/RuoYi-plus/tree/master'
							}, /** {
								text : '供货商城系统',
								link : 'https://gitee.com/guchengwuyue/supplierShop'
							}, */ /** {
								text : 'SaaS多租户',
								link : 'https://gitee.com/justime/stone'
							}, */ {
								text : 'Mybatis Plus版本',
								link : 'https://gitee.com/clazz/Ruoyi4.0'
							}, {
								text : 'Layui版本',
								link : 'https://github.com/kongshanxuelin/ruoyiplus'
							}, {
								text : 'Beetl版本',
								link : 'https://gitee.com/iterking/RuoYi-Beetl'
							}, {
								text : 'Redis版本（rz7c）',
								link : 'https://pan.baidu.com/s/1tPRlL3dLy82qWDYFps4cwg'
							}, {
								text : '微信公众号版本',
								link : 'https://github.com/Thinkingcao/silence-boot'
							}, {
								text : '更多扩展（欢迎大家提交分享）',
								link : '/ruoyi/document/xmkz'
							}
						]
					}
				]
			}, {
				text : 'GitHub',
				link : 'https://github.com/yangzongzhuan/RuoYi'
			}, {
				text : 'Gitee',
				link : 'https://gitee.com/y_project/RuoYi'
			}
		],
		sidebar : {
			'/ruoyi/' : [{
					title : '文档',
					collapsable : false,
					children : [
						'',
						'document/kslj',
						'document/hjbs',
						'document/xmjs',
						'document/htsc',
						'document/qdsc',
						'document/zjwd',
						'document/xmkz',
						'document/spjc'
					]
				}, {
					title : '其它',
					collapsable : false,
					children : [
						'other/faq',
						'other/donate'
					]
				}
			],
			'/ruoyi-vue/' : [{
					title : '文档',
					collapsable : false,
					children : [
						'',
						'document/kslj',
						'document/hjbs',
						'document/xmjs',
						'document/htsc',
						'document/qdsc',
						'document/zjwd',
						'document/xmkz',
						'document/spjc'
					]
				}, {
					title : '其它',
					collapsable : false,
					children : [
						'other/faq',
						'other/donate'
					]
				}
			]

		}
	}
};