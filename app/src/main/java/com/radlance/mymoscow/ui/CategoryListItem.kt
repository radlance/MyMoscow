package com.radlance.mymoscow.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.ui.theme.AppTheme

@Composable
fun CategoryListItem(
    currentCategory: Category,
    onItemClicked: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = { onItemClicked(currentCategory) },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = currentCategory.imageResourceId),
                contentDescription = null,
                modifier = Modifier.size(140.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = currentCategory.titleResourceId),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
private fun CategoryListItemPreview() {
    AppTheme {
        CategoryListItem(
            currentCategory = LocalStorage.getCategories()[0],
            onItemClicked = {}
        )
    }
}