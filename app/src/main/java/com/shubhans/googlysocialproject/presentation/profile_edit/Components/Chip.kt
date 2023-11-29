package com.shubhans.googlysocialproject.presentation.profile_edit.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubhans.googlysocialproject.presentation.ui.Theme.Spacesmall

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean = false,
    selectedColour: Color = MaterialTheme.colors.primary,
    unselectedColour: Color = MaterialTheme.colors.onSurface,
    onChipClick: () -> Unit
) {
    Text(text = text,
        color = if (selected) selectedColour else unselectedColour,
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp,
                color = if (selected) selectedColour else unselectedColour,
                shape = RoundedCornerShape(50.dp)
            )
            .clickable {
                onChipClick()
            }
            .padding(Spacesmall)
    )
}