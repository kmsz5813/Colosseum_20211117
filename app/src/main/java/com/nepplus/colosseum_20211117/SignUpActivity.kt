package com.nepplus.colosseum_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nepplus.colosseum_20211117.databinding.ActivityMainBinding

class SignUpActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnOk.setOnClickListener{

            val inputEmail = binding.edtEmail.text.toString()

            val intputPw = binding.edtPassword.text.toString()
            val inputNickname = binding.edtNickname.text.toString()


//            서버의 회원가입


        }

    }

    override fun setValues() {

    }


}