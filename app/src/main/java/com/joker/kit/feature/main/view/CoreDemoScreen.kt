package com.joker.kit.feature.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.joker.kit.core.designsystem.theme.AppTheme
import com.joker.kit.core.designsystem.theme.SpacePaddingLarge
import com.joker.kit.core.designsystem.theme.SpaceVerticalMedium
import com.joker.kit.feature.main.component.DemoCard
import com.joker.kit.feature.main.data.DemoCardData
import com.joker.kit.feature.main.model.DemoCardInfo
import com.joker.kit.feature.main.viewmodel.CoreDemoViewModel

/**
 * Core Demo 路由
 *
 * @param viewModel Core Demo ViewModel
 */
@Composable
internal fun CoreDemoRoute(
    viewModel: CoreDemoViewModel = hiltViewModel()
) {
    val cards by viewModel.cards.collectAsState()
    CoreDemoScreen(cards = cards)
}

/**
 * Core Demo 界面
 *
 * @param cards Demo 卡片列表
 */
@Composable
internal fun CoreDemoScreen(
    cards: List<DemoCardInfo> = emptyList()
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(SpacePaddingLarge),
        verticalArrangement = Arrangement.spacedBy(SpaceVerticalMedium)
    ) {
        items(cards) { info ->
            DemoCard(info = info)
        }
    }
}

/**
 * Core Demo 浅色预览
 */
@Preview(showBackground = true)
@Composable
private fun CoreDemoPreview() {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            CoreDemoScreen(cards = DemoCardData.coreCards)
        }
    }
}

/**
 * Core Demo 深色预览
 */
@Preview(showBackground = true)
@Composable
private fun CoreDemoPreviewDark() {
    AppTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            CoreDemoScreen(cards = DemoCardData.coreCards)
        }
    }
}
