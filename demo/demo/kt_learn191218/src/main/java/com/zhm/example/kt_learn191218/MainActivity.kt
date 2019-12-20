package com.zhm.example.kt_learn191218

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_hello).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "我是提示君~~", Toast.LENGTH_SHORT).show()
            }

        })

        findViewById<TextView>(R.id.tv_jump).setOnClickListener { v ->
            val intent = Intent(this@MainActivity,
                    ListActivity::class.java)
            startActivity(intent)
        }

    }
}
