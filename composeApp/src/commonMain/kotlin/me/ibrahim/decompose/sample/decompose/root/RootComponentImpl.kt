package me.ibrahim.decompose.sample.decompose.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {


    sealed interface NavigationConfig {
        data object QuotesList : NavigationConfig
        data object QuotesDetail : NavigationConfig
    }

    override val backStack: Value<ChildStack<*, RootComponent.DestinationChild>>
        get() = TODO("Not yet implemented")
}