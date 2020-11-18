import { Plugin } from 'vuepress-types'

// eslint-disable-next-line @typescript-eslint/no-var-requires
const path = require('path')

const SmoothScrollPlugin: Plugin = {
  name: 'vuepress-plugin-smooth-scroll',

  enhanceAppFiles: path.resolve(__dirname, 'enhanceApp.js'),

  clientRootMixin: path.resolve(__dirname, 'clientRootMixin.js'),
}

module.exports = SmoothScrollPlugin
