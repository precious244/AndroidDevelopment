package My.practice.data.local

import My.practice.room.model.NewsDAO
import My.practice.room.model.NewsEntity
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class NewsLocalDataSource @Inject constructor(private val newsDAO: NewsDAO) {

    fun getFavoriteNews(): Flowable<List<NewsEntity>> {
        return newsDAO.getFavoriteNews()
    }

    fun insertNews(newsEntity: NewsEntity): Single<Long> {
        return newsDAO.insertNews(newsEntity)
    }


}