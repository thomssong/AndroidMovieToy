package pr.thomassong.movie.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import pr.thomassong.movie.databinding.FragmentMovieDetailBinding
import pr.thomassong.movie.widget.recyclerview.DetailsItemDecoration
import javax.inject.Inject

class MovieDetailFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var viewModel: MovieDetailViewModel

    lateinit var binding: FragmentMovieDetailBinding

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MovieDetailViewModel::class.java)

        binding = FragmentMovieDetailBinding.inflate(inflater).apply {
            lifecycleOwner = this@MovieDetailFragment
        }

        binding.vm = viewModel

        val movieDetailsAdapter = MovieDetailsListAdapter(this, viewModel)
        binding.recyclerView.run {
            adapter = movieDetailsAdapter
            addItemDecoration(DetailsItemDecoration())
        }

        viewModel.movieDetailItems.observe(this, Observer {
            movieDetailsAdapter.submitList(ArrayList(it))
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setupMovie(args.movie)
    }

}
