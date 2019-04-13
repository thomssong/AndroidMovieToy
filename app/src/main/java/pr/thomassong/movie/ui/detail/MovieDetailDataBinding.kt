package pr.thomassong.movie.ui.detail

import android.graphics.Color
import android.util.TypedValue
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import pr.thomassong.model.TheMovieCast
import pr.thomassong.model.TheMovieCrew
import pr.thomassong.model.TheMovieGenre
import pr.thomassong.movie.R
import pr.thomassong.movie.databinding.ViewMovieCastRowBinding
import pr.thomassong.movie.databinding.ViewMovieCrewRowBinding


/**
 *  author thomassong
 */
object MovieDetailDataBinding {

    private val CAST_ROW_VIEW_IDS = arrayOf(R.id.row_movie_cast1, R.id.row_movie_cast2, R.id.row_movie_cast3)

    @JvmStatic
    @BindingAdapter("findDirector")
    fun findDirector(view: View, crews: List<TheMovieCrew>?) {
        crews?.find { it.job == "Director" }?.let {
                DataBindingUtil.findBinding<ViewMovieCrewRowBinding>(view.findViewById(R.id.row_movie_director))?.let { binding ->
                    binding.crew = it
                }
        }
    }

    @JvmStatic
    @BindingAdapter("cast")
    fun bindCast(view: View, cast: TheMovieCast) {
        DataBindingUtil.findBinding<ViewMovieCastRowBinding>(view)?.let {
            it.root.visibility = View.VISIBLE
            it.cast = cast
        }
    }

    @JvmStatic
    @BindingAdapter("genreItems")
    fun bindGenreItems(view: ChipGroup, genreList: List<TheMovieGenre>?) {
        genreList?.forEach {
            view.addView(
                Chip(view.context).apply {
                    setChipBackgroundColorResource(R.color.button_material_dark)
                    setTextColor(Color.WHITE)
                    setTextSize(TypedValue.COMPLEX_UNIT_SP,14f)
                    text = it.name
                }
            )

        }
    }
}