package com.example.demomvp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demomvp.dao.PersonDao
import com.example.demomvp.model.Person

@Database(entities = [Person::class], version = 1)
abstract class MainDatabase: RoomDatabase() {

    abstract fun personDataDao(): PersonDao

    companion object {
        private const val DATABASE_NAME: String = "person.db"
        private var INSTANCE: MainDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MainDatabase? {
            if (INSTANCE == null) {
                synchronized(MainDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MainDatabase::class.java,
                        DATABASE_NAME
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}
