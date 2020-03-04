package com.mobiquity.productdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mobiquity.datamodel.Product
import com.mobiquity.datamodel.SalePrice
import com.mobiquity.productlist.ProductListViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/4/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
@RunWith(JUnit4::class)
class ProductDetailViewModelTest {

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    lateinit var viewModel: ProductDetailViewModel

    @Before
    fun setUp() {
        viewModel = ProductDetailViewModel()
    }

    @Test
    fun `test value is set correctly`() {
        val mockProduct = Product("catId","description","id", "p_name", SalePrice("100","EURO"),"/IMAGE")
        viewModel.setProduct(mockProduct)
        assertEquals(viewModel.productImage.get(), mockProduct.url)
        assertEquals(viewModel.productName.get(), mockProduct.name)
        assertEquals(viewModel.productPrice.get(), "${mockProduct.salePrice.amount} ${mockProduct.salePrice.currency}")
    }
}