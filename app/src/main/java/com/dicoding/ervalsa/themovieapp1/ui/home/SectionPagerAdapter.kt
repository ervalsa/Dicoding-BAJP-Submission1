package com.dicoding.ervalsa.themovieapp1.ui.home

import android.content.Context
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.ervalsa.themovieapp1.R
import com.dicoding.ervalsa.themovieapp1.ui.home.content.movie.MovieFragment
import com.dicoding.ervalsa.themovieapp1.ui.home.content.tv.TvShowFragment

class SectionPagerAdapter (private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitle = intArrayOf(
        R.string.movie,
        R.string.tv_show
    )

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvShowFragment()
        }

        return  fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(tabTitle[position])
    }

    override fun getCount(): Int {
        return 2
    }
}