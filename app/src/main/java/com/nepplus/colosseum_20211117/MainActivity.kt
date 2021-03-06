package com.nepplus.colosseum_20211117

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.nepplus.colosseum_20211117.databinding.ActivityLoginBinding
import com.nepplus.colosseum_20211117.utils.ServerUtil
import org.json.JSONObject

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupEvents()
        setValues()


    }

    override fun setupEvents() {

        binding.btnLoginUp.setOnClickListener {

            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)


        }


        binding.btnLogin.setOnClickListener {

            val inputEmail = binding.edtEmail.text.toString()
            val inputPw = binding.edtPassword.text.toString()
            ServerUtil.getRequestDuplCheck("EMAIL",inputEmail, object : ServerUtil.JsonResponseHandler){

                val code = jsonObj.getInt("code")
                runOnUiThread {

                    if (code == 200){


                        binding.txtEmailCheckResult.text = "사용해도 좋습니다"
                    }
                }

            }

//            서버에서 이메일 / 비번이 맞는 계정인지? 로그인 요청
            ServerUtil.postRequestLogIn(
                inputEmail,
                inputPw,
                object : ServerUtil.JsonResponseHandler {
                    override fun onResponse(jsonObj: JSONObject) {

//                        로그인 API를 호출하고 돌아온 상황
//                        결과로 jsonObj 하나를 받아서 돌아온 상황


                        val code = jsonObj.getInt("code")

//                        code : 200 -> 로그인 성공 토스스
//                        그외 -> 로그인 실패 토스트
                        runOnUiThread {
                            if (code == 200) {




                            }  else {
                                val message = jsonObj.getString("message")
                                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()

//                                message String으로 실패 사유를 알려준다.
//                                JSON 파싱으로 추출해서 -> "로그인 실패" 대신 서버가 알려준 실패 사유를 띄우자.

                            }

                        }


                    }


                })


        }

    }

    override fun setValues() {

    }


}