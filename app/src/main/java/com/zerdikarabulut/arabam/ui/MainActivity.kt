package com.zerdikarabulut.arabam.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zerdikarabulut.arabam.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Arabam)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}