package pr.thomassong.movie.data.mapper

import pr.thomassong.model.TheMovie
import pr.thomassong.movie.data.TheMovieParcel
import javax.inject.Inject


/**
 *  author thomassong
 */
open class TheMovieMapper @Inject constructor(): Mapper<TheMovieParcel, TheMovie> {
    override fun mapFromParcel(parcel: TheMovieParcel): TheMovie = TheMovie(
        parcel.voteCnt,
        parcel.id,
        parcel.video,
        parcel.voteAverage,
        parcel.title,
        0F,
        parcel.posterPath,
        parcel.originalLanguage,
        parcel.originalTitle,
        emptyList(),
        parcel.backdropPath,
        parcel.adult,
        parcel.overview,
        parcel.releaseDate
    )

    override fun mapToParcel(model: TheMovie): TheMovieParcel = TheMovieParcel(
        model.voteCnt,
        model.id,
        model.video,
        model.voteAverage,
        model.title,
        model.posterPath,
        model.originalLanguage,
        model.originalTitle,
        model.backdropPath,
        model.adult,
        model.overview,
        model.releaseDate
    )
}