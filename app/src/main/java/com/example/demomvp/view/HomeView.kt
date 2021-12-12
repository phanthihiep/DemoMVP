package com.example.demomvp.view

import com.example.demomvp.model.Person

interface HomeView {
    fun listPerson(list: ArrayList<Person>)
}