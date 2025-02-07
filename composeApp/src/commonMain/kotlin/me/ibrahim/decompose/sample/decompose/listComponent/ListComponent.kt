package me.ibrahim.decompose.sample.decompose.listComponent

import com.arkivanov.decompose.value.Value
import me.ibrahim.decompose.sample.data_models.Quote

interface ListComponent {
    val listViewModel: ListViewModel
    fun onQuoteClicked(quote: Quote)
}