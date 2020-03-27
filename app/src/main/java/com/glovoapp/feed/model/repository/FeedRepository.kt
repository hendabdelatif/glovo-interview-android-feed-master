package com.glovoapp.feed.model.repository

import com.glovoapp.feed.data.FeedService
import com.glovoapp.feed.model.entities.FeedItem
import io.reactivex.Single


class FeedRepository(private val feedService: FeedService) {

    fun getLatestItems(onComplete: (List<FeedItem>) -> Unit) {
        feedService.getLatestItems { items ->
            onComplete(items)
        }
    }

    fun requestWithRx(): Single<List<FeedItem>> {
        return Single.create { emitter ->
            FeedService().getLatestItems { items ->
                emitter.onSuccess(items)
            }
        }
    }

}