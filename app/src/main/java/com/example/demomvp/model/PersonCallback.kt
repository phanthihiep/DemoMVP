package com.example.demomvp.model

interface PersonCallback {
    fun getListPerSon(list: ArrayList<Person>)

    fun personWithId(person: Person?)

    fun deleteSuccess()
}