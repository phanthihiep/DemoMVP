package com.example.demomvp.presenter

import com.example.demomvp.model.CallbackListener
import com.example.demomvp.model.User
import com.example.demomvp.model.UserInteractor
import com.example.demomvp.view.LoginView

class LoginPresenter(private var loginView: LoginView) : CallbackListener {

    private lateinit var user : User
    private var userInteractor: UserInteractor = UserInteractor(this)

    init {
        userInteractor.getUser()
    }

    override fun getUser(user: User) {
        this.user = user
    }

    fun validateLogin(userName: String, password: String) {
        when {
            userName.isEmpty() -> loginView.setErrorUsername()
            password.isEmpty() -> loginView.setErrorPassword()
            else -> {
                if (userName == user.username && password == user.password) {
                    loginView.loginSuccessful()
                } else {
                    loginView.loginFail()
                }
            }
        }
    }
}
