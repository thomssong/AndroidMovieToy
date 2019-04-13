package pr.thomassong.movie.widget.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pr.thomassong.movie.R


/**
 *  author thomassong
 */
class DetailsItemDecoration: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = parent.context.resources.getDimensionPixelSize(R.dimen.spacing_movie_details_item)
    }

}