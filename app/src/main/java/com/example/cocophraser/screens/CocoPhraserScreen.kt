package com.example.cocophraser.screens

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.cocophraser.viewmodel.CocoPhraserViewModel


@Composable
fun CocoPhraserScreen(viewModel: CocoPhraserViewModel) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    if (isPortrait) {
        CocoPhraserPortrait(viewModel)
    } else {
        CocoPhraserLandscape(viewModel)
    }
}
