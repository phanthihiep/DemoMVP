package com.example.demomvp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.demomvp.model.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person WHERE id = :id")
    fun getPerson(id: Long): Person

    @Query("SELECT * from person")
    fun getPersonAll(): List<Person>

    @Insert
    fun insert(person: Person)

    @Delete
    fun delete(person: Person)

    @Query("UPDATE person SET name = :name, age = :age WHERE id = :id")
    fun update(id: Long, name: String, age: Int)
}