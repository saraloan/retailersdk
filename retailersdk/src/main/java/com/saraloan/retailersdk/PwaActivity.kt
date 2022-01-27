package com.saraloan.retailersdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.saraloan.retailersdk.models.EmbedSession
import com.saraloan.retailersdk.services.EmbedService
import com.saraloan.retailersdk.util.Constants
import com.saraloan.retailersdk.util.Saraloan
import com.saraloan.retailersdk.util.SharedPrefsUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class PwaActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var pwa: WebView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pwa)

        supportActionBar?.hide()
        findViewById<ImageButton>(R.id.closePwa).setOnClickListener(this);

        pwa = findViewById(R.id.pwa)
        pwa.settings.javaScriptEnabled = true
        pwa.settings.javaScriptCanOpenWindowsAutomatically = true
        pwa.settings.domStorageEnabled = true
        pwa.settings.setSupportMultipleWindows(true)
        pwa.loadUrl(intent.getStringExtra("webViewUrl").toString())

        Log.d(Constants.TAG, intent.getStringExtra("webViewUrl").toString())
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.closePwa -> {
                finish()
            }
        }
    }

}