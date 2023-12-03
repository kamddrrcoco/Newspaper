package com.android.mytest.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.mytest.R


class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        findViewById<Button>(R.id.btn_set).setOnClickListener {
            val name: String = findViewById<EditText>(R.id.ed_text2).text.toString().trim()
            val password: String = findViewById<EditText>(R.id.ed_password2).text.toString().trim()
            val intent = Intent()
            intent.putExtra("name", name)
            intent.putExtra("password", password)
            setResult(2, intent)
            finish()
        }
    }
}