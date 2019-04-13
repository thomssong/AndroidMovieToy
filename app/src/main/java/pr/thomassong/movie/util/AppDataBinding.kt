package pr.thomassong.movie.util

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.transition.Transition
import pr.thomassong.model.toW500Url
import pr.thomassong.movie.R
import java.text.SimpleDateFormat
import java.util.*


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

    @JvmStatic
    @BindingAdapter("posterUrl")
    fun bindPosterUrl(view: ImageView, posterPath: String?) {
        GlideApp.with(view)
            .load(posterPath?.toW500Url()?: "")
            .centerCrop()
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("backgroundUrl")
    fun bindBackgroundUrl(view: ImageView, backdropPath: String?) {
        GlideApp.with(view)
            .load(backdropPath?.toW500Url()?: "")
            .centerCrop()
            .into(object : DrawableImageViewTarget(view) {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    super.onResourceReady(resource, transition)
                    view.setColorFilter(ContextCompat.getColor(view.context, R.color.colorBackgroundTranslucent), PorterDuff.Mode.SRC_ATOP)
                }
            })
    }

    @JvmStatic
    @BindingAdapter("thumbUrl")
    fun bindThumbUrl(view: ImageView, thumbUrl: String?) {
        GlideApp.with(view)
            .load(thumbUrl?.toW500Url()?: "")
            .placeholder(R.drawable.drawable_profile_thumb_placeholder)
            .error(R.drawable.drawable_profile_thumb_error)
            .circleCrop()
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("releaseDate")
    fun bindReleaseDAte(view: TextView, releaseDate: Date?) {
        view.text = releaseDate?.let {
            SimpleDateFormat("yyyy.M.dd", Locale.US).format(it)
        } ?: view.context.getString(R.string.tbd)
    }
}