package pr.thomassong.movie.ui.detail

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import pr.thomassong.model.*
import pr.thomassong.movie.R
import pr.thomassong.movie.databinding.ItemMovieDetailCreditBinding
import pr.thomassong.movie.databinding.ItemMovieDetailHeaderBinding
import pr.thomassong.movie.widget.recyclerview.BaseAdapter
import pr.thomassong.movie.widget.recyclerview.BaseViewHolder


/**
 *  author thomassong
 */
class MovieDetailsListAdapter(
    lifecycleOwner: LifecycleOwner,
    private val viewModel: MovieDetailViewModel
): BaseAdapter<TheMovieDetails>(lifecycleOwner, MovieDetailsDiffCallback) {

    override fun getItemViewType(position: Int): Int = when(getItem(position).posId) {
        POS_ID_HEADER -> R.layout.item_movie_detail_header
        POS_ID_CREDIT -> R.layout.item_movie_detail_credit
        else -> throw IllegalArgumentException()
    }

    override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder<TheMovieDetails, ViewDataBinding> {
        return when(binding) {
            is ItemMovieDetailHeaderBinding -> MovieDetailHeaderViewHolder(binding)
            is ItemMovieDetailCreditBinding -> MovieDetailCreditViewHolder(binding)
            else -> throw IllegalArgumentException()
        }
    }
}

class MovieDetailHeaderViewHolder(
    binding: ItemMovieDetailHeaderBinding
): BaseViewHolder<TheMovieDetails, ItemMovieDetailHeaderBinding>(binding) {
    override fun bind(item: TheMovieDetails) {
        binding.apply {
            data = item as? TheMovieDetailHeader
            executePendingBindings()
        }
    }
}

class MovieDetailCreditViewHolder(
    binding: ItemMovieDetailCreditBinding
): BaseViewHolder<TheMovieDetails, ItemMovieDetailCreditBinding>(binding) {
    override fun bind(item: TheMovieDetails) {
        binding.apply {
            data = item as? TheMovieCredits
            executePendingBindings()
        }
    }

}

object MovieDetailsDiffCallback: DiffUtil.ItemCallback<TheMovieDetails>() {
    override fun areItemsTheSame(oldItem: TheMovieDetails, newItem: TheMovieDetails): Boolean {
        return oldItem.posId == newItem.posId
    }

    override fun areContentsTheSame(oldItem: TheMovieDetails, newItem: TheMovieDetails): Boolean {
        return oldItem.equals(newItem)
    }

}