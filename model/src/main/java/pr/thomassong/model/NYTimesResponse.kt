package pr.thomassong.model

import com.google.gson.annotations.SerializedName


/**
 *  author thomassong
 */
data class NYTimesResponse (
    @SerializedName("status") val status: Status,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("has_more") val hasMore: Boolean,
    @SerializedName("num_results") val totalResults: Int,
    @SerializedName("results") val results: List<NYTimesReview>
)

enum class Status {
    OK
}