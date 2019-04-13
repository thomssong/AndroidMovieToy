package pr.thomassong.model

import com.google.gson.annotations.SerializedName


/**
 *  author thomassong
 */
data class TheMovieCredits(
    @SerializedName("id") val id: Long,
    @SerializedName("cast") val cast: List<TheMovieCast>,
    @SerializedName("crew") val crew: List<TheMovieCrew>
): TheMovieDetails {
    override val posId: Int
        get() = POS_ID_CREDIT
}

data class TheMovieCast(
    @SerializedName("id") val id: Long,
    @SerializedName("cast_id") val castId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("character") val character: String,
    @SerializedName("credit_id") val creditId: String,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("order") val order: Int
)

data class TheMovieCrew(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("job") val job: String,
    @SerializedName("department") val department: String,
    @SerializedName("profile_path") val profilePath: String?
)