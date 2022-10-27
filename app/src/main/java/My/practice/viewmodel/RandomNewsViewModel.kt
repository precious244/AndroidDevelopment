package My.practice.viewmodel

import My.practice.data.remote.NewsRemoteDataSource
import My.practice.data.repository.NewsRepository
import My.practice.model.Article
import My.practice.model.NewsResponse
import My.practice.utils.ViewState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RandomNewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
)
: ViewModel() {
    private var randomNewsLiveData = MutableLiveData<NewsResponse>()
    private val compositeDisposable = CompositeDisposable()
    private val listArticleLiveData = MutableLiveData<List<Article>>()
    val insertNewsLiveData = MutableLiveData<ViewState<Boolean>>()

    fun getRandomNews(key: String){
        compositeDisposable.add(
            newsRepository.getRandomNews(key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewsResponse>() {
                    override fun onSuccess(t: NewsResponse) {
                        randomNewsLiveData.value = t
                        listArticleLiveData.value = t.articles
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun insertNews(article: Article){
        compositeDisposable.add(
            newsRepository.insertNews(article)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Long>(){
                    override fun onSuccess(t: Long) {
                        insertNewsLiveData.value = ViewState.success(true)
                    }

                    override fun onError(e: Throwable) {
                        insertNewsLiveData.value = ViewState.error("Failed to insert data", null)
                    }
                })
        )
    }

    fun getRandomNewsLiveData(): MutableLiveData<List<Article>> = listArticleLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}