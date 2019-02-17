package pr.thomassong.movie.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import pr.thomassong.model.toW500Url


/**
 *  author thomassong
 */
object AppDataBinding {
    @JvmStatic
    @BindingAdapter("backdropUrl")
    fun bindBackdropUrl(view: ImageView, backdropPath: String?) {
        GlideApp.with(view)
            .load(backdropPath?.toW500Url()?: "")
            .centerCrop()
            .into(view)
    }
}