package com.shubhans.googlysocialproject.domain.m.model

import com.shubhans.googlysocialproject.domain.util.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String
)
