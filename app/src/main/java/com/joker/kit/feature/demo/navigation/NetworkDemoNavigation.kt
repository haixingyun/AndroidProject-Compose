package com.joker.kit.feature.demo.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.demo.view.NetworkDemoRoute
import com.joker.kit.navigation.routes.DemoRoutes

/**
 * Network Demo 页面导航
 *
 * @param sharedTransitionScope 共享转场作用域
 * @author Joker.X
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.networkDemoScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<DemoRoutes.NetworkDemo> {
        NetworkDemoRoute()
    }
}
