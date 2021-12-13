package com.example.demomvp.view

import com.example.demomvp.model.Person

interface DetailView {
    fun getPerson(person: Person?)

    fun deleteSuccess()
}