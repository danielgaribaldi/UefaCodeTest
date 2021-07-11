package com.uefa


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.uefa.ui.CompetitionActivity
import com.uefa.ui.CompetitionSelectionActivity

import org.junit.runner.RunWith

import org.junit.Rule
import org.junit.Test


/**
 * Small Ui tests
 */
@RunWith(AndroidJUnit4::class)
class SomeSmallUiTests {

    @Rule
    @JvmField
    val mActivityTestRule = IntentsTestRule(CompetitionSelectionActivity::class.java)

    @Test
    fun testButtonsForCompetitionsAreDisplayed() {

        onView(withId(R.id.button_uel)).check(matches(isDisplayed()))
        onView(withId(R.id.button_ucl)).check(matches(isDisplayed()))
    }

    @Test
    fun testUCLButton() {

        onView(withId(R.id.button_ucl)).perform(click())
        intended(hasComponent(CompetitionActivity::class.java.name))
    }


    @Test
    fun testUELButton() {

        onView(withId(R.id.button_uel)).perform(click())
        intended(hasComponent(CompetitionActivity::class.java.name))
    }
}