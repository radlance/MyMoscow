package com.radlance.mymoscow.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radlance.mymoscow.R
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.ui.theme.AppTheme

@Composable
fun CategoryList(
    categoryList: List<Category>,
    onItemClicked: (Category) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(items = categoryList, key = { category -> category.id }) { category ->
            CategoryListItem(
                currentCategory = category,
                onItemClicked = { onItemClicked(category) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryListPreview() {
    AppTheme {
        CategoryList(
            categoryList = LocalStorage.getCategories(),
            onItemClicked = {},
            Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        )
    }
}