package com.example.dictionary_app_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent=getIntent()
        val m=intent.getStringExtra("msg")
        tv_definition.text=m
        imageView.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}