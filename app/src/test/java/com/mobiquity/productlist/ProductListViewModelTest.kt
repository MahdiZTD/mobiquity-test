package com.mobiquity.productlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mobiquity.datamodel.CategoryModel
import com.mobiquity.network.ApiHelper
import com.mobiquity.utils.AppSchedulerProvider
import com.mobiquity.utils.AppSchedulerProviderTest
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/4/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

@RunWith(JUnit4::class)
class ProductListViewModelTest {

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    lateinit var apiHelper: ApiHelper


    lateinit var viewModel: ProductListViewModel

    private val testScheduler:TestScheduler = TestScheduler()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val testSchedulerProvider = AppSchedulerProviderTest(testScheduler)
        viewModel = ProductListViewModel(apiHelper,testSchedulerProvider)
    }

    @Test
    fun `test api helper is not null`(){
        `when`(apiHelper.getProductList()).thenReturn(null)
        assertNotNull(viewModel.categoryLiveData)
        assertTrue(viewModel.categoryLiveData.value == null)
        assertTrue(viewModel.categories.size == 0)
    }

    @Test
    fun `test api helper have success response`(){
        val successResponse = mutableListOf(
            CategoryModel(" "," "," ",
                mutableListOf())
        )
        `when`(apiHelper.getProductList()).thenReturn(Single.just(successResponse))
        viewModel.getProducts()
        testScheduler.triggerActions()
        assertNotNull(viewModel.categoryLiveData)
        assertEquals(viewModel.categoryLiveData.value , successResponse)
    }

    @Test
    fun `test api helper have failed response`(){
        `when`(apiHelper.getProductList()).thenReturn(Single.error(Throwable("API ERROR")))
        viewModel.getProducts()
        testScheduler.triggerActions()
        assertEquals(viewModel.categoryLiveData.value , null)

    }

    @After
    fun tearDown() {
        viewModel.compositeDisposable.dispose()
    }
}