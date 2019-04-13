package pr.thomassong.movie.ui.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pr.thomassong.shared.di.FragmentScope


/**
 *  author thomassong
 */
@Module
internal abstract class MovieDetailModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun movieDetailFragment(): MovieDetailFragment

}