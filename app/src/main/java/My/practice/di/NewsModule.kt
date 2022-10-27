package My.practice.di

import My.practice.data.local.NewsLocalDataSource
import My.practice.data.remote.NewsRemoteDataSource
import My.practice.data.repository.NewsRepository
import My.practice.data.service.NewsService
import My.practice.retrofit.NewsRetrofit
import My.practice.room.model.NewsDAO
import My.practice.room.model.NewsDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsService(): NewsService = NewsRetrofit.newsService

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newsService: NewsService): NewsRemoteDataSource
    = NewsRemoteDataSource(newsService)

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository
    = NewsRepository(newsRemoteDataSource, newsLocalDataSource)

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext appContext: Context): NewsDatabase
     = Room.databaseBuilder(appContext, NewsDatabase::class.java, "newsDatabase").build()

    @Provides
    @Singleton
    fun provideNewsDAO(newsDatabase: NewsDatabase): NewsDAO
    = newsDatabase.newsDAO()

    @Provides
    @Singleton
    fun provideNewslocalDataSource(newsDAO: NewsDAO): NewsLocalDataSource
    = NewsLocalDataSource(newsDAO)

}