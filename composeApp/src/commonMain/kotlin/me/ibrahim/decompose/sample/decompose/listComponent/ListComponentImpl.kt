package me.ibrahim.decompose.sample.decompose.listComponent

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import me.ibrahim.decompose.sample.data_models.Quote

class ListComponentImpl(
    val quoteClicked: (Quote) -> Unit
) : ListComponent {
    override val quotesList: Value<List<Quote>> = MutableValue((0..20).map { Quote(quote = "Quote # ${it + 1}") })

    override fun onQuoteClicked(quote: Quote) = quoteClicked(quote)
}