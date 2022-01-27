package com.saraloan.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.saraloan.retailersdk.util.Saraloan
import java.io.File
import java.io.FileInputStream
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mobile: EditText;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sdkButton).setOnClickListener(this);
        mobile = findViewById<EditText>(R.id.mobile);

        Saraloan.instance
            .with(application)
            .initialize("", "");
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.sdkButton -> openSdk()
        }
    }

    private fun openSdk() {
        Saraloan.instance.launch(this, mobile.text.toString())
    }
}