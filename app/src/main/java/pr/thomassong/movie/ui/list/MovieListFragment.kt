package pr.thomassong.movie.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import dagger.android.support.DaggerFragment
import pr.thomassong.movie.databinding.FragmentMovieListBinding
import javax.inject.Inject


/**
 *  author thomassong
 */
class MovieListFragment: DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MovieListViewModel::class.java)

        val binding = FragmentMovieListBinding.inflate(inflater).apply {
            setLifecycleOwner(this@MovieListFragment)
        }

        val movieListAdapter = MovieListAdapter(this, viewModel)
        binding.recyclerView.run {
            adapter = movieListAdapter
        }

        viewModel.trendingMovieList.observe(this, Observer {
            movieListAdapter.submitList(it)
        })

        viewModel.navigateToMovieDetail.observe(this, Observer {
            it?.let {
                val direction = MovieListFragmentDirections.actionToMovieDetail(it)
                Navigation.findNavController(binding.root)
                    .navigate(direction)
            }
        })

        binding.vm = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}