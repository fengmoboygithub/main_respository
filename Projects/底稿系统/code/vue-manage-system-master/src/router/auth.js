// 测试功能
const auth = [
    {
        path: '/configTest',
        component: () => import('@/views/configPage/ConfigPage.vue'),
        meta: { title: '配置测试'}
    },
    {
        path: '/editConfig',
        component: () => import('@/views/configPage/UpdateConfig.vue'),
        meta: { title: '编辑配置'}
    },
]

export default auth
