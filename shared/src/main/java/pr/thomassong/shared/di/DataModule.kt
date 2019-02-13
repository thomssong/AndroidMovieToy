package pr.thomassong.shared.di

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pr.thomassong.shared.data.NYTimesService
import pr.thomassong.shared.data.OpenMovieService
import pr.thomassong.shared.data.TheMovieService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


/**
 *  author thomassong
 */
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideNYTimesService(): NYTimesService = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        .create(NYTimesService::class.java)

    @Singleton
    @Provides
    fun provideOpenMovieService(): OpenMovieService = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        .create(OpenMovieService::class.java)

    @Singleton
    @Provides
    fun provideTheMovieService(): TheMovieService = Retrofit.Builder()
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build()
        )
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        .create(TheMovieService::class.java)
}