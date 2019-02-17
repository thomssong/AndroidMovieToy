package pr.thomassong.movie.data.mapper

import android.os.Parcelable


/**
 *  author thomassong
 */
interface Mapper<out P: Parcelable, in M> {
    fun mapToParcel(model: M): P
}