package pr.thomassong.movie.ui.detail

import android.graphics.Color
import android.util.TypedValue
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import pr.thomassong.model.TheMovieCrew
import pr.thomassong.model.TheMovieGenre
import pr.thomassong.model.TheMovieImage
import pr.thomassong.model.toW500Url
import pr.thomassong.movie.R
import pr.thomassong.movie.databinding.ViewMovieCrewRowBinding
import pr.thomassong.movie.util.GlideApp


/**
 *  author thomassong
 */
object MovieDetailDataBinding {

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

    @JvmStatic
    @BindingAdapter("detailImage")
    fun bindDetailImageUrl(view: ConstraintLayout, image: TheMovieImage?) {
        image?.let {
            ConstraintSet().run {
                clone(view)
                setDimensionRatio(R.id.image, String.format("%.2f", it.ratio))
                applyTo(view)
            }

            val imageView = view.findViewById<AppCompatImageView>(R.id.image)
            GlideApp.with(imageView)
                .load(it.filePath.toW500Url())
                .centerCrop()
                .into(imageView)
        }
    }
}