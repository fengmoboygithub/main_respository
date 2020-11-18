const path = require('path')

module.exports = {

    baseUrl: './',
    // 部署应用包时的基本 URL,用法和 webpack 本身的 output.publicPath 一致
    publicPath:'./',
    // 输出文件目录
    outputDir: 'dist',  
    assetsDir: 'static',
    // 生产环境是否生成 sourceMap 文件
    productionSourceMap: false,
    // webpack相关配置
    chainWebpack: (config) => {
    config.resolve.alias
        .set('vue$', 'vue/dist/vue.esm.js')
        .set('@', path.resolve(__dirname, './src'))
    },
    configureWebpack: (config) => {    
    if (process.env.NODE_ENV === 'production') {      
        // 生产环境
        config.mode = 'production'
    } else {      
        // 开发环境
        config.mode = 'development'
    }
    },  
    // webpack-dev-server 相关配置
    devServer: {
        // http 代理配置
        proxy: {
            '/api':{
                target:'http://127.0.0.1:8091/api',
                changeOrigin:true,
                pathRewrite:{
                    '^/api':''
                }
            },
            '/auth':{
                target:'http://127.0.0.1:9999/auth-server/auth',
                changeOrigin:true,
                pathRewrite:{
                    '^/auth':''
                }
            },
            '/file':{
                target:'http://127.0.0.1:8091/file',
                changeOrigin:true,
                pathRewrite:{
                    '^/file':''
                }
            },
        }
    }
}