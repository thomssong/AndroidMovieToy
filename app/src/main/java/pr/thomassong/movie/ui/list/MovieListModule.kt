package pr.thomassong.movie.ui.list

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pr.thomassong.shared.di.FragmentScope


/**
 *  author thomassong
 */
@Module
internal abstract class MovieListModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun movieListFragment(): MovieListFragment

}