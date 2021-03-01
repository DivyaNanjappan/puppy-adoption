package com.puppyadoption.androiddevchallenge

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.puppyadoption.androiddevchallenge.util.LocalBackDispatcher

@Composable
fun BaseApp(backDispatcher: OnBackPressedDispatcher) {

    CompositionLocalProvider(LocalBackDispatcher provides backDispatcher) {
        NavGraph()
    }
}