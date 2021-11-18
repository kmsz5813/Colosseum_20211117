package com.nepplus.colosseum_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.nepplus.colosseum_20211117.databinding.ActivityMainBinding
import com.nepplus.colosseum_20211117.databinding.ActivitySignUpBinding
import com.nepplus.colosseum_20211117.utils.ServerUtil
import org.json.JSONObject

class SignUpActivity : BaseActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnOk.setOnClickListener {

            val inputEmail = binding.edtEmail.text.toString()

            val intputPw = binding.edtPassword.text.toString()
            val inputNickname = binding.edtNickName.text.toString()


            ServerUtil.putRequestSignup(
                inputEmail,
                intputPw,
                inputNickname,
                object : ServerUtil.JsonResponseHandler {
                    override fun onResponse(jsonObj: JSONObject) {

                        val code = jsonObj.getInt("code")
                        if (code == 200) {

//                        가입한 사람의 닉네임을 추출 -> 토스트로 환영메세지

                            val dataObj = jsonObj.getJSONObject("data")
                            val userObj = dataObj.getJSONObject("user")

                            val nickname = userObj.getString("nick_name")

//                        토스트로 환영 메세지 + 회워가입 화면 종료

                            runOnUiThread {
                                Toast.makeText(
                                    mContext,
                                    "${nickname}님, 회원가입을 축하합니다.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                finish()

                            }


                        } else {


//                        실패 -> 서버가 알려주는 "message" 에 담긴 실패 사유를 토스트로
                            val message = jsonObj.getString("message")

                            runOnUiThread {
                                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                            }

                        }


                    }


                })


//            서버의 회원가입


        }

    }

    override fun setValues() {

    }


}