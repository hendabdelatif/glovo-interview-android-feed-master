package com.glovoapp.feed.ui

import FeedViewModel
import com.glovoapp.feed.data.FeedService
import com.glovoapp.feed.model.entities.FeedItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import java.util.*

class FeedViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var feedService: FeedService

    @Mock
    lateinit var feedViewModel: FeedViewModel


    @Before
    fun setUp() {
        feedViewModel = FeedViewModel()
    }

    @Test
    fun `fetch feed items`() {

        val feedItemsList = mutableListOf(
            FeedItem(1, Date(), "New Feed"),
            FeedItem(2, Date(), "New Feed 2"),
            FeedItem(3, Date(), "New Feed 3")
        )

        feedViewModel.feedItems.observeForever { feedService.getLatestItems(10) { feedItemsList } }

        feedViewModel.feedItems.value = feedItemsList


    }
}