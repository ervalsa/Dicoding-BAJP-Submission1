package com.dicoding.ervalsa.themovieapp1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.ervalsa.themovieapp1.R
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        carouselView.pageCount = carouselImages.size
        carouselView.setImageListener(imageListener)

        setSupportActionBar(toolBar)
        supportActionBar?.title = ""
        supportActionBar?.elevation = 0f

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(viewPager)


    }

    val carouselImages = intArrayOf(
        R.drawable.latar_wreck_it_ralph,
        R.drawable.latar_the_simpson,
        R.drawable.latar_naruto_shipudden,
        R.drawable.latar_how_to_train
    )

    val imageListener = ImageListener {position, imageView ->
        imageView.setImageResource(carouselImages[position])
    }
}