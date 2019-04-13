package pr.thomassong.shared.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor


/**
 *  author thomassong
 */
abstract class SingleUseCase<T, in Params> constructor(
    private val threadExecutor: Executor
) {
    private val disposable = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    open fun execute(params: Params? = null): Single<T> {
        return this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(AndroidSchedulers.mainThread())
    }
}
