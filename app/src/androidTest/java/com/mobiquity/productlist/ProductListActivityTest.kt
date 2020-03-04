package com.mobiquity.productlist

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.mobiquity.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Mahdi Zare Tahghigh Doost on 3/4/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

@RunWith(AndroidJUnit4::class)
class ProductListActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<ProductListActivity> = ActivityTestRule(ProductListActivity::class.java)

    @Test
    fun onCreate() {
        onView(withId(R.id.rv_categories))
            .check(matches(isDisplayed()))
    }
}