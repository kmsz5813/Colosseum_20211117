package com.nepplus.colosseum_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.nepplus.colosseum_20211117.databinding.ActivityMainBinding
import com.nepplus.colosseum_20211117.utils.ServerUtil
import org.json.JSONObject

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


            ServerUtil.putRequestSignup(inputEmail,intputPw,inputNickname, object : ServerUtil.JsonResponseHandler {
                override fun onResponse(jsonObj: JSONObject) {

                    val code = jsonObj.getInt("code")
                    if (code == 200){


                    }else{

//                        실패 -> 서버가 알려주는 "message" 에 담긴 실패 사유를 토스트로
                        val message = jsonObj.getString("message")

                        runOnUiThread {
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                        }

                    }


                }


            } )


//            서버의 회원가입


        }

    }

    override fun setValues() {

    }


}