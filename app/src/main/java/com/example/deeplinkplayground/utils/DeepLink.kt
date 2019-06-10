package com.example.deeplinkplayground.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

fun startDeepLink(uri: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(uri)
    context.startActivity(intent)
}