package pr.thomassong.movie.data.mapper

import android.os.Parcelable


/**
 *  author thomassong
 */
interface Mapper<P: Parcelable, M> {
    fun mapToParcel(model: M): P
    fun mapFromParcel(parcel: P): M
}