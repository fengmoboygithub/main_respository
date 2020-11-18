const config = {
    development: {
        //前端服务的ip地址及端口
        ME_IP_INFO: '/',
        //api基本url
        API_BASEURL: 'api/',
        //同一用户管理基本url
        SYSTEM_BASEURL: 'system/',
        //api超时时间配置
        API_TIMEOUT: 500000,
        //auth基本url
        AUTH_BASEURL: 'auth/',
        //auth超时时间配置
        AUTH_TIMEOUT: 500000,
        //file基本url
        FILE_BASEURL: 'file/',
        //监管报送url
        EXPORT_URL: 'ProjectDirectory/export',
        //上传文件最大长度限制值
        FILE_UPLOAD_MAX_SIZE: 1024,
        //主题--侧边栏配置
        THEME:{
            BLACK:{
               SIDEBAR_BACKGROUND_COLOR:"#324157",
               SIDEBAR_TEXT_COLOR:"#bfcbd9",
            },
            GREEN:{
                SIDEBAR_BACKGROUND_COLOR:"#00d1b2",
                SIDEBAR_TEXT_COLOR:"#ffffff",
            },
            BLUE:{
                SIDEBAR_BACKGROUND_COLOR:"#2D8CC8",
                SIDEBAR_TEXT_COLOR:"#ffffff",
            }
        }
    },
    production: {
        //前端服务的ip地址及端口
        ME_IP_INFO: '/',
        //ME_IP_INFO: 'http://10.0.48.16:8080/',
        //api基本url
        API_BASEURL: 'api/',
        //同一用户管理基本url
        SYSTEM_BASEURL: 'system/',
        //api超时时间配置
        API_TIMEOUT: 500000,
        //auth基本url
        AUTH_BASEURL: 'auth/',
        //auth超时时间配置
        AUTH_TIMEOUT: 500000,
        //file基本url
        FILE_BASEURL: 'file/',
        //监管报送url
        EXPORT_URL: 'ProjectDirectory/export',
        //上传文件最大长度限制值
        FILE_UPLOAD_MAX_SIZE: 1024,
        //主题--侧边栏配置
        THEME:{
            BLACK:{
               SIDEBAR_BACKGROUND_COLOR:"#324157",
               SIDEBAR_TEXT_COLOR:"#bfcbd9",
            },
            GREEN:{
                SIDEBAR_BACKGROUND_COLOR:"#00d1b2",
                SIDEBAR_TEXT_COLOR:"#bfcbd9",
            },
            BLUE:{
                SIDEBAR_BACKGROUND_COLOR:"#2D8CC8",
                SIDEBAR_TEXT_COLOR:"#ffffff",
            }
        }
    }
};
var me_config = config.development;
if (process.env.NODE_ENV === 'production') {
    me_config = config.production;
}
export default me_config;


