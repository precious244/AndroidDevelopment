package My.practice.room.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface NewsDAO {
    @Query("select * from news")
    fun getFavoriteNews(): Flowable<List<NewsEntity>>

    @Insert
    fun insertNews(newsEntity: NewsEntity): Single<Long>
}