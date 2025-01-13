package karel.hudera.spacetrace.presentation.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import karel.hudera.spacetrace.domain.model.Picture
import karel.hudera.spacetrace.presentation.ui.theme.spacing

@Composable
fun ImageCard(picture: Picture) {
    Card(
        modifier = Modifier
            .padding(
                vertical = 8.dp,
                horizontal = MaterialTheme.spacing.horizontal
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth()
                .heightIn(min = 0.dp, max = 200.dp),
            model = picture.url,
            contentDescription = picture.copyright,
            contentScale = ContentScale.FillWidth
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = picture.title,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Medium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}