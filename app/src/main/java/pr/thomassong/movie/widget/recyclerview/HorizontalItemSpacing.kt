package pr.thomassong.movie.widget.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pr.thomassong.movie.R


/**
 *  author thomassong
 */
class HorizontalItemSpacing: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if(position == (parent.adapter?.itemCount?:0) -1) {
            return
        }

        outRect.right = parent.context.resources.getDimensionPixelSize(R.dimen.spacing_recyclerview_horizontal_item)
    }
}