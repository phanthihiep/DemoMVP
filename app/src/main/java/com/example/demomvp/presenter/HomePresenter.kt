package com.example.demomvp.presenter

import android.content.Context
import com.example.demomvp.model.Person
import com.example.demomvp.model.PersonCallback
import com.example.demomvp.model.PersonInteractor
import com.example.demomvp.view.HomeView

class HomePresenter(context: Context, var homeView: HomeView): PersonCallback {

    private var personInteractor: PersonInteractor = PersonInteractor(context, this)

    companion object {
        private var isCreateData = false
    }

    init {
        if (!isCreateData) {
            personInteractor.createData()
            isCreateData = true
        }
        personInteractor.getListPerson()
    }

    override fun getListPerSon(list: ArrayList<Person>) {
        homeView.listPerson(list)
    }
}