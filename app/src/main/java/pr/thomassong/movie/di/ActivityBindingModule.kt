package pr.thomassong.movie.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import pr.thomassong.movie.ui.MainActivity
import pr.thomassong.movie.ui.list.MovieListModule
import pr.thomassong.shared.di.ActivityScope


/**
 *  author thomassong
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MovieListModule::class
    ])
    internal abstract fun mainActivity(): MainActivity

}