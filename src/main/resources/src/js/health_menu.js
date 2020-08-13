/**
 * 父菜单校验
   如果是父菜单
   level = 1 一级菜单
   父菜单id不能写
 */
function parentMenu(level) {
 if(level == 1){
    return true;
 }

}

/**
 * 子菜单校验
   如果是子菜单
   level = 2 二级菜单
   父菜单id必须写
 */
function ChaildrenMenu(level) {
    if(level == 2){
        return true;
    }
}