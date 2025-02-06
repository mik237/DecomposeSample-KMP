package me.ibrahim.decompose.sample.decompose.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import me.ibrahim.decompose.sample.decompose.detailComponent.DetailComponent
import me.ibrahim.decompose.sample.decompose.listComponent.ListComponent

interface RootComponent {

    val backStack: Value<ChildStack<*, DestinationChild>>

    sealed class DestinationChild {
        data class QuotesList(val component: ListComponent) : DestinationChild()
        data class QuoteDetail(val component: DetailComponent) : DestinationChild()
    }
}