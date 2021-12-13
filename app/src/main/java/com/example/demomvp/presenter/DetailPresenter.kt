package com.example.demomvp.presenter

import android.content.Context
import com.example.demomvp.model.Person
import com.example.demomvp.model.PersonCallback
import com.example.demomvp.model.PersonInteractor
import com.example.demomvp.view.DetailView

class DetailPresenter(var context: Context, var detailView: DetailView): PersonCallback {
    private lateinit var personInteractor: PersonInteractor

    init {
        personInteractor = PersonInteractor(context, this)
    }

    fun getPersonById(id: Long) {
        personInteractor.getPersonById(id)
    }

    fun deletePerson(person: Person) {
        personInteractor.deletePerson(person)
    }

    override fun personWithId(person: Person?) {
        detailView.getPerson(person)
    }

    override fun deleteSuccess() {
        detailView.deleteSuccess()
    }

    override fun getListPerSon(list: ArrayList<Person>) {
        // no-ops
    }
}