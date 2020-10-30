package com.dicoding.ervalsa.themovieapp1.ui.detail

import com.dicoding.ervalsa.themovieapp1.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setMovieId(movieId)
        detailViewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        val movie = detailViewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.realeaseYear, movie.realeaseYear)
        assertEquals(dummyMovie.imgPoster, movie.imgPoster)
        assertEquals(dummyMovie.imgBackground, movie.imgBackground)
    }

    @Test
    fun getDetailTvShowById() {
        val tvShow = detailViewModel.getDetailTvShowById()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.description, tvShow.description)
        assertEquals(dummyTvShow.genre, tvShow.genre)
        assertEquals(dummyTvShow.realeaseYear, tvShow.realeaseYear)
        assertEquals(dummyTvShow.imgPoster, tvShow.imgPoster)
        assertEquals(dummyTvShow.imgBackground, tvShow.imgBackground)
    }
}