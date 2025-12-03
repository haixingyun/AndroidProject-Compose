package com.joker.kit.feature.demo.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import com.joker.kit.navigation.routes.DemoRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 带参跳转示例页 ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 用户状态
 * @param savedStateHandle 路由参数存储
 * @author Joker.X
 */
@HiltViewModel
class NavigationWithArgsViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    savedStateHandle: SavedStateHandle
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {
    /**
     * 路由参数
     *
     * @return 路由解析结果
     * @author Joker.X
     */
    private val route = savedStateHandle.toRoute<DemoRoutes.NavigationWithArgs>()

    /**
     * 商品ID
     *
     * @return 传递的商品 ID
     * @author Joker.X
     */
    val goodsId: Long = route.goodsId
}
