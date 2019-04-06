package pr.thomassong.shared.data.remote

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pr.thomassong.shared.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton


/**
 *  author thomassong
 */
@Module
class RemoteModule {

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
                .addInterceptor {
                    val request = it.request()
                    val queryUrl = request.url().newBuilder()
                        .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                        .addQueryParameter("language", "${Locale.getDefault().language}-${Locale.getDefault().country}")
                        .build()

                    it.proceed(request.newBuilder()
                        .url(queryUrl)
                        .build())
                }
                .build()
        )
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(
            GsonConverterFactory.create(GsonBuilder().setDateFormat("YYYY-mm-dd").create())
        )
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        .create(TheMovieService::class.java)
}