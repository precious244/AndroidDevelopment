package My.practice.data.repository

import My.practice.data.local.NewsLocalDataSource
import My.practice.data.remote.NewsRemoteDataSource
import My.practice.model.Article
import My.practice.model.NewsResponse
import My.practice.room.model.NewsEntity
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
    ) {

    fun getRandomNews(key: String): Single<NewsResponse> {
        return newsRemoteDataSource.getRandomNews(key)
    }

    fun insertNews(article: Article): Single<Long> {
        val newsEntity = NewsEntity(
            title = article.title,
            author = article.author,
            imageUrl = article.urlToImage,
            description = article.description,
            publishedAt = article.publishedAt)
        return newsLocalDataSource.insertNews(newsEntity)
    }

    fun getFavoriteNews(): Flowable<List<Article>> {
        return newsLocalDataSource.getFavoriteNews().map{
            toNewsResponses(it)
        }
    }

    private fun toNewsResponse(newsEntity: NewsEntity): Article {
        return Article(
            newsEntity.author,
            "",
            newsEntity.description,
            newsEntity.publishedAt,
            newsEntity.title,
            "",
            newsEntity.imageUrl
        )
    }

    private fun toNewsResponses(newsEntities: List<NewsEntity>): List<Article>{
        return newsEntities.map{
            toNewsResponse(it)
        }.toList()
    }
}