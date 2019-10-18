package com.leagmain.tudou

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.leagmain.tudou.createtask.R
import com.leagmain.tudou.createtask.TuDouActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateTuDouTest {
    @Test
    fun create() {
        // GIVEN
        ActivityScenario.launch(TuDouActivity::class.java)

        // WHEN
        onView(withId(R.id.floating_add)).perform(click())
        onView(withId(R.id.tudou_name)).perform(typeText("tudou"), closeSoftKeyboard())
        onView(withId(R.id.tudou_content)).perform(
            typeText("tudou is very delicious"),
            closeSoftKeyboard()
        )

        onView(withId(R.id.done)).perform(click())

        // THEN
        onView(withText("tudou")).check(matches(isDisplayed()))

    }
}