package com.glovoapp.feed

import FeedViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_feed.*


class FeedActivity : AppCompatActivity() {

    private lateinit var feedViewModel: FeedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        feedViewModel.feedItems.observe(this, Observer {
            val feedItemAdapter = FeedItemAdapter(it)

            recycler.apply {
                layoutManager = LinearLayoutManager(this@FeedActivity)
                adapter = feedItemAdapter
            }
        })

    }

}


