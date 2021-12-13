package com.example.demomvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demomvp.R
import com.example.demomvp.model.Person
import com.example.demomvp.presenter.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity(), DetailView {

    private lateinit var detailPresenter: DetailPresenter
    private var mId = 0L
    private var mPerson: Person ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (intent!= null) {
            mId = intent.getLongExtra("Id", 0)
        }
        detailPresenter = DetailPresenter(this, this)
        detailPresenter.getPersonById(mId)
        btn_delete_person.setOnClickListener {
            mPerson?.let { detailPresenter.deletePerson(it) }
        }
    }

    override fun getPerson(person: Person?) {
        mPerson = person
        if (person != null) {
            tv_name_detail.text = person.name
            tv_age_detail.text = person.age.toString()
        }
    }

    override fun deleteSuccess() {
        finish()
    }
}