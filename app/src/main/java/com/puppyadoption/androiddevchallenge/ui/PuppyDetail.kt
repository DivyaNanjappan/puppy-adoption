/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.puppyadoption.androiddevchallenge.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.puppyadoption.androiddevchallenge.R
import com.puppyadoption.androiddevchallenge.model.Puppy
import com.puppyadoption.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyDetail(puppyId: Int, upPress: () -> Unit) {
    val puppy = Puppy.getPuppies().first { it.id == puppyId }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ToolBar(puppy = puppy, upPress)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PuppyImage(puppy = puppy)
            PuppyContent(puppy = puppy)
        }
    }
}

@Composable
fun ToolBar(puppy: Puppy, upPress: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = puppy.name, maxLines = 1)
        },

        navigationIcon = {
            IconButton(onClick = upPress) {
                Icon(painterResource(id = R.drawable.ic_arrow_back), null)
            }
        }
    )
}

@Composable
fun PuppyImage(puppy: Puppy) {
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
    ) {
        Image(
            painter = painterResource(id = puppy.imageId),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        )
    }
}

@Composable
fun PuppyContent(puppy: Puppy) {
    val typography = MaterialTheme.typography
    val colorPrimary = MaterialTheme.colors.primary

    Card(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(5.dp))
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = puppy.name,
                style = typography.h6,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()

            ) {

                OutlinedButton(
                    onClick = {  },
                    border = BorderStroke(1.dp, colorPrimary),
                    modifier = Modifier
                        .padding(4.dp)
                        .weight(1f)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = "${puppy.age}\nAge",
                        style = typography.body1,
                        textAlign = TextAlign.Center
                    )
                }

                OutlinedButton(
                    onClick = {  },
                    border = BorderStroke(1.dp, colorPrimary),
                    modifier = Modifier
                        .padding(4.dp)
                        .weight(1f)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = "${puppy.gender}\nGender",
                        style = typography.body1,
                        textAlign = TextAlign.Center
                    )
                }

                OutlinedButton(
                    onClick = {  },
                    border = BorderStroke(1.dp, colorPrimary),
                    modifier = Modifier
                        .padding(4.dp)
                        .weight(1f)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = "${puppy.weight}\nWeight",
                        style = typography.body1,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Text(
                text = "Pet Story",
                style = typography.h6,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )

            Text(
                text = puppy.description,
                style = typography.body1,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )


            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Surface(
                    modifier = Modifier.padding(8.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = null,
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                    )
                }

                Text(
                    text = puppy.contactName,
                    style = typography.body1,
                    modifier = Modifier
                        .padding(5.dp),
                    textAlign = TextAlign.Center
                )

                Button(
                    onClick = { },
                    modifier = Modifier
                        .width(150.dp)
                        .padding(10.dp),
                ) {
                    Text(text = "Contact Me")
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightDetailPreview() {
    MyTheme {
        PuppyDetail(1) {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkDetailPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetail(1) {}
    }
}