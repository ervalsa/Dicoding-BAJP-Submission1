package com.dicoding.ervalsa.themovieapp1.ui.home.content.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.ervalsa.themovieapp1.R
import com.dicoding.ervalsa.themovieapp1.model.DataEntity
import com.dicoding.ervalsa.themovieapp1.ui.detail.DetailActivity
import com.dicoding.ervalsa.themovieapp1.ui.home.content.ContentAdapter
import com.dicoding.ervalsa.themovieapp1.ui.home.content.ContentCallback
import com.dicoding.ervalsa.themovieapp1.ui.home.content.ContentViewModel
import com.dicoding.ervalsa.themovieapp1.utils.Helper.TYPE_TVSHOW
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment(), ContentCallback {

    private lateinit var viewModel: ContentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]
        }

        val listTvShow = viewModel.getListTvShow()
        setRecycler(listTvShow)
    }

    private fun setRecycler(data: List<DataEntity>) {
        rv_tv_show.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ContentAdapter(this@TvShowFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is ContentAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DataEntity) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }

}