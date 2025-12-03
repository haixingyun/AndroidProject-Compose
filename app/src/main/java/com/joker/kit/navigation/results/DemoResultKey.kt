package com.joker.kit.navigation.results

import com.joker.kit.navigation.NavigationResultKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * Demo 结果回传示例：返回 DemoResult 数据类
 *
 * @author Joker.X
 */
object DemoResultKey : NavigationResultKey<DemoResult> {
    /**
     * 序列化结果
     *
     * @param value 待序列化的结果对象
     * @return 序列化后的字符串
     * @author Joker.X
     */
    override fun serialize(value: DemoResult): Any = Json.encodeToString(value)

    /**
     * 反序列化结果
     *
     * @param raw 原始保存的数据
     * @return 解析后的结果对象
     * @author Joker.X
     */
    override fun deserialize(raw: Any): DemoResult = Json.decodeFromString(raw as String)
}

/**
 * Demo 结果数据
 *
 * @param id 结果标识
 * @param message 结果信息
 * @author Joker.X
 */
@Serializable
data class DemoResult(
    val id: Long,
    val message: String
)
