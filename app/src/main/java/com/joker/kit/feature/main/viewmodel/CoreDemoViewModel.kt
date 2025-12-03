package com.joker.kit.feature.main.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.DemoCounterState
import com.joker.kit.core.state.UserState
import com.joker.kit.feature.main.data.DemoCardData
import com.joker.kit.feature.main.model.DemoCardInfo
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Core Demo ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 用户状态
 * @param counterState 计数器状态
 * @author Joker.X
 */
@HiltViewModel
class CoreDemoViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    counterState: DemoCounterState
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {

    private val _cards = MutableStateFlow(DemoCardData.coreCards)
    val cards: StateFlow<List<DemoCardInfo>> = _cards.asStateFlow()

    /**
     * 全局计数器值
     *
     * @return 计数器状态流
     * @author Joker.X
     */
    val count: StateFlow<Int> = counterState.count

    /**
     * 处理卡片点击
     *
     * @param info 被点击的卡片信息
     * @author Joker.X
     */
    fun onCardClick(info: DemoCardInfo) {
        info.route?.let { navigate(it) }
    }
}
