package me.ibrahim.decompose.sample.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import me.ibrahim.decompose.sample.decompose.listComponent.ListComponent

@Composable
fun QuotesList(
    component: ListComponent
) {
    val quotes by component.quotesList.subscribeAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Quotes") },
                backgroundColor = Color.Yellow
            )
        }
    ) { paddingValues ->
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.padding(paddingValues)
        ) {
            items(quotes, key = { it.quote }) { quote ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            component.onQuoteClicked(quote = quote)
                        }
                        .padding(16.dp)
                ) {
                    Text(quote.quote)
                }
            }
        }
    }
}