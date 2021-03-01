package com.puppyadoption.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.puppyadoption.androiddevchallenge.R
import com.puppyadoption.androiddevchallenge.model.Puppy
import com.puppyadoption.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Puppies(selectPuppy: (Int) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        AdoptionList(Puppy.getPuppies(), selectPuppy)
    }
}

@Composable
fun AdoptionList(puppies: List<Puppy>, selectPuppy: (Int) -> Unit) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    maxLines = 1
                )
            }
        )

        if (puppies.isEmpty()) {
            Text(text = "Puppies not found")
        } else {
            LazyColumn {
                items(puppies) {
                    PuppyRow(it, selectPuppy)
                }
            }
        }
    }
}

@Composable
fun PuppyRow(puppy: Puppy, selectPuppy: (Int) -> Unit) {
    val typography = MaterialTheme.typography

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                selectPuppy(puppy.id)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .padding(16.dp)
        ) {

            Surface(
                modifier = Modifier.padding(8.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                Image(
                    painter = painterResource(id = puppy.imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                )
            }

            Column {
                Text(
                    text = puppy.name,
                    style = typography.body1,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )

                Text(
                    text = puppy.gender,
                    style = typography.body1,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Puppies {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Puppies {}
    }
}