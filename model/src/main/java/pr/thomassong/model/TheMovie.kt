package pr.thomassong.model

import com.google.gson.annotations.SerializedName
import java.util.*


/**
 *  author thomassong
 */
const val TMDB_ORIGINAL_IMG_ROOT = "https://image.tmdb.org/t/p/original"
const val TMDB_W500_IMG_ROOT = "https://image.tmdb.org/t/p/w500"

data class TheMovie (
    @SerializedName("vote_count") val voteCnt: Int,
    @SerializedName("id") val id: Long,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("title") val title: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("genre_ids") val genreIds: List<Long>,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: Date
)

fun String.toW500Url(): String{
    return TMDB_W500_IMG_ROOT + this
}

fun String.toOriginalUrl(): String {
    return TMDB_ORIGINAL_IMG_ROOT + this
}