package com.radlance.mymoscow.presentation.core

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radlance.mymoscow.R
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation
import com.radlance.mymoscow.presentation.place.PlaceScreen
import com.radlance.mymoscow.ui.theme.AppTheme

@Composable
fun ExpandedScreen(
    modifier: Modifier = Modifier,
    contentType: ContentType,
    onRecommendationClicked: (Recommendation) -> Unit,
    onCategoryClicked: (Category) -> Unit,
    recommendationsList: List<Recommendation>,
    categories: List<Category>,
    currentRecommendation: Recommendation?,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(modifier = modifier) {
        Column(modifier = Modifier.weight(1f)) {
            LazyColumn(
                contentPadding = contentPadding,
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
            ) {
                items(
                    items = categories,
                    key = { category -> category.id }
                ) { category ->
                    CategoryItem(
                        onRecommendationClicked = { onRecommendationClicked(it) },
                        currentCategory = category,
                        recommendationsList = recommendationsList,
                        onCategoryClicked = { onCategoryClicked(it) }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
        Column(modifier = Modifier.weight(1f)) {
            currentRecommendation?.let {
                PlaceScreen(
                    contentType = contentType,
                    recommendation = it
                )
            }
        }
    }
}

@Composable
fun CategoryItem(
    recommendationsList: List<Recommendation>,
    onCategoryClicked: (Category) -> Unit,
    onRecommendationClicked: (Recommendation) -> Unit,
    currentCategory: Category,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        if (expanded) MaterialTheme.colorScheme.surfaceContainer else MaterialTheme.colorScheme.surfaceVariant,
        label = "color"
    )
    Surface(
        onClick = {
            onCategoryClicked(currentCategory)
            expanded = !expanded
        },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        color = animatedColor
    ) {
        Column(modifier = Modifier.animateContentSize()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = currentCategory.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = stringResource(id = currentCategory.titleResourceId),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 18.sp,
                    modifier = Modifier.run {
                        weight(1f)
                            .padding(dimensionResource(id = R.dimen.padding_medium))
                    }
                )
                IconButton(
                    onClick = {
                        onCategoryClicked(currentCategory)
                        expanded = !expanded
                    }
                ) {
                    Icon(
                        imageVector = if (expanded) {
                            Icons.Filled.ExpandLess
                        } else {
                            Icons.Filled.ExpandMore
                        },
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            }
            if (expanded) {
                Column(Modifier.padding(bottom = 25.dp)) {
                    recommendationsList.forEach { recommendation ->
                        RecommendationItem(
                            onItemClicked = { onRecommendationClicked(recommendation) },
                            currentRecommendation = recommendation,
                            modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 15.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendationItem(
    onItemClicked: (Recommendation) -> Unit,
    currentRecommendation: Recommendation,
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
                modifier = Modifier
                    .size(120.dp)
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = currentRecommendation.titleResourceId),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                modifier = Modifier.run {
                    weight(1f)
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                }
            )
        }
    }
}

@Preview(widthDp = 840, showBackground = true)
@Composable
private fun ExpandedScreenPreview() {
    AppTheme {
        ExpandedScreen(
            contentType = ContentType.Expanded,
            onRecommendationClicked = {},
            recommendationsList = LocalStorage.getRecommendationsByCategoryId(1),
            categories = LocalStorage.getCategories(),
            currentRecommendation = LocalStorage.getRecommendationsByCategoryId(1)[0],
            onCategoryClicked = {}
        )
    }
}