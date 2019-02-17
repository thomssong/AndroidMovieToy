package pr.thomassong.movie.util

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import pr.thomassong.movie.R


/**
 *  author thomassong
 */
@GlideModule
class MovieGlideModule: AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.color.colorPlaceHolder)
                .error(R.color.colorError)
        )
    }
}