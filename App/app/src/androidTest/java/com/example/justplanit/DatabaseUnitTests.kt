package com.example.justplanit

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
@SmallTest
class DatabaseUnitTests {

    private lateinit var database: SqlDatabase
    private lateinit var wordsDao: GetSqlData

    @Before
    fun setupDatabase() {
        //init application database
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SqlDatabase::class.java
        ).allowMainThreadQueries().build()

        //get database access object
        wordsDao = database.getSqlData
    }

    @Test
    fun saveAndReadAchievement() {
        //create test achievement
        val testAchievement = Achievement("testAchievement", Date(), "")
        //save test achievement
        wordsDao.insAchievemnt(testAchievement)
        //read achievement from database
        val readAchievement = wordsDao.selAchievementName("testAchievement")
        //check that all read ok
        assertEquals(testAchievement.name, readAchievement.name)
    }

    @Test
    fun saveAndRemoveInterval() {
        //create test fortschritt
        val testFortschritt = Fortschritt(Random().nextInt())
        //save test fortschritt
        wordsDao.insFortschritt(testFortschritt)
        //remove test fortschritt from database
        wordsDao.delFortschritt(testFortschritt.id.toString())
        //try to read removed readFortschritt
        val readFortschritts =
            wordsDao.selFortschritte(testFortschritt.metrik, testFortschritt.aktivitaet)
        //size should be 0 because we remove it previously
        assertEquals(readFortschritts.size, 0)
    }

    @Test
    fun saveAndUpdateAchievement() {
        //test note for check later update
        val testNote = "test note"
        //create achievement for test
        val testAchievement = Achievement("testAchievement", Date(), "", kommentar = "test note")

        //save achievement into database
        wordsDao.insAchievemnt(testAchievement)
        //update achievement's note
        wordsDao.updAchievementNote(testAchievement.name, testNote + "2")
        //read updated achievement from database
        val updatedAchievement = wordsDao.selAchievementName(testAchievement.name)
        //check that all updated ok
        assertEquals(updatedAchievement.kommentar, testNote + "2")
    }

}