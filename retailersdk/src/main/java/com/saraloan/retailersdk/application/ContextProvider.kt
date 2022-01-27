package com.saraloan.retailersdk.application

import android.app.Application
import com.saraloan.retailersdk.application.ContextProvider

object ContextProvider {
    var application: Application? = null
        private set

    fun initializeApplication(application: Application?) {
        ContextProvider.application = application
    }
}