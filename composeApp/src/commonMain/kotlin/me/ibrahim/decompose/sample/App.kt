package me.ibrahim.decompose.sample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import me.ibrahim.decompose.sample.decompose.root.RootComponent
import me.ibrahim.decompose.sample.ui.QuoteDetail
import me.ibrahim.decompose.sample.ui.QuotesList
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(root: RootComponent) {
    MaterialTheme {

        val state by root.backStack.subscribeAsState()

        Children(
            stack = state,
            modifier = Modifier.fillMaxSize()
        ) {
            when (val child = it.instance) {
                is RootComponent.DestinationChild.QuotesList -> QuotesList(component = child.component)
                is RootComponent.DestinationChild.QuoteDetail -> QuoteDetail(component = child.component)
            }
        }
    }
}