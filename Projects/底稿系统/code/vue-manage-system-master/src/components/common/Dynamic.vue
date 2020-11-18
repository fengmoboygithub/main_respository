<template>
  <div class="example">
    <v-contextmenu ref="contextmenu" :theme="theme">
      <v-contextmenu-item
        @click="item.onClick"
        v-for="item of list"
        :key="item.id">
        {{ item.label }}
      </v-contextmenu-item>
    </v-contextmenu>

    <div :class="['box', theme]" v-for="item of list" :key="item.id" v-contextmenu:contextmenu>
      右键点击此区域（点击菜单动态改变）
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Dynamic',
    props: {
      theme: String,
    },
    data () {
      return {
        list: [{
          id: 0,
          label: 'Menu 0',
          onClick: this.handleClick_0,
        }, {
          id: 1,
          label: 'Menu 1',
          onClick: this.handleClick_1,
        }, {
          id: 2,
          label: 'Menu 2',
          onClick: this.handleClick_2,
        }],
      }
    },
    methods: {
      // eslint-disable-next-line no-unused-vars
      handleClick (vm, event) {
        if (this.list.length === 3) {
          this.list.push({
            id: 3,
            label: 'Menu 3',
            onClick: this.handleClick,
          })
        } else {
          this.list.pop()
        }
      },
      // eslint-disable-next-line no-unused-vars
      handleClick_0 (vm, event) {
        // eslint-disable-next-line no-console
        console.log('Menu 0被点击了。。。');
      },
      // eslint-disable-next-line no-unused-vars
      handleClick_1 (vm, event) {
        // eslint-disable-next-line no-console
        console.log('Menu 1被点击了。。。');
      },
      // eslint-disable-next-line no-unused-vars
      handleClick_2 (vm, event) {
        // eslint-disable-next-line no-console
        console.log('Menu 2被点击了。。。');
      },
    },
  }
</script>

<style scoped>
  .box {
    width: 100%;
  }
</style>