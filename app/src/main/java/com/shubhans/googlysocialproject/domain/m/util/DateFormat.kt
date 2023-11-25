package com.shubhans.googlysocialproject.domain.m.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateFormat {
    fun timestampToFormattedString(timestamp: Long, pattern: String):String {
        return SimpleDateFormat(pattern, Locale.getDefault()).run {
            format(timestamp)
        }
    }
}