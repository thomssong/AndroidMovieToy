package pr.thomassong.shared.data.remote

import io.reactivex.Single
import pr.thomassong.shared.BuildConfig
import retrofit2.http.GET


/**
 *  author thomassong
 */
interface OpenMovieService {
    @GET("?apikey=${BuildConfig.OMDB_API_KEY}")
    fun searchMovie(query: String): Single<Any>
}