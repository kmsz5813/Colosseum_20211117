package com.nepplus.colosseum_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nepplus.colosseum_20211117.databinding.ActivityLoginBinding
import com.nepplus.colosseum_20211117.databinding.ActivityMain1Binding

class MainActivity1 : BaseActivity {

    lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        binding = DataBindingUtil.setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {

    }

    override fun setValues() {

    }


}