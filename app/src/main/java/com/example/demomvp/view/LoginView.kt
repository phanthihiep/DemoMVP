package com.example.demomvp.view

interface LoginView {
    fun loginFail()

    fun loginSuccessful()

    fun setErrorPassword()

    fun setErrorUsername()
}
