package com.joker.kit.feature.main.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * 主界面 ViewModel
 *
 * @param navigator 导航控制器
 * @param userState 全局用户状态
 * @author Joker.X
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    /**
     * 切换底部导航 tab
     */
    fun selectTab(tab: MainTab) {
        if (tab == _uiState.value.currentTab) return
        _uiState.value = _uiState.value.copy(currentTab = tab)
    }
}

/**
 * Main 页面 UI 状态
 *
 * @param currentTab 当前底部栏 tab
 */
data class MainUiState(
    val currentTab: MainTab = MainTab.Core
)

/**
 * Main 页面底部栏 Tab
 */
enum class MainTab(val title: String) {
    Core("Core"),
    Navigation("Navigation");

    val index: Int get() = ordinal

    companion object {
        val allTabs: List<MainTab> = values().toList()

        fun fromIndex(index: Int): MainTab {
            return allTabs.getOrElse(index) { Core }
        }
    }
}
