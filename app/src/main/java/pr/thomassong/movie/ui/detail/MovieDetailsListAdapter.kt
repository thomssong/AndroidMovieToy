package pr.thomassong.movie.ui.detail

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import pr.thomassong.model.*
import pr.thomassong.movie.R
import pr.thomassong.movie.databinding.ItemMovieDetailCreditBinding
import pr.thomassong.movie.databinding.ItemMovieDetailHeaderBinding
import pr.thomassong.movie.databinding.ItemMovieDetailImagesBinding
import pr.thomassong.movie.databinding.ItemMovieImageBinding
import pr.thomassong.movie.widget.recyclerview.BaseAdapter
import pr.thomassong.movie.widget.recyclerview.BaseViewHolder
import pr.thomassong.movie.widget.recyclerview.HorizontalItemSpacing


/**
 *  author thomassong
 */
class MovieDetailsListAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: MovieDetailViewModel
): BaseAdapter<TheMovieDetails>(lifecycleOwner, MovieDetailsDiffCallback) {

    override fun getItemViewType(position: Int): Int = when(getItem(position).posId) {
        POS_ID_HEADER -> R.layout.item_movie_detail_header
        POS_ID_CREDIT -> R.layout.item_movie_detail_credit
        POS_ID_IMAGE -> R.layout.item_movie_detail_images
        else -> throw IllegalArgumentException()
    }

    override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder<TheMovieDetails, ViewDataBinding> {
        return when(binding) {
            is ItemMovieDetailHeaderBinding -> MovieDetailHeaderViewHolder(binding)
            is ItemMovieDetailCreditBinding -> MovieDetailCreditViewHolder(binding)
            is ItemMovieDetailImagesBinding -> MovieDetailImagesViewHolder(lifecycleOwner, binding)
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

class MovieDetailImagesViewHolder(
    private val lifecycleOwner: LifecycleOwner,
    binding: ItemMovieDetailImagesBinding
): BaseViewHolder<TheMovieDetails, ItemMovieDetailImagesBinding>(binding) {
    override fun bind(item: TheMovieDetails) {
        binding.apply {
            val imageListAdapter = MovieImageListAdapter(this@MovieDetailImagesViewHolder.lifecycleOwner)
            recyclerView.run {
                adapter = imageListAdapter
                addItemDecoration(HorizontalItemSpacing())
            }
            (item as? TheMovieImageResponse)?.let {
                imageListAdapter.submitList(it.backdrops)
            }
            executePendingBindings()
        }
    }

    private class MovieImageListAdapter(
        lifecycleOwner: LifecycleOwner
    ): BaseAdapter<TheMovieImage>(lifecycleOwner, MovieImageDiffCallback) {

        override fun getItemViewType(position: Int): Int = R.layout.item_movie_image

        override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder<TheMovieImage, ViewDataBinding> {
            if(binding is ItemMovieImageBinding) {
                return MovieImageViewHolder(binding)
            } else {
                throw IllegalArgumentException()
            }
        }

    }

    object MovieImageDiffCallback: DiffUtil.ItemCallback<TheMovieImage>() {
        override fun areItemsTheSame(oldItem: TheMovieImage, newItem: TheMovieImage): Boolean {
            return oldItem.filePath == newItem.filePath
        }

        override fun areContentsTheSame(oldItem: TheMovieImage, newItem: TheMovieImage): Boolean {
            return oldItem == newItem
        }

    }
}

class MovieImageViewHolder(
    binding: ItemMovieImageBinding
): BaseViewHolder<TheMovieImage, ItemMovieImageBinding>(binding) {
    override fun bind(item: TheMovieImage) {
        binding.apply {
            data = item
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