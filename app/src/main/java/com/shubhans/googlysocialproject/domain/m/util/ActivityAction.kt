package com.shubhans.googlysocialproject.domain.util

sealed class ActivityAction{
    object likedPost:ActivityAction()
    object commentonPost:ActivityAction()
    object followedYou:ActivityAction()
}
