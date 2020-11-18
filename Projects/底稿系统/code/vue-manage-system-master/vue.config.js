const path = require('path');

function resolve(dir) {
    return path.join(__dirname, dir)
  }
module.exports = {

    baseUrl: './',
    // 部署应用包时的基本 URL,用法和 webpack 本身的 output.publicPath 一致
    publicPath:'./',
    // 输出文件目录
    outputDir: 'dist',
    assetsDir: 'static',
    // 生产环境是否生成 sourceMap 文件
    lintOnSave: process.env.NODE_ENV === 'development',
    productionSourceMap: false,
    // webpack-dev-server 相关配置
    devServer: {
        // http 代理配置
        proxy: {
            '/system':{     // 统一账号管理接口地址
                target:'http://36.110.110.35:30010/tyzhapi',
                //target:'http://10.0.48.60:30010/tyzhapi',
                changeOrigin:true,
                pathRewrite:{
                    '^/system':''
                }
            },
            '/api':{
                //本地
                target:'http://127.0.0.1:8091/api',
                //34服务器
                //target:'http://10.0.48.34:8091/api',
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
    },
    
    // webpack相关配置
    chainWebpack(config) {
        config.plugins.delete('preload') // TODO: need test
        config.plugins.delete('prefetch') // TODO: need test
        config.resolve.alias
        .set('vue$', 'vue/dist/vue.esm.js')
        .set('@', resolve('./src'))
        // config
        //   // 插件名 
        //   .plugin('extract-css')
        //   // 修改规则
        //   .tap(args => {
        //     args[0].filename = 'css/styles.css'
        //     args[0].chunkFilename = 'css/[name].css'
        //     return args
        //   })
        // set svg-sprite-loader
        config.module
          .rule('svg')
          .exclude.add(resolve('src/icons'))
          .end()
        config.module
          .rule('icons')
          .test(/\.svg$/)
          .include.add(resolve('src/icons'))
          .end()
          .use('svg-sprite-loader')
          .loader('svg-sprite-loader')
          .options({
            symbolId: 'icon-[name]'
          })
          .end()
        // set preserveWhitespace
        config.module
          .rule('vue')
          .use('vue-loader')
          .loader('vue-loader')
          .tap(options => {
            options.compilerOptions.preserveWhitespace = true
            return options
          })
          .end()
    
        config
          // https://webpack.js.org/configuration/devtool/#development
          .when(process.env.NODE_ENV === 'development',
            config => config.devtool('cheap-source-map')
          )
    
        // config
        //   .when(process.env.NODE_ENV !== 'development',
        //     config => {
        //       config
        //         .plugin('ScriptExtHtmlWebpackPlugin')
        //         .after('html')
        //         .use('script-ext-html-webpack-plugin', [{
        //           // `runtime` must same as runtimeChunk name. default is `runtime`
        //           inline: /runtime\..*\.js$/
        //         }])
        //         .end()
        //       config
        //         .optimization.splitChunks({
        //           chunks: 'all',
        //           cacheGroups: {
        //             libs: {
        //               name: 'chunk-libs',
        //               test: /[\\/]node_modules[\\/]/,
        //               priority: 10,
        //               chunks: 'initial' // only package third parties that are initially dependent
        //             },
        //             elementUI: {
        //               name: 'chunk-elementUI', // split elementUI into a single package
        //               priority: 20, // the weight needs to be larger than libs and app or it will be packaged into libs or app
        //               test: /[\\/]node_modules[\\/]_?element-ui(.*)/ // in order to adapt to cnpm
        //             },
        //             commons: {
        //               name: 'chunk-commons',
        //               test: resolve('src/components'), // can customize your rules
        //               minChunks: 3, //  minimum common number
        //               priority: 5,
        //               reuseExistingChunk: true
        //             }
        //           }
        //         })
        //       config.optimization.runtimeChunk('single')
        //     }
        //   )
      },

    configureWebpack: (config) => {
        if (process.env.NODE_ENV === 'production') {
            // 生产环境
            config.mode = 'production'
        } else {
            // 开发环境
            config.mode = 'development'
        }
        config.output.libraryExport = 'default';
    },
    // 以下是pwa配置
    pwa: {
        iconPaths: {
            favicon32     : 'favicon.ico',
            favicon16     : 'favicon.ico',
            appleTouchIcon: 'favicon.ico',
            maskIcon      : 'favicon.ico',
            msTileImage   : 'favicon.ico'
        }
    }
}
