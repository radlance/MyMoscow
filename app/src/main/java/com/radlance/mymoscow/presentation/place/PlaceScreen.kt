package com.radlance.mymoscow.presentation.place

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radlance.mymoscow.R
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Recommendation
import com.radlance.mymoscow.presentation.core.ContentType
import com.radlance.mymoscow.ui.theme.AppTheme

@Composable
fun PlaceScreen(
    recommendation: Recommendation,
    contentType: ContentType,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(
            start = dimensionResource(id = R.dimen.padding_medium),
            end = dimensionResource(id = R.dimen.padding_medium),
            bottom = dimensionResource(id = R.dimen.padding_medium),
            top = if (contentType == ContentType.Default) {
                dimensionResource(id = R.dimen.padding_medium)
            } else {
                0.dp
            }
        )
    ) {
        item {
            PlaceScreenItem(
                contentType = contentType,
                recommendation = recommendation
            )
        }
    }
}

@Composable
private fun PlaceScreenItem(
    contentType: ContentType,
    recommendation: Recommendation
) {
    val maxHeight = when (contentType) {
        ContentType.Default -> 550.dp
        ContentType.Medium -> 800.dp
        ContentType.Expanded -> 400.dp
    }
    Image(
        painter = painterResource(id = recommendation.imageResourceId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    dimensionResource(id = R.dimen.padding_medium)
                )
            )
            .fillMaxWidth()
            .heightIn(max = maxHeight)
    )
    Text(
        text = stringResource(id = recommendation.titleResourceId),
        modifier = Modifier.padding(vertical = 16.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = stringResource(id = recommendation.description),
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
private fun PlaceScreenPreview() {
    AppTheme {
        PlaceScreen(
            contentType = ContentType.Default,
            recommendation = LocalStorage.getRecommendationsByCategoryId(1)[0]
        )
    }
}