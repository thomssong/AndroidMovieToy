package pr.thomassong.movie.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


/**
 *  author thomassong
 */
@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}