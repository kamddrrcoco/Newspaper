package com.android.mytest.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mytest.R


class AddActivity : AppCompatActivity() {
    private var etName: EditText? = null
    private var etPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        findViewById<Button>(R.id.btn_set).setOnClickListener {
            val name = findViewById<EditText>(R.id.ed_text2).text.toString().trim()
            val password = findViewById<EditText>(R.id.ed_password2).text.toString().trim()
            val intent = Intent()
            if (!TextUtils.isEmpty(name)) {
                if (!TextUtils.isEmpty(password)){
                    intent.putExtra("name", name)
                    intent.putExtra("password", password)
                    setResult(2, intent)
                    finish()
                }else{
                    etName?.requestFocus()
                    Toast.makeText(this,"密码不能为空",Toast.LENGTH_LONG).show()
                }
            } else {
                etPassword?.requestFocus()
                Toast.makeText(this,"账号不能为空",Toast.LENGTH_LONG).show()
            }
        }
    }
}