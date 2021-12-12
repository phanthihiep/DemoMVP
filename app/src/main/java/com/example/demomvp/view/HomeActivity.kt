package com.example.demomvp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demomvp.R
import com.example.demomvp.adapter.PersonAdapter
import com.example.demomvp.dao.OnClickItemPerson
import com.example.demomvp.model.Person
import com.example.demomvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: AppCompatActivity(), HomeView, OnClickItemPerson {

    private lateinit var mAdapter: PersonAdapter
    private lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)
        homePresenter = HomePresenter(this, this)
    }

    override fun listPerson(list: ArrayList<Person>) {
        mAdapter = PersonAdapter(list, this)
        val manager = LinearLayoutManager(this)
        rc_home.apply {
            layoutManager = manager
            adapter = mAdapter
        }
    }

    override fun onClickItem(id: Long?) {
        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
    }
}
