package com.android.mytest.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mytest.R

class MainActivity : AppCompatActivity() {
    private var etName: EditText? = null
    private var etPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_register).setOnClickListener {
            startActivityForResult(Intent(this@MainActivity, AddActivity::class.java), 1)
        }
        findViewById<Button>(R.id.btn_set).setOnClickListener {
            val name = findViewById<EditText>(R.id.ed_text1).text.toString()
            val password = findViewById<EditText>(R.id.ed_password1).text.toString()
            if (!TextUtils.isEmpty(name)) {
                if (!TextUtils.isEmpty(password)) {
                    startActivity(Intent(this@MainActivity, Activity::class.java))
                } else {
                    etName?.requestFocus()
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_LONG).show()
                }
            } else {
                etPassword?.requestFocus()
                Toast.makeText(this, "账号不能为空", Toast.LENGTH_LONG).show()
            }
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
