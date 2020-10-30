package com.dicoding.ervalsa.themovieapp1.ui.home.content

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ContentViewModelTest {
    private lateinit var viewModel: ContentViewModel

    @Before
    fun setUp() {
        viewModel = ContentViewModel()
    }

    @Test
    fun getListMovie() {
        val movie = viewModel.getListMovie()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }

    @Test
    fun getListTvShow() {
        val tvShow = viewModel.getListTvShow()
        assertNotNull(tvShow)
        assertEquals(10, tvShow.size)
    }
}