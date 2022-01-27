package com.saraloan.retailersdk.util

import android.app.Application
import android.content.Context
import com.saraloan.retailersdk.util.NavigationUtil.startActivity
import com.saraloan.retailersdk.application.ContextProvider
import com.saraloan.retailersdk.util.SharedPrefsUtil
import android.content.Intent
import android.text.Editable
import android.util.Log
import com.saraloan.retailersdk.PwaActivity
import com.saraloan.retailersdk.models.EmbedSession
import com.saraloan.retailersdk.services.EmbedService
import com.saraloan.retailersdk.util.NavigationUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class Saraloan {
    fun with(application: Application?): Saraloan {
        ContextProvider.initializeApplication(application)
        return this
    }

    fun returnBackActivity(cls: Class<*>): Saraloan {
        SharedPrefsUtil.returnActivityName = cls.name
        return this
    }

    fun runInSandboxMode(sandboxMode: Boolean): Saraloan {
        SharedPrefsUtil.sandboxMode = sandboxMode
        return this
    }

    fun initialize(username: String?, password: String?): Saraloan {
        SharedPrefsUtil.username = username
        SharedPrefsUtil.password = password
        Log.d("SARALOG", "Welcome to the SDK")
        return this
    }

    fun launch(context: Context?, mobile: Editable) {
        SharedPrefsUtil.mobile = mobile.toString()
        getSession(context, mobile)
    }

    fun getSession(context: Context?, mobile: Editable) {
        var url = URL(Constants.PROD_API_URL + Constants.urls["embed_session"])
        var retrofit = Retrofit.Builder().baseUrl(Constants.PROD_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val service = retrofit.create(EmbedService::class.java)
        val creds = okhttp3.Credentials.basic(SharedPrefsUtil.username, SharedPrefsUtil.password)
        val call = service.getEmbedSession(SharedPrefsUtil.mobile.toString(), creds)

        call.enqueue(object : Callback<EmbedSession> {
            override fun onResponse(call: Call<EmbedSession>, response: Response<EmbedSession>) {
                Log.d(Constants.TAG, response.body().toString())
                if (response.code() == 200) {
                    var res = response.body()
                    var webViewUrl = Constants.PROD_PWA_URL + "retailer/login?platform=android&session_id=" + res!!.session_id + "&business_id="+ res.business_id +"&person_id=" + res.person_id
                    Log.d(Constants.TAG, webViewUrl);

                    val intent = Intent(context, PwaActivity::class.java)
                    intent.putExtra("webViewUrl", webViewUrl)
                    startActivity(context!!, intent)
                }
            }
            override fun onFailure(call: Call<EmbedSession>, t: Throwable) {

            }
        })
    }

    companion object {
        val instance: Saraloan
            get() = Saraloan()
    }
}