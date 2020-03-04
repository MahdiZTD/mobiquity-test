package com.mobiquity.productdetail

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.mobiquity.R
import com.mobiquity.productlist.ProductListActivity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/4/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
class ProductDetailActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<ProductDetailActivity> = ActivityTestRule(ProductDetailActivity::class.java)



    @Test
    fun onCreate() {
        Espresso.onView(ViewMatchers.withId(R.id.txt_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.txt_price))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.img_product))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}