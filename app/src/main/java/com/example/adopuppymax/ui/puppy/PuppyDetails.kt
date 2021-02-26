package com.example.adopuppymax.ui.puppy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.adopuppymax.ui.utils.AnimatingFabContent
import com.example.adopuppymax.ui.utils.scrim
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding


@Composable
fun PuppyDetails(
    puppyId: Long,
    selectPuppy: (Long) -> Unit,
    upPress: () -> Unit
) {
    val puppy = remember(puppyId) { PuppyRepo.getPuppy(puppyId) }
    PuppyDetails(puppy, selectPuppy, upPress)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyDetails(
    puppy: Puppy,
    selectPuppy: (Long) -> Unit,
    upPress: () -> Unit
) {
    PuppyMaxTheme {
        PuppyDescription(puppy, selectPuppy, upPress)
    }
}

@Composable
private fun PuppyDescription(
    puppy: Puppy,
    selectPuppy: (Long) -> Unit,
    upPress: () -> Unit
) {
    val scrollState = rememberScrollState()
    BoxWithConstraints {
        Surface(modifier = Modifier
            .fillMaxSize()
        ) {
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                PuppyDescriptionHeader(puppy, upPress)
                PuppyDescriptionBody(puppy)
                RelatedPuppies(puppy.id, selectPuppy)
            }
        }
        ProfileFab(
            extended = scrollState.value == 0,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
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
                .height(300.dp)
                .fillMaxWidth()
                .scrim(colors = listOf(Color(0x80000000), Color(0x33000000))),
            contentScale = ContentScale.Crop
        )
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = Color.White,
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
                    .padding(bottom = 10.dp)
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun PuppyDescriptionBody(puppy: Puppy) {
    Text(
        text = puppy.breed,
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 24.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    )
    Text(
        text = puppy.name,
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = puppy.age + " | " + puppy.gender + " | " + puppy.size,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(
            text = puppy.location,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
    }
    Divider(modifier = Modifier.padding(16.dp))
    Text(
        text = stringResource(id = R.string.color_info),
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = puppy.color,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 0.dp,
                    end = 16.dp,
                    bottom = 32.dp
                )
        )
    }
    Text(
        text = stringResource(id = R.string.health_info),
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = puppy.healthState,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 0.dp,
                    end = 16.dp,
                    bottom = 32.dp
                )
        )
    }
    Divider(modifier = Modifier.padding(16.dp))
    Text(
        text = "Meat " + puppy.name,
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = puppy.description,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 0.dp,
                    end = 16.dp,
                    bottom = 32.dp
                )
        )
    }
}

@Composable
private fun RelatedPuppies(
    puppyId: Long,
    selectPuppy: (Long) -> Unit
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
                            onClick = { selectPuppy(related.id) },
                            titleStyle = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(288.dp, 80.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileFab(extended: Boolean, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { /* TODO */ },
        modifier = modifier
            .padding(16.dp)
            .navigationBarsPadding()
            .height(48.dp)
            .widthIn(min = 48.dp),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        AnimatingFabContent(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Pets,
                    contentDescription = stringResource(R.string.adopt_me)
                )
            },
            text = {
                Text(
                    style = MaterialTheme.typography.subtitle1,
                    text = stringResource(id = R.string.adopt_me),
                )
            },
            extended = extended
        )
    }
}

@Preview(name = "Puppy Details")
@Composable
private fun PuppyDetailsPreview() {
    val puppyId = puppies.first().id
    PuppyDetails(
        puppyId = puppyId,
        selectPuppy = { },
        upPress = { }
    )
}
