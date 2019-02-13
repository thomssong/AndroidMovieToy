package pr.thomassong.shared.data

import io.reactivex.Single
import pr.thomassong.model.TheMovieResponse
import pr.thomassong.shared.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*


/**
 *  author thomassong
 */
interface TheMovieService {
    @GET("search/movie?api_key=${BuildConfig.TMDB_API_KEY}&language=en-US")
    fun searchMovie(@Query("query") query: String, @Query("page") page: Int = 1): Single<TheMovieResponse>

    @GET("trending/movie/day?api_key=${BuildConfig.TMDB_API_KEY}")
    fun getTrendingMovie(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "${Locale.getDefault().language}-${Locale.getDefault().country}"
    ): Single<TheMovieResponse>
}