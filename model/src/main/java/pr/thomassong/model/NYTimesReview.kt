package pr.thomassong.model

import com.google.gson.annotations.SerializedName
import java.util.*


/**
 *  author thomassong
 */
data class NYTimesReview (
    @SerializedName("display_title") val title: String,
    @SerializedName("mpaa_rating") val rating: String,
    @SerializedName("critics_pick") val criticsPick: Int,
    @SerializedName("byline") val byline: String,
    @SerializedName("headline") val headline: String,
    @SerializedName("summary_short") val summaryShort: String,
    @SerializedName("publication_date") val publicationDate: Date,
    @SerializedName("opening_date") val openingDate: Date?,
    @SerializedName("date_updated") val updatedDate: Date,
    @SerializedName("link") val link: Link,
    @SerializedName("multimedia") val multimedia: Multimedia
)

data class Link (
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
    @SerializedName("suggested_link_text") val suggestedLinkText: String
)

data class Multimedia (
    @SerializedName("type") val type: String,
    @SerializedName("src") val src: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int
)
