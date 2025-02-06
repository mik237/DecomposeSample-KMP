@file:OptIn(DelicateDecomposeApi::class)

package me.ibrahim.decompose.sample.decompose.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import me.ibrahim.decompose.sample.data_models.Quote
import me.ibrahim.decompose.sample.decompose.detailComponent.DetailComponent
import me.ibrahim.decompose.sample.decompose.detailComponent.DetailComponentImpl
import me.ibrahim.decompose.sample.decompose.listComponent.ListComponent
import me.ibrahim.decompose.sample.decompose.listComponent.ListComponentImpl

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<NavigationConfig>()

    private val _backStack = childStack(
        source = navigation,
        serializer = NavigationConfig.serializer(),
        initialConfiguration = NavigationConfig.QuotesList,
        handleBackButton = true,
        childFactory = ::createChild
    )

    override val backStack: Value<ChildStack<*, RootComponent.DestinationChild>> = _backStack


    private fun createChild(config: NavigationConfig, context: ComponentContext): RootComponent.DestinationChild {
        return when (config) {
            NavigationConfig.QuotesList -> RootComponent.DestinationChild.QuotesList(
                component = buildQuotesListComponent(context)
            )

            is NavigationConfig.QuotesDetail -> RootComponent.DestinationChild.QuoteDetail(
                component = buildQuotesDetailComponent(config.quote, context)
            )
        }
    }


    private fun buildQuotesListComponent(context: ComponentContext): ListComponent {
        return ListComponentImpl(quoteClicked = {
            navigation.push(NavigationConfig.QuotesDetail(it))
            println("Quote: ${it.quote}")
        })
    }

    private fun buildQuotesDetailComponent(quote: Quote, context: ComponentContext): DetailComponent {
        return DetailComponentImpl(quote = quote, backPressed = {
            navigation.pop()
        })
    }

    /////////////////////////////////////////////////////////////////////

    @Serializable
    sealed interface NavigationConfig {
        @Serializable
        data object QuotesList : NavigationConfig

        @Serializable
        data class QuotesDetail(val quote: Quote) : NavigationConfig
    }
}