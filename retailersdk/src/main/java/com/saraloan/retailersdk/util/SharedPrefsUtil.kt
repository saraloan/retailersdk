package com.saraloan.retailersdk.util

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.saraloan.retailersdk.util.SharedPrefsUtil
import com.saraloan.retailersdk.application.ContextProvider

object SharedPrefsUtil {
    private fun edit(): SharedPreferences.Editor {
        return preferences.edit()
    }

    private val preferences: SharedPreferences
        private get() = context.getSharedPreferences(
            context.applicationContext.packageName,
            Context.MODE_PRIVATE
        )
    val resources: Resources
        get() = context.resources

    private val context: Context
        private get() = ContextProvider.application!!

    fun getBoolean(key: String?, defaultValue: Boolean): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    fun setBoolean(key: String?, value: Boolean) {
        edit().putBoolean(key, value).apply()
    }

    fun getString(key: String?, defaultValue: String?): String? {
        return preferences.getString(key, defaultValue)
    }

    fun setString(key: String?, value: String?) {
        edit().putString(key, value).apply()
    }

    fun getInt(key: String?, defaultValue: Int): Int {
        return preferences.getInt(key, defaultValue)
    }

    fun setInt(key: String?, value: Int) {
        edit().putInt(key, value).apply()
    }

    var colorPrimary: String?
        get() = getString("colorPrimary", "#5533FF")
        set(colorPrimary) {
            setString("colorPrimary", colorPrimary)
        }
    var sandboxMode: Boolean
        get() = getBoolean("sandbox", true)
        set(sandboxMode) {
            setBoolean("sandbox", sandboxMode)
        }

    var username: String?
        get() = getString("saraloan_username", "")
        set(username) {
            setString("saraloan_username", username)
        }

    var password: String?
        get() = getString("saraloan_pwd", "")
        set(password) {
            setString("saraloan_pwd", password)
        }

    var mobile: String?
        get() = getString("saraloan_mobile", "")
        set(mobile) {
            setString("saraloan_mobile", mobile)
        }

    var returnActivityName: String?
        get() = getString("returnActivity", "")
        set(returnActivityName) {
            setString("returnActivity", returnActivityName)
        }
    var colorAccent: String?
        get() = getString("colorAccent", "#ff3658")
        set(colorAccent) {
            setString("colorAccent", colorAccent)
        }

    fun setImageUri(uri: String?) {
        setString("imageUri", uri)
    }

    val imageUriString: String?
        get() = getString("imageUri", "")
    var isImageSquare: Boolean
        get() = getBoolean("isImageSquare", false)
        set(isSquare) {
            setBoolean("isImageSquare", isSquare)
        }
}