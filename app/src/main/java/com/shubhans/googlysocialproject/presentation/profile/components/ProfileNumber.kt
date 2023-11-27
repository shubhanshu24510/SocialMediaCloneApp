package com.shubhans.googlysocialproject.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceExtraLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium
import com.shubhans.googlysocialproject.presentation.ui.Theme.Spacesmall

@Composable
fun Profilenumber(
    number:Int,
    text:String
){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = number.toString(),
            style = MaterialTheme.typography.h1.copy(fontSize = 23.sp),
            textAlign = TextAlign.Center
            )
        Spacer(modifier = Modifier.height(Spacesmall))
        Text(text = text,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center
        )

    }

}