package pr.thomassong.movie

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pr.thomassong.movie.di.DaggerAppComponent
import timber.log.Timber


/**
 *  author thomassong
 */
class MovieApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}