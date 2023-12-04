package com.android.news.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.news.R

class LogOnActivity : AppCompatActivity() {
    private var etName: EditText? = null
    private var etPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_on)

        findViewById<Button>(R.id.btn_register).setOnClickListener {
            startActivityForResult(Intent(this@LogOnActivity, RegisterActivity::class.java), 1)
        }
        findViewById<Button>(R.id.btn_set).setOnClickListener {
            val name = findViewById<EditText>(R.id.ed_text1).text.toString()
            val password = findViewById<EditText>(R.id.ed_password1).text.toString()
            if (!TextUtils.isEmpty(name)) {
                if (!TextUtils.isEmpty(password)) {
                    startActivity(Intent(this@LogOnActivity, MainInterfaceActivity::class.java))
                } else {
                    etPassword?.requestFocus()
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_LONG).show()
                }
            } else {
                etName?.requestFocus()
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
