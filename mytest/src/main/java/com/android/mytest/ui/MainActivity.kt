package com.android.mytest.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.mytest.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_register).setOnClickListener {
            startActivityForResult(Intent(this@MainActivity, AddActivity::class.java), 1)
        }
        findViewById<Button>(R.id.btn_set).setOnClickListener {
            startActivity(Intent(this@MainActivity, Activity::class.java))
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == 2) {
            val name = data?.getStringExtra("name")
            val password = data?.getStringExtra("password")
            findViewById<EditText>(R.id.ed_text1).setText(name)
            findViewById<EditText>(R.id.ed_password1)?.setText(password)
        }
    }
}
