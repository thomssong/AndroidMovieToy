package pr.thomassong.model


/**
 *  author thomassong
 */
data class TheMovieDetailHeader (
    val overview: String,
    val genres: List<TheMovieGenre>
): TheMovieDetails {
    override val posId: Int
        get() = POS_ID_HEADER
}