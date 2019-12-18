package com.zhm.example.kt_learn191218

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_hello).setText("Kotlin项目")
        findViewById<TextView>(R.id.tv_hello).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val toast = Toast(this@MainActivity)
                toast.setText("我是提示君~~")
                toast.show()
            }

        })
    }
}
