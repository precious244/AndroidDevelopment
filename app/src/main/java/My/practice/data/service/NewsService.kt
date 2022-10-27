package My.practice.data.service

import My.practice.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/everything?domains=wsj.com")
    fun getRandomNews(
        @Query("apiKey") key: String):
            Single<NewsResponse>
}