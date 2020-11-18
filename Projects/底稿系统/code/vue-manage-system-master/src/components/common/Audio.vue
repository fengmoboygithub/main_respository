<template>
  <div class='demo' :style="audioStyle">
        <aplayer :music="audio.music"></aplayer>
    </div>
</template>
<script>
import aplayer from 'vue-aplayer'
export default {
  components: {
    aplayer
  },
  props: {
    url: {
      type: String,
      require: true,
      default: function(){
        return {}
      }
    },
    audioStyle: {
      type: String,
      require: false,
      default: function(){
        return {}
      }
    },
  },
  data() {
    return {
      audio: {
          progress: false,
          progressPercent: 0,
          successPercent: 0,
          music: {
              title: '',
              artist: '',
              src: this.url,
              pic: '',
              //pic: '@/assets/img/audio.jpg'
          }
      },
    }
  }
}
</script>
<style scoped>
  .demo{
    width: 60%;
  }
</style>