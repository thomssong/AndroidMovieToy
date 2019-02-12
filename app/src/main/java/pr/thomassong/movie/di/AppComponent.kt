package pr.thomassong.movie.di

import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pr.thomassong.movie.MovieApplication
import pr.thomassong.shared.di.DataModule
import javax.inject.Singleton


/**
 *  author thomassong
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        ViewModelModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent: AndroidInjector<MovieApplication> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MovieApplication>()
}