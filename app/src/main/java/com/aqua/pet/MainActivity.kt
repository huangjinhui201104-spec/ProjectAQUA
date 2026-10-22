package com.aqua.pet

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private val bgColor = Color.rgb(7, 20, 42)
    private val cardColor = Color.rgb(17, 38, 68)
    private val blueColor = Color.rgb(65, 190, 255)

    private lateinit var petName: TextView
    private lateinit var petEmoji: TextView
    private lateinit var statusText: TextView
    private lateinit var dialogueText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun makeText(
        text: String,
        size: Float,
        color: Int,
        bold: Boolean = false
    ): TextView {
        return TextView(this).apply {
            this.text = text
            textSize = size
            setTextColor(color)
            gravity = Gravity.CENTER
            if (bold) setTypeface(null, Typeface.BOLD)
            setPadding(12, 10, 12, 10)
        }
    }

    private fun showHome() {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bgColor)
            setPadding(20, 18, 20, 20)
            gravity = Gravity.CENTER_HORIZONTAL
        }

        val scroll = android.widget.ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
        }

        content.addView(
            makeText("PROJECT AQUA", 25f, blueColor, true)
        )

        content.addView(
            makeText("你的 AI 桌面伙伴", 15f, Color.LTGRAY)
        )

        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(cardColor)
            setPadding(12, 24, 12, 24)
        }

        petEmoji = makeText("🦈", 76f, Color.WHITE)
        card.addView(petEmoji)

        petName = makeText("深海鲨鲨", 25f, Color.WHITE, true)
        card.addView(petName)

        statusText = makeText("状态：精神饱满 · 等待互动", 14f, blueColor)
        card.addView(statusText)

        dialogueText = makeText(
            "呀！你来啦！今天想和我一起做什么？",
            17f,
            Color.WHITE
        )
        card.addView(dialogueText)

        content.addView(
            card,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 24, 0, 20)
            }
        )

        content.addView(makeText("选择你的伙伴", 19f, Color.WHITE, true))

        addPetButton(content, "🦈  DeepSeek 鲨鱼娘") {
            petEmoji.text = "🦈"
            petName.text = "深海鲨鲨"
            statusText.text = "状态：活力满满"
            dialogueText.text = "呀！今天也要元气满满哦！"
        }

        addPetButton(content, "🐱  可爱猫娘") {
            petEmoji.text = "🐱"
            petName.text = "喵喵"
            statusText.text = "状态：慵懒待机"
            dialogueText.text = "喵～终于等到你啦！"
        }

        addPetButton(content, "🤖  未来 AI") {
            petEmoji.text = "🤖"
            petName.text = "AQUA-01"
            statusText.text = "状态：系统在线"
            dialogueText.text = "系统正常。随时可以为你提供帮助。"
        }

        addPetButton(content, "✨  原创虚拟生物") {
            petEmoji.text = "✨"
            petName.text = "小星灵"
            statusText.text = "状态：闪闪发光"
            dialogueText.text = "你好呀！我们一起探索新世界吧！"
        }

        content.addView(makeText("和伙伴聊聊天", 19f, Color.WHITE, true))

        addPetButton(content, "💬  打个招呼") {
            dialogueText.text = "嘿嘿！我在这里陪着你～"
            statusText.text = "状态：正在互动"
        }

        addPetButton(content, "🌙  休息一下") {
            dialogueText.text = "那我们安静地待一会儿吧。"
            statusText.text = "状态：休息中"
        }

        content.addView(
            makeText(
                "AQUA 预览版 0.1.0\n当前为本地演示，AI 对话与动态动画将在后续版本接入。",
                12f,
                Color.LTGRAY
            )
        )

        scroll.addView(content)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(root)
    }

    private fun addPetButton(
        parent: LinearLayout,
        label: String,
        action: () -> Unit
    ) {
        val button = Button(this).apply {
            text = label
            textSize = 15f
            isAllCaps = false
            setTextColor(Color.WHITE)
            setBackgroundColor(cardColor)
            setOnClickListener { action() }
        }

        parent.addView(
            button,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 5, 0, 5)
            }
        )
    }
}
