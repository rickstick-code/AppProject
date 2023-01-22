package com.example.justplanit

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith



//before starting Test-> animations : to be disabled for UI testing -> in gradle test opt. animations disabled
@RunWith(AndroidJUnit4::class)
class CreateResolutionTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun initActivity() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun basicNavigationTest() {
        //check start screen
        try {
            //check title for home screen
            onView(withId(R.id.home_motd))
        } catch (e: NoMatchingViewException) {
            //if title not match fail test
            fail("the view should be on screen")
        }
        onView(withId(R.id.navigation_progress)).perform(click())
        try {
            //check title for progress screen
            onView(withId(R.id.progress_header))
        } catch (e: NoMatchingViewException) {
            //if title not match fail test
            fail("the view should be on screen")
        }
        onView(withId(R.id.navigation_achievements)).perform(click())
        try {
            //check title for achievements screen
            onView(withId(R.id.achievements_header))
        } catch (e: NoMatchingViewException) {
            //if title not match fail test
            fail("the view should be on screen")
        }
    }

    @Test
    fun addResolution() {
        val testText = "test resolution"
        //find new resolution button and click it
        onView(withId(R.id.home_resolution_create)).perform(click())
        //find resolution name field and fill test text into in
        onView(withId(R.id.resolution_name)).perform(replaceText(testText))
        //press save button
        onView(withId(R.id.resolution_save)).perform(click())
        try {
            //try to find created resolution in list
            onView(withText(testText))
        } catch (e: NoMatchingViewException) {
            //fail test if nothing found
            fail("The view isn't presented");
        }
    }

    @Test
    fun removeResolution() {
        val testText = "test resolution1"
        //find new resolution button and click it
        onView(withId(R.id.home_resolution_create)).perform(click())
        //find resolution name field and fill test text into in
        onView(withId(R.id.resolution_name)).perform(replaceText(testText))
        //press save button
        onView(withId(R.id.resolution_save)).perform(click())
        try {
            //try to find item added in previous test and click
            onView(withText(testText)).perform(click())
            //try to remove resolution in resolution screen
            onView(withId(R.id.respro_end)).perform(click())
            try {
                //try to find item we removed earlier
                onView(withText(testText)).perform(click())
                fail("the view still there")
            } catch (e: NoMatchingViewException) {
                //test passed
            }
        } catch (e: NoMatchingViewException) {
            fail("The view isn't presented");
        }
    }


}