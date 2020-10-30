package com.dicoding.ervalsa.themovieapp1.ui.home.content

import androidx.lifecycle.ViewModel
import com.dicoding.ervalsa.themovieapp1.model.DataEntity
import com.dicoding.ervalsa.themovieapp1.utils.DataDummy

class ContentViewModel : ViewModel() {

    fun getListMovie() : List<DataEntity> = DataDummy.generateDummyMovies()

    fun getListTvShow() : List<DataEntity> = DataDummy.generateDummyTvShows()
}