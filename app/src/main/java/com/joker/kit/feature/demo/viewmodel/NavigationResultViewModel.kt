package com.joker.kit.feature.demo.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import com.joker.kit.navigation.results.DemoResult
import com.joker.kit.navigation.results.DemoResultKey
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 结果回传示例页 ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 用户状态
 * @author Joker.X
 */
@HiltViewModel
class NavigationResultViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {
    /**
     * 回传结果并返回上一页
     *
     * @author Joker.X
     */
    fun sendResultAndBack() {
        popBackStackWithResult(
            DemoResultKey,
            DemoResult(id = 9527, message = "这是回传的结果")
        )
    }
}
