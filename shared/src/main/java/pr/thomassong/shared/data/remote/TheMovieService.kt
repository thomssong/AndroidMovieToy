package pr.thomassong.shared.data.remote

import io.reactivex.Single
import pr.thomassong.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 *  author thomassong
 */
interface TheMovieService {
    @GET("search/movie")
    fun searchMovie(@Query("query") query: String, @Query("page") page: Int = 1): Single<TheMovieResponse>

    @GET("trending/movie/day")
    fun getTrendingMovie(
        @Query("page") page: Int = 1
    ): Single<TheMovieResponse>

    @GET("movie/{movieId}")
    fun getMovieDetail(@Path("movieId") movieId: Long): Single<TheMovie>

    @GET("movie/{movieId}/credits")
    fun getMovieCredits(@Path("movieId") movieId: Long): Single<TheMovieCredits>

    @GET("movie/{movieId}/videos")
    fun getMovieVideos(@Path("movieId") movieId: Long): Single<TheMovieVideoResponse>

    @GET("movie/{movieId}/images")
    fun getMovieImages(@Path("movieId") movieId: Long): Single<TheMovieImageResponse>
}