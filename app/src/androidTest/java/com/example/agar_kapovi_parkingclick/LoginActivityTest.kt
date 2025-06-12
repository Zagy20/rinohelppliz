package com.example.agar_kapovi_parkingclick

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testSuccessfulLogin() {

        onView(withId(R.id.etUsername)).perform(typeText("mzagar"), closeSoftKeyboard())
        onView(withId(R.id.etPassword)).perform(typeText("1234"), closeSoftKeyboard())


        onView(withId(R.id.btnLogin)).perform(click())


        onView(withId(R.id.etLocation)).check(matches(isDisplayed()))
    }
    @Test
    fun testNavigateToSettingsFromMainActivity() {

        onView(withId(R.id.etUsername)).perform(typeText("mzagar"), closeSoftKeyboard())
        onView(withId(R.id.etPassword)).perform(typeText("1234"), closeSoftKeyboard())
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.nav_settings)).perform(click())

        onView(withId(R.id.etChangePassword)).check(matches(isDisplayed()))
    }

    @Test
    fun testFullParkingFlow() {

        onView(withId(R.id.etUsername)).perform(typeText("mzagar"), closeSoftKeyboard())
        onView(withId(R.id.etPassword)).perform(typeText("1234"), closeSoftKeyboard())
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.etLocation)).check(matches(isDisplayed()))

        val lokacija = "Zagreb"
        onView(withId(R.id.etLocation)).perform(typeText(lokacija), closeSoftKeyboard())

        onView(withId(R.id.btnSearch)).perform(click())

        onView(withId(R.id.tvParkingResult))
            .check(matches(withText("Parking mjesto pronađeno na lokaciji: $lokacija")))

        onView(withId(R.id.btnReserve)).perform(click())

        onView(withId(R.id.tvParkingResult))
            .check(matches(withText("Parking mjesto rezervirano!")))
    }


}
