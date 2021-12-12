package com.example.demomvp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demomvp.R
import com.example.demomvp.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this)
        btn_login.setOnClickListener {
            loginPresenter.validateLogin(edt_username.text.toString(), edt_password.text.toString())
        }
    }

    override fun loginFail() {
        tv_error.text = getString(R.string.label_login_fail)
    }

    override fun loginSuccessful() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun setErrorPassword() {
        tv_error.text = getString(R.string.label_error_pass)
    }

    override fun setErrorUsername() {
        tv_error.text = getString(R.string.label_error_name)
    }
}
