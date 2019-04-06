package pr.thomassong.shared.data.remote

import io.reactivex.Single
import pr.thomassong.model.TheMovie
import pr.thomassong.model.TheMovieResponse
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
}