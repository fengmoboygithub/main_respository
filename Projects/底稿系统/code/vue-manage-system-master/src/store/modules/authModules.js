import { _ } from '@/utils';
const authModuels = {
    namespaced: true,
    state: {
        buttonAuth: {},             // 按钮级别的权限，key为菜单对应的id，value为menuType == F的children数组
        menuId: '',
        buttonsAll: []              //当前用户拥有的所有按钮权限集
    },
    mutations: {
        // 合并buttonAuth
        // PUSHBUTTONAUTH(state, val){
        //     _.assign(state.buttonAuth, val)
        // },
        PUSHBUTTONSALL(state, array){
            //创建一个新数组，将array与任何数组 或 值连接在一起
            state.buttonsAll = _.concat(state.buttonsAll, array);
            //创建一个去重后的array数组副本。使用了 SameValueZero 做等值比较。只有第一次出现的元素才会被保留。
            _.uniqWith(state.buttonsAll, _.isEqual);
        },
        // 注销时清空
        CLEARBUTTONAUTH(state){
            state.buttonAuth = {};
            state.buttonsAll = [];
        },
        // 传递menuID
        SAVEMENUID(state, val){
            state.menuId = val
        }
    },
    actions: {
        //按菜单ID为key value为按钮数组存入
        // saveButtonAuth({commit}, arr){
        //     commit("PUSHBUTTONAUTH", arr)
        // },
        //当前用户拥有的所有按钮权限集
        saveButtonsAll({commit}, array){
            commit("PUSHBUTTONSALL", array)
        },
    }
}

export default authModuels
