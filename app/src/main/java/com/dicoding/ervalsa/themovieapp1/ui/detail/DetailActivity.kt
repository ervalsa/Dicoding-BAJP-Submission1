package com.dicoding.ervalsa.themovieapp1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dicoding.ervalsa.themovieapp1.R
import com.dicoding.ervalsa.themovieapp1.model.DataEntity
import com.dicoding.ervalsa.themovieapp1.utils.Helper.TYPE_MOVIE
import com.dicoding.ervalsa.themovieapp1.utils.Helper.TYPE_TVSHOW
import com.dicoding.ervalsa.themovieapp1.utils.Helper.setGlideImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var result: DataEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(this@DetailActivity, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        supportActionBar?.title = "Detail Film"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            id?.let {
                viewModel.setMovieId(it)
            }
            result = viewModel.getDetailMovieById()
        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            id?.let {
                viewModel.setTvShowId(it)
            }
            result = viewModel.getDetailTvShowById()
        }

        tv_title.text = result.title
        tv_desc.text = result.description
        tv_realase_date.text = result.realeaseYear
        tv_genre.text = result.genre
        setGlideImage(this@DetailActivity, result.imgPoster, img_item_photo)
        setGlideImage(this@DetailActivity, result.imgBackground, img_item_preview)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}