package com.dicoding.ervalsa.themovieapp1.ui.home.content

import com.dicoding.ervalsa.themovieapp1.model.DataEntity

interface ContentCallback {
    fun onItemClicked(data: DataEntity)
}