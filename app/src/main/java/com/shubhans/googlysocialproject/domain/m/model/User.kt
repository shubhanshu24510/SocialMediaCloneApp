package com.shubhans.googlysocialproject.domain.m.model

data class User(
    val profilePictureUrl:String,
    val username:String,
    val description:String,
    val followerCount:Int,
    val followingCount:Int,
    val postCount:Int
)
