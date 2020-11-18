import Vue from 'vue'
import { VuepressZooming } from './VuepressZooming'

declare module 'vuepress-types/types/store' {
  interface VuePressStore {
    zooming: VuepressZooming
  }
}

export default {
  watch: {
    '$page.path'(this: Vue): void {
      if (typeof this.$vuepress.zooming === 'undefined') return
      this.$vuepress.zooming.updateDelay()
    },
  },

  mounted(this: Vue): void {
    this.$vuepress.zooming = new VuepressZooming()
    this.$vuepress.zooming.updateDelay()
  },
}
