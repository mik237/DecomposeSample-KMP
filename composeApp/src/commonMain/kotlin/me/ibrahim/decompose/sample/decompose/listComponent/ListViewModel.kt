package me.ibrahim.decompose.sample.decompose.listComponent

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import me.ibrahim.decompose.sample.data_models.Quote

class ListViewModel : InstanceKeeper.Instance {

    val quotesList: Value<List<Quote>> = MutableValue(List(10) { Quote("Quote # $it") })

    override fun onDestroy() {
        super.onDestroy()
    }
}