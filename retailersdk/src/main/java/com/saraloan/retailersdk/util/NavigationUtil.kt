package com.saraloan.retailersdk.util

import android.content.Intent
import android.app.ActivityOptions
import android.content.Context
import android.os.Build
import android.view.View

object NavigationUtil {
    fun startActivityWithClipReveal(context: Context, landingActivity: Class<*>?, view: View) {
        val intent = Intent(context, landingActivity)
        var options: ActivityOptions? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            options = ActivityOptions.makeClipRevealAnimation(
                view, 0, 0,
                view.width, view.height
            )
            context.startActivity(intent, options.toBundle())
        } else {
            context.startActivity(intent)
        }
    }

    fun startActivityWithClipReveal(context: Context, intent: Intent?, view: View) {
        var options: ActivityOptions? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            options = ActivityOptions.makeClipRevealAnimation(
                view, 0, 0,
                view.width, view.height
            )
            context.startActivity(intent, options.toBundle())
        } else {
            context.startActivity(intent)
        }
    }

    fun startActivity(context: Context, landingActivity: Class<*>?) {
        val intent = Intent(context, landingActivity)
        context.startActivity(intent)
    }

    @JvmStatic
    fun startActivity(context: Context, intent: Intent?) {
        context.startActivity(intent)
    }
}