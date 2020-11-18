// 底稿相关功能路由
const manuscript = [
    //************************** 项目类型管理 ***********************************
    {
        path: '/projectTypeManagementSelect',
        component: () => import('@/components/page/projecttype/Select.vue'),
        meta: { title: '项目类型管理' }
    },
    {
        path: '/projectTypeManagementAdd',
        component: () => import('@/components/page/projecttype/Add.vue'),
        meta: { title: '新增项目类型' }
    },
    {
        path: '/projectTypeManagementUpdate',
        component: () => import('@/components/page/projecttype/Update.vue'),
        meta: { title: '编辑项目类型' }
    },
    //************************** 项目阶段管理 ***********************************
    {
        path: '/projectStageManagementSelect',
        component: () => import('@/components/page/projectstage/Select.vue'),
        meta: { title: '项目阶段管理' }
    },
    {
        path: '/projectStageManagementAdd',
        component: () => import('@/components/page/projectstage/Add.vue'),
        meta: { title: '新增项目阶段' }
    },
    {
        path: '/projectStageManagementUpdate',
        component: () => import('@/components/page/projectstage/Update.vue'),
        meta: { title: '编辑项目阶段' }
    },
    //************************** 项目底稿管理 ***********************************
    {
        path: '/projectManagementSelect',
        component: () => import('@/components/page/projectmanuscript/Select.vue'),
        meta: { title: '项目底稿管理' }
    },
    {
        path: '/projectManagementAdd',
        component: () => import('@/components/page/projectmanuscript/Add.vue'),
        meta: { title: '新增项目' }
    },
    {
        path: '/projectManagementLookup',
        component: () => import('@/components/page/projectmanuscript/Lookup.vue'),
        meta: { title: '查看项目' }
    },
    {
        path: '/projectManagementUpdate',
        component: () => import('@/components/page/projectmanuscript/Update.vue'),
        meta: { title: '编辑项目' }
    },
    {
        path: '/projectManagementView',
        component: () => import('@/components/page/projectmanuscript/View.vue'),
        meta: { title: '查看底稿' }
    },
    {
        path: '/projectManagementExamine1',
        component: () => import('@/components/page/projectmanuscript/Examine1.vue'),
        meta: { title: '项目组审核底稿' }
    },
    {
        path: '/projectManagementExamine2',
        component: () => import('@/components/page/projectmanuscript/Examine2.vue'),
        meta: { title: '质检审核底稿' }
    },
    {
        path: '/projectManagementExamine3',
        component: () => import('@/components/page/projectmanuscript/Examine3.vue'),
        meta: { title: '内核发起' }
    },
    {
        path: '/projectManagementExamine4',
        component: () => import('@/components/page/projectmanuscript/Examine4.vue'),
        meta: { title: '内核审核底稿' }
    },
    {
        path: '/projectManagementExamine5',
        component: () => import('@/components/page/projectmanuscript/Examine5.vue'),
        meta: { title: '内核结束' }
    },
    {
        path: '/projectManagementUpload',
        component: () => import('@/components/page/projectmanuscript/Upload.vue'),
        meta: { title: '上传底稿' }
    },
    {
        path: '/projectManagementExport',
        component: () => import('@/components/page/projectmanuscript/Export.vue'),
        meta: { title: '监管报送' }
    },
    //************************** 基础目录管理 ***********************************
    {
        path: '/baseDirManagementSelect',
        component: () => import('@/components/page/baseDir/Select.vue'),
        meta: { title: '基础目录管理' }
    },
    //************************** 底稿文件检索 ***********************************
    {
        path: '/esManagementSelect',
        component: () => import('@/components/page/es/Select.vue'),
        meta: { title: '底稿文件检索' }
    },
    {
        path: '/esManagementLookup',
        component: () => import('@/components/page/es/Lookup.vue'),
        meta: { title: '查看文件' }
    },

    //************************** 流程设计管理 ***********************************
    {
        path: '/processManagementUpdate',
        component: () => import('@/components/page/process/Update.vue'),
        meta: { title: '流程设计'}
    },
    {
        path: '/processManagementSelect',
        component: () => import('@/components/page/process/Select.vue'),
        meta: { title: '流程设计管理'}
    },

    //************************** 消息管理 ***********************************
    {
        path: '/msgManagementSelect',
        component: () => import('@/components/page/msg/Select.vue'),
        meta: { title: '消息管理' }
    },
    {
        path: '/msgManagementAdd',
        component: () => import('@/components/page/msg/Add.vue'),
        meta: { title: '新增消息' }
    },
    {
        path: '/msgManagementUpdate',
        component: () => import('@/components/page/msg/Update.vue'),
        meta: { title: '编辑消息' }
    },
    {
        path: '/msgManagementPublish',
        component: () => import('@/components/page/msg/Publish.vue'),
        meta: { title: '发布消息' }
    },
    {
        path: '/msgManagementRecall',
        component: () => import('@/components/page/msg/Recall.vue'),
        meta: { title: '撤回消息' }
    },
]

export default manuscript
