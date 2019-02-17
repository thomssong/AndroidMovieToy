package pr.thomassong.movie.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*


/**
 *  author thomassong
 */
@Parcelize data class TheMovieParcel (
    val voteCnt: Int,
    val id: Long,
    val video: Boolean,
    val voteAverage: Float,
    val title: String,
    val posterPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val backdropPath: String?,
    val adult: Boolean,
    val overview: String,
    val releaseDate: Date?
): Parcelable