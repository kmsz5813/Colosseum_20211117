package com.nepplus.colosseum_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nepplus.colosseum_20211117.databinding.ActivityMainBinding

class SignUpActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }


}