package com.example.adopuppymax.ui.puppy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adopuppymax.R
import com.example.adopuppymax.ui.main.Puppy
import com.example.adopuppymax.ui.main.PuppyListItem
import com.example.adopuppymax.ui.main.PuppyRepo
import com.example.adopuppymax.ui.main.puppies
import com.example.adopuppymax.ui.theme.PuppyMaxTheme
import com.example.adopuppymax.ui.utils.scrim
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

//private val FabSize = 56.dp
//private const val ExpandedSheetAlpha = 0.96f

@Composable
fun PuppyDetails(
    courseId: Long,
    selectCourse: (Long) -> Unit,
    upPress: () -> Unit
) {
    // Simplified for the sample
    val puppy = remember(courseId) { PuppyRepo.getPuppy(courseId) }
    PuppyDetails(puppy, selectCourse, upPress)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyDetails(
    puppy: Puppy,
    selectCourse: (Long) -> Unit,
    upPress: () -> Unit
) {
    PuppyMaxTheme {
        CourseDescription(puppy, selectCourse, upPress)

//        BoxWithConstraints {
//            val fabSize = with(LocalDensity.current) { FabSize.toPx() }
//            val dragRange = constraints.maxHeight - fabSize
//            val scope = rememberCoroutineScope()

//            BackPressHandler(
//                enabled = sheetState.currentValue == SheetState.Open,
//                onBack = {
//                    scope.launch {
//                        sheetState.animateTo(SheetState.Closed)
//                    }
//                }
//            )
//            Box(
//                // The Lessons sheet is initially closed and appears as a FAB. Make it openable by
//                // swiping or clicking the FAB.
//                Modifier.swipeable(
//                    state = sheetState,
//                    anchors = mapOf(
//                        0f to SheetState.Closed,
//                        -dragRange to SheetState.Open
//                    ),
//                    thresholds = { _, _ -> FractionalThreshold(0.5f) },
//                    orientation = Vertical
//                )
//            ) {
//                val openFraction = if (sheetState.offset.value.isNaN()) {
//                    0f
//                } else {
//                    -sheetState.offset.value / dragRange
//                }.coerceIn(0f, 1f)
//                CourseDescription(puppy, selectCourse, upPress)
//                LessonsSheet(
//                    puppy,
//                    openFraction,
//                    this@BoxWithConstraints.constraints.maxWidth.toFloat(),
//                    this@BoxWithConstraints.constraints.maxHeight.toFloat()
//                ) { state ->
//                    scope.launch {
//                        sheetState.animateTo(state)
//                    }
//                }
//            }
//        }
    }
}

@Composable
private fun CourseDescription(
    course: Puppy,
    selectCourse: (Long) -> Unit,
    upPress: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item { PuppyDescriptionHeader(course, upPress) }
            item { PuppyDescriptionBody(course) }
            item { RelatedPuppies(course.id, selectCourse) }
        }
    }
}

@Composable
private fun PuppyDescriptionHeader(
    puppy: Puppy,
    upPress: () -> Unit
) {
    Box {
        Image(
            painter = painterResource(id = puppy.thumbResource),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .scrim(colors = listOf(Color(0x80000000), Color(0x33000000)))
                .aspectRatio(4f / 3f)
        )
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = Color.White, // always white as image has dark scrim
            modifier = Modifier.statusBarsPadding()
        ) {
            IconButton(onClick = upPress) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.more_puppies)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_pets_white_24dp),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
//        OutlinedAvatar(
//            url = course.instructor,
//            modifier = Modifier
//                .size(40.dp)
//                .align(Alignment.BottomCenter)
//                .offset(y = 20.dp) // overlap bottom of image
//        )
    }
}

@Composable
private fun PuppyDescriptionBody(puppy: Puppy) {
    Text(
        text = puppy.name.toUpperCase(),
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 36.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    )
    Text(
        text = puppy.name,
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = stringResource(id = R.string.more_puppies),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
    Divider(modifier = Modifier.padding(16.dp))
    Text(
        text = stringResource(id = R.string.more_puppies),
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = stringResource(id = R.string.more_puppies),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 32.dp
                )
        )
    }
}

@Composable
private fun RelatedPuppies(
    puppyId: Long,
    selectCourse: (Long) -> Unit
) {
    val relatedPuppies: List<Puppy> = remember(puppyId) { PuppyRepo.getRelatedPuppies(puppyId) }
    PuppyMaxTheme {
        Surface(
            color = MaterialTheme.colors.primarySurface,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.navigationBarsPadding()) {
                Text(
                    text = stringResource(id = R.string.more_puppies),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 24.dp
                        )
                )
                LazyRow(
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        bottom = 32.dp,
                        end = 16.dp
                    )
                ) {
                    items(relatedPuppies) { related ->
                        PuppyListItem(
                            puppy = related,
                            onClick = { selectCourse(related.id) },
                            titleStyle = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(288.dp, 80.dp),
                            iconSize = 14.dp
                        )
                    }
                }
            }
        }
    }
}


@Preview(name = "Puppy Details")
@Composable
private fun PuppyDetailsPreview() {
    val puppyId = puppies.first().id
    PuppyDetails(
        courseId = puppyId,
        selectCourse = { },
        upPress = { }
    )
}

@Preview(name = "Related")
@Composable
private fun RelatedPuppiesPreview() {
    val related = puppies.random()
    RelatedPuppies(
        puppyId = related.id,
        selectCourse = { }
    )
}
