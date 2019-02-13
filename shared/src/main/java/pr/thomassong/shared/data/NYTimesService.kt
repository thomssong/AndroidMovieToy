package pr.thomassong.shared.data

import io.reactivex.Single
import pr.thomassong.model.NYTimesResponse
import pr.thomassong.shared.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query


/**
 *  author thomassong
 */
interface NYTimesService {
    @GET("svc/movies/v2/reviews/search.json?api-key=${BuildConfig.NYTIMES_API_KEY}")
    fun searchMovieReviews(@Query("query") query: String): Single<NYTimesResponse>
}