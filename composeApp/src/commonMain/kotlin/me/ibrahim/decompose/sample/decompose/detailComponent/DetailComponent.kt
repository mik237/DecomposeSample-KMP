package me.ibrahim.decompose.sample.decompose.detailComponent

import com.arkivanov.decompose.value.Value
import me.ibrahim.decompose.sample.data_models.Quote

interface DetailComponent {
    val quoteValue: Value<Quote>
    fun onBackPressed()
}