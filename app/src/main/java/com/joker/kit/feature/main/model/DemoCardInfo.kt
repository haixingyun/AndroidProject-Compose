package com.joker.kit.feature.main.model

/**
 * Demo 卡片信息
 *
 * @param title 标题
 * @param description 描述内容
 * @param route 跳转路由
 * @author Joker.X
 */
data class DemoCardInfo(
    val title: String,
    val description: String,
    val route: Any? = null
)
