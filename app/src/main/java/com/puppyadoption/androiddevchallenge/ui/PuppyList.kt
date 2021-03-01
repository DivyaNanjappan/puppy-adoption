package com.puppyadoption.androiddevchallenge.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.ui.layout.HeightSpacer
import com.puppyadoption.androiddevchallenge.R
import com.puppyadoption.androiddevchallenge.model.Puppy
import com.puppyadoption.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Puppies(selectPuppy: (Int) -> Unit) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        AdoptionList(Puppy.getPuppies(), selectPuppy)
    }
}

@Composable
fun AdoptionList(puppies: List<Puppy>, selectPuppy: (Int) -> Unit) {
    val typography = MaterialTheme.typography

    Column {

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp),
            textAlign = TextAlign.Center,
            style = typography.h4
        )

        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            if (puppies.isEmpty()) {
                Text(text = "Puppies not found")
            } else {
                LazyColumn {
                    items(puppies) {
                        PuppyRow(it, selectPuppy)
                        Divider(color = colorResource(id = R.color.color_divider))
                    }
                }
            }
        }
    }

}

@Composable
fun PuppyRow(puppy: Puppy, selectPuppy: (Int) -> Unit) {
    val typography = MaterialTheme.typography
    val colorPrimary = MaterialTheme.colors.primary

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .clickable {
                selectPuppy(puppy.id)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .padding(8.dp)
                .fillMaxWidth()
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
                        .height(100.dp)
                        .width(100.dp)
                )
            }

            Column {
                Text(
                    text = puppy.name,
                    style = typography.body1,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                )

                Text(
                    text = "Age - ${puppy.age} Years",
                    style = typography.body1,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                )


                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier
                            .width(130.dp),
                        border = BorderStroke(1.dp, colorPrimary),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Text(text = puppy.gender)
                    }
                }
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