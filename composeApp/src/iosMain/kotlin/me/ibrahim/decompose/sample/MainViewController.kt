package me.ibrahim.decompose.sample

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import me.ibrahim.decompose.sample.decompose.root.RootComponentImpl

fun MainViewController() = ComposeUIViewController {
    val root = RootComponentImpl(DefaultComponentContext(lifecycle = LifecycleRegistry()))
    App(root = root)
}