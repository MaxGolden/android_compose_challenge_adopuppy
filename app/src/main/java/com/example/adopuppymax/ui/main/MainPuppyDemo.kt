package com.example.adopuppymax.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.adopuppymax.R
import com.example.adopuppymax.ui.theme.PuppyMaxTheme
import com.example.adopuppymax.ui.theme.PuppyTheme
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import kotlin.math.ceil

@Composable
fun MainPuppyDemo(
    puppyList: List<Puppy>,
    selectPuppy: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
    ) {
        PuppyAppBar()
        StaggeredVerticalGrid(
            maxColumnWidth = 220.dp,
            modifier = Modifier.padding(start = 4.dp, bottom = 60.dp, end = 4.dp)
        ) {
            puppyList.forEach { puppy ->
                DisplayPuppy(puppy, selectPuppy)
            }
        }
    }
}

@Composable
fun DisplayPuppy(
    puppy: Puppy,
    selectPuppy: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(4.dp),
        color = MaterialTheme.colors.surface,
        elevation = PuppyTheme.elevations.card,
        shape = MaterialTheme.shapes.medium
    ) {
        val puppyListString = stringResource(id = R.string.puppy_available)
        ConstraintLayout(
            modifier = Modifier
                .clickable(
                    onClick = { selectPuppy(puppy.id) }
                )
                .semantics {
                    contentDescription = puppyListString
                }
        ) {
            val (image, breed, name, info, location) = createRefs()
            Image(
                painter = painterResource(id = puppy.thumbResource),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(image) {
                        centerHorizontallyTo(parent)
                        top.linkTo(parent.top)
                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = puppy.breed,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(breed) {
                        centerHorizontallyTo(parent)
                        top.linkTo(image.bottom)
                    }
            )
            Text(
                text = puppy.name,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
                    .constrainAs(name) {
                        centerHorizontallyTo(parent)
                        top.linkTo(breed.bottom)
                    }
            )
            Text(
                text = puppy.age + " | " + puppy.gender + " | " + puppy.size,
                style = MaterialTheme.typography.overline,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(info) {
                        centerHorizontallyTo(parent)
                        top.linkTo(name.bottom)
                    }
            )
            Text(
                text = puppy.location,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        top = 0.dp,
                        bottom = 12.dp
                    )
                    .constrainAs(location) {
                        centerHorizontallyTo(parent)
                        top.linkTo(info.bottom)
                    }
            )
        }
    }
}

@Composable
fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    maxColumnWidth: Dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        check(constraints.hasBoundedWidth) {}
        val columns = ceil(constraints.maxWidth / maxColumnWidth.toPx()).toInt()
        val columnWidth = constraints.maxWidth / columns
        val itemConstraints = constraints.copy(maxWidth = columnWidth)
        val colHeights = IntArray(columns) { 0 } // track each column's height
        val placeables = measurables.map { measurable ->
            val column = shortestColumn(colHeights)
            val placeable = measurable.measure(itemConstraints)
            colHeights[column] += placeable.height
            placeable
        }

        val height = colHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
            ?: constraints.minHeight
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val colY = IntArray(columns) { 0 }
            placeables.forEach { placeable ->
                val column = shortestColumn(colY)
                placeable.place(
                    x = columnWidth * column,
                    y = colY[column]
                )
                colY[column] += placeable.height
            }
        }
    }
}

private fun shortestColumn(colHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var column = 0
    colHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            column = index
        }
    }
    return column
}

@Preview(name = "Puppy")
@Composable
private fun FeaturedPuppyPreview() {
    PuppyMaxTheme {
        DisplayPuppy(
            puppy = puppies.first(),
            selectPuppy = { }
        )
    }
}

@Composable
fun PuppyAppBar() {
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.height(48.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(start = 16.dp, bottom = 4.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.ic_pets_white_24dp),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.poppy_adoption),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterVertically)
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = stringResource(R.string.icon_profile)
            )
        }
    }
}

@Preview
@Composable
fun PreviewPuppyAppBar() {
    PuppyMaxTheme {
        PuppyAppBar()
    }
}