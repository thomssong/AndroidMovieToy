package pr.thomassong.shared.data

import androidx.paging.PageKeyedDataSource
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import pr.thomassong.model.TheMovie
import pr.thomassong.model.TheMovieResponse
import timber.log.Timber


/**
 *  author thomassong
 */
class TrendingMovieDataSource(
    private val movieService: TheMovieService
): PageKeyedDataSource<Int, TheMovie>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, TheMovie>
    ) {
        movieService.getTrendingMovie()
            .subscribe(object : SingleObserver<TheMovieResponse> {
                override fun onSubscribe(d: Disposable) {}

                override fun onSuccess(it: TheMovieResponse) {
                    callback.onResult(it.results, null, it.page + 1)
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                }
            })
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, TheMovie>
    ) {
        movieService.getTrendingMovie(params.key)
            .subscribe(object : SingleObserver<TheMovieResponse> {
                override fun onSubscribe(d: Disposable) {}

                override fun onSuccess(it: TheMovieResponse) {
                    val nextKey = if(params.key == it.totalPages) null else params.key + 1
                    callback.onResult(it.results, nextKey)
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                }
            })
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, TheMovie>
    ) {}
}