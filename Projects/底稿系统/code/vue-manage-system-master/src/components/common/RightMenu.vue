<template>
  <div class="example">
    <v-contextmenu ref="contextmenu" :theme="theme">
      <v-contextmenu-item
        @click="item.onClick"
        v-for="item of list"
        :key="item.id">
        {{ item.label }}
      </v-contextmenu-item>
      <v-contextmenu-submenu 
        v-for="item of subList"
        :key="item.id"
        :title="item.label">
        <v-contextmenu-item
          @click="subItem.onClick"
          v-for="subItem of item.subList"
          :key="subItem.id">
          {{ subItem.label }}
        </v-contextmenu-item>
      </v-contextmenu-submenu>
    </v-contextmenu>
  </div>
</template>

<script>
  export default {
    name: 'RightMenu',
    props: {
      theme: {
        type: String,
        require: false,
        default: function(){
          return "default";
        }
      },
      list: {
        type: Array,
        require: true,
        default: function(){
          return []
        }
      },
      subList: {
        type: Array,
        require: false,
        default: function() {
          return []
        }
      }
    },
    data () {
      return {
      }
    },
    methods: {
      //鼠标处显示
      handleShow (evt) {
        const postition = {
          top : evt.clientY - 0,
          left: evt.clientX - 0
        }
        // eslint-disable-next-line no-console
        console.log(postition);
        this.$refs.contextmenu.show(postition);
        setTimeout(() => {
          let _that = document.querySelector(".v-contextmenu");
          _that.style.display = "";
        },0);

      },
      //隐藏
      handleHide() {
        this.$refs.contextmenu.hide();
        setTimeout(() => {
          let _that = document.querySelector(".v-contextmenu");
          _that.style.display = "none";
        },0);
      },
    },
  }
</script>

<style lang="stylus" scoped>
  main-color = #46a0fc
  main-color-bright = #ef5350
  .buttons
    padding: 5px 10px
    border-left: 1px solid main-color
    border-right: 1px solid main-color
    background-color: #fff
    &.bright
      border-color: main-color-bright
  .box
    position: relative
    width: 100%
    height: 120px
    line-height: 120px
</style>