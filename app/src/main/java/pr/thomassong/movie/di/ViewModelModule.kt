package pr.thomassong.movie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pr.thomassong.movie.ViewModelFactory
import pr.thomassong.movie.ui.list.MovieListViewModel
import pr.thomassong.shared.di.ViewModelKey


/**
 *  author thomassong
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindMovieListViewModel(viewModel: MovieListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}