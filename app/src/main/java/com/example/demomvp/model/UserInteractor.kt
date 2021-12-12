package com.example.demomvp.model

class UserInteractor(private var listener: CallbackListener) {

    // handler create data
    fun getUser() {
        val user = User("admin", "admin123")
        listener.getUser(user)
    }
}
