package me.ibrahim.decompose.sample.decompose.detailComponent

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import me.ibrahim.decompose.sample.data_models.Quote

class DetailComponentImpl(
    quote: Quote,
    private val backPressed: () -> Unit
) : DetailComponent {

    override val quoteValue: Value<Quote> = MutableValue(quote)

    override fun onBackPressed() = backPressed()

}