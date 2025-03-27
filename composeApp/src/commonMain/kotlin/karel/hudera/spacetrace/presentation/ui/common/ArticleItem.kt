package karel.hudera.spacetrace.presentation.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import karel.hudera.spacetrace.domain.model.Article

@Composable
fun ArticleItem(
    article: Article,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row {
            AsyncImage(
                modifier = Modifier.widthIn(0.dp,140.dp).heightIn(0.dp, 100.dp),
                model = article.imageUrl,
                contentDescription = article.title,
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = article.title,
                    modifier = Modifier.padding(4.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis, // Ensures "..." when text overflows
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = formatDateTime(article.updatedAt),
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

fun formatDateTime(dateTime: String): String {
    return try {
        // Split the date and time
        val dateAndTime = dateTime.split("T")
        val date = dateAndTime[0] // "2024-12-31"
        val time = dateAndTime[1].split(".")[0] // "08:30:13"

        // Extract individual components
        val (year, month, day) = date.split("-")
        val (hour, minute, second) = time.split(":")

        // Return formatted string
        "$year-$month-$day $hour:$minute"
    } catch (e: Exception) {
        "Invalid Date" // Fallback in case of parsing error
    }
}