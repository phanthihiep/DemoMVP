package com.example.demomvp.model

import android.content.Context
import com.example.demomvp.database.MainDatabase

class PersonInteractor(context: Context, var listener: PersonCallback) {

    private var mDb: MainDatabase? = null

    init {
        mDb = MainDatabase.getInstance(context)
    }

    fun createData() {
        val list = ArrayList<Person>()
        list.add(Person(null, "Nguyễn Văn A", 20))
        list.add(Person(null, "Đặng Thùy Trang", 25))
        list.add(Person(null, "Đinh Lan Phương", 28))
        list.add(Person(null, "Nguyễn Tuấn Vũ", 27))
        list.add(Person(null, "Vũ Hải Yến", 27))
        list.add(Person(null, "Nguyễn Thế Anh", 26))
        list.add(Person(null, "Phùng Duy Phong", 29))

        for (person in list) {
            mDb?.personDataDao()?.insert(person)
        }
    }

    fun getListPerson() {
        val list = ArrayList<Person>()
        val listData = mDb?.personDataDao()?.getPersonAll()
        listData?.let {
            list.addAll(it)
        }
        listener.getListPerSon(list)
    }

    fun getPersonById(id: Long) {
        val person = mDb?.personDataDao()?.getPerson(id)
        listener.personWithId(person)
    }

    fun deletePerson(person: Person) {
        mDb?.personDataDao()?.delete(person)
        listener.deleteSuccess()
    }
}