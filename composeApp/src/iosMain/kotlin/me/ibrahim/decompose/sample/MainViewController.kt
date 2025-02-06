package me.ibrahim.decompose.sample

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import me.ibrahim.decompose.sample.decompose.root.RootComponentImpl

fun MainViewController() = ComposeUIViewController {
    val root = RootComponentImpl(DefaultComponentContext(lifecycle = ApplicationLifecycle()))
    App(root = root)
}