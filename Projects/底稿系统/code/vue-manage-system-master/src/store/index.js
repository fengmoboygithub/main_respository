import Vue from 'vue';
import Vuex from 'vuex';
import authModuels from './modules/authModules';
import createPersistedState from 'vuex-persistedstate';
Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    authModuels,
  },
  plugins: [createPersistedState({
    storage: window.sessionStorage,
    reducer(val) {
      //console.log('只储存state中的buttonsAll', val.authModuels.buttonsAll);
        return {
        // 只储存state中的buttonsAll
        buttonsAll: val.authModuels.buttonsAll
      }
   }
  })]
});

export default store;
