package pr.thomassong.shared.di

import dagger.Binds
import dagger.Module
import pr.thomassong.shared.executor.JobExecutor
import pr.thomassong.shared.executor.ThreadExecutor


/**
 *  author thomassong
 */
@Module
abstract class DataModule {

    @Binds
    internal abstract fun provideThreadExecutor(executor: JobExecutor): ThreadExecutor

}