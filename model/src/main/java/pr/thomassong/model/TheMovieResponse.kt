package pr.thomassong.model

import com.google.gson.annotations.SerializedName


/**
 *  author thomassong
 */
data class TheMovieResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<TheMovie>
)