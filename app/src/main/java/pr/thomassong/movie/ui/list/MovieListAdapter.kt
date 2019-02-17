package pr.thomassong.movie.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import pr.thomassong.model.TheMovie
import pr.thomassong.movie.R
import pr.thomassong.movie.databinding.ItemMovieBinding


/**
 *  author thomassong
 */
class MovieListAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: MovieListViewModel
): PagedListAdapter<TheMovie, MovieViewHolder>(MovieDiffCallback){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.apply {
            setLifecycleOwner(this@MovieListAdapter.lifecycleOwner)
            listener = viewModel
            getItem(position)?.let { movie = it }
            executePendingBindings()
        }
    }
}

class MovieViewHolder(
    val binding: ItemMovieBinding
): RecyclerView.ViewHolder(binding.root)

object MovieDiffCallback: DiffUtil.ItemCallback<TheMovie>() {
    override fun areItemsTheSame(oldItem: TheMovie, newItem: TheMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TheMovie, newItem: TheMovie): Boolean {
        return oldItem.voteCnt == newItem.voteCnt
    }

}