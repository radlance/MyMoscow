package com.radlance.mymoscow.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radlance.mymoscow.R
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Recommendation
import com.radlance.mymoscow.ui.theme.AppTheme

@Composable
fun RecommendationListItem(
    currentRecommendation: Recommendation,
    onItemClicked: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = { onItemClicked(currentRecommendation) },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = currentRecommendation.imageResourceId),
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = currentRecommendation.titleResourceId),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.run {
                    weight(1f)
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                }
            )
        }
    }
}

@Preview
@Composable
private fun RecommendationListItemPreview() {
    AppTheme {
        RecommendationListItem(
            currentRecommendation = LocalStorage.getRecommendationsByCategoryId(1)[0],
            onItemClicked = {}
        )
    }
}