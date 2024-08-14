package com.radlance.mymoscow.presentation.recommendation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.radlance.mymoscow.R
import com.radlance.mymoscow.domain.Recommendation

@Composable
fun RecommendationScreen(
    recommendationsList: List<Recommendation>,
    onItemClicked: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(
            items = recommendationsList,
            key = { recommendation -> recommendation.id }) { recommendation ->
            RecommendationListItem(
                currentRecommendation = recommendation,
                onItemClicked = { onItemClicked(recommendation) }
            )
        }
    }
}