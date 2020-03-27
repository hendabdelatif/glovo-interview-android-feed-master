
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glovoapp.feed.data.FeedService
import com.glovoapp.feed.model.entities.FeedItem
import com.glovoapp.feed.model.repository.FeedRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {

    private var disposable: Disposable

    val feedItems: MutableLiveData<List<FeedItem>> = MutableLiveData()

    init {

        val feedRepository = FeedRepository(FeedService())
        disposable = feedRepository.requestWithRx()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { items ->
                feedItems.value = items
            }
            .subscribe()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}