package com.radlance.mymoscow.presentation.place

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radlance.mymoscow.R
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Recommendation
import com.radlance.mymoscow.ui.theme.AppTheme

@Composable
fun PlaceScreen(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
        item {
            PlaceScreenItem(recommendation = recommendation)
        }
    }
}

@Composable
fun PlaceScreenItem(recommendation: Recommendation,) {
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
        PlaceScreen(LocalStorage.getRecommendationsByCategoryId(1)[0])
    }
}