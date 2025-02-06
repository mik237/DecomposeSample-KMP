package me.ibrahim.decompose.sample.decompose.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import me.ibrahim.decompose.sample.data_models.Quote

interface RootComponent {

    val backStack: Value<ChildStack<*, DestinationChild>>

    sealed class DestinationChild {
        data object QuotesList : DestinationChild()
        data class QuoteDetail(val quote: Quote) : DestinationChild()
    }
}