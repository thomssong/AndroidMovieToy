package pr.thomassong.movie.widget.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/**
 *  author thomassong
 */
abstract class BaseViewHolder<T: Any, out B: ViewDataBinding>
constructor(val binding: B): RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}