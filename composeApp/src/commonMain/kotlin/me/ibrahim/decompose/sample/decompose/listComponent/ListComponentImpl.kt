package me.ibrahim.decompose.sample.decompose.listComponent

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import me.ibrahim.decompose.sample.data_models.Quote

class ListComponentImpl(
    private val componentContext: ComponentContext,
    val quoteClicked: (Quote) -> Unit,
) : ListComponent, ComponentContext by componentContext {

    override val listViewModel: ListViewModel
        get() = instanceKeeper.getOrCreate { ListViewModel() }

    override fun onQuoteClicked(quote: Quote) = quoteClicked(quote)
}