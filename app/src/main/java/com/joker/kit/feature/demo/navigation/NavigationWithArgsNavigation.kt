package com.joker.kit.feature.demo.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.demo.view.NavigationWithArgsRoute
import com.joker.kit.navigation.routes.DemoRoutes

/**
 * 带参跳转示例页面导航
 *
 * @param sharedTransitionScope 共享转场作用域
 * @author Joker.X
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.navigationWithArgsScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<DemoRoutes.NavigationWithArgs> {
        NavigationWithArgsRoute()
    }
}
