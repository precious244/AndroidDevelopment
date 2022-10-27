package My.practice.data.remote

import My.practice.data.service.NewsService
import My.practice.model.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
    private val newsService: NewsService) {

    fun getRandomNews(key: String): Single<NewsResponse> {
        return newsService.getRandomNews(key)

    }
}