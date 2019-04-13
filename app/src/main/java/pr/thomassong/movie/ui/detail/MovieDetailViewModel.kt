package pr.thomassong.movie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import pr.thomassong.model.TheMovie
import pr.thomassong.model.TheMovieCredits
import pr.thomassong.model.TheMovieDetailHeader
import pr.thomassong.model.TheMovieDetails
import pr.thomassong.movie.data.TheMovieParcel
import pr.thomassong.movie.data.mapper.TheMovieMapper
import pr.thomassong.shared.domain.movie.GetMovieCredits
import pr.thomassong.shared.domain.movie.GetMovieDetail
import pr.thomassong.shared.domain.movie.GetMovieImages
import timber.log.Timber
import javax.inject.Inject


/**
 *  author thomassong
 */
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetail: GetMovieDetail,
    private val getMovieCredits: GetMovieCredits,
    private val getMovieImages: GetMovieImages,
    private val theMovieMapper: TheMovieMapper
): ViewModel() {

    val movie = MutableLiveData<TheMovie>()

    private val _movieDetailItems = MutableLiveData<ArrayList<TheMovieDetails>>()
    val movieDetailItems: LiveData<ArrayList<TheMovieDetails>>
        get() = _movieDetailItems

    init {
        _movieDetailItems.postValue(ArrayList())
    }

    fun setupMovie(parcel: TheMovieParcel) {
        movie.postValue(theMovieMapper.mapFromParcel(parcel))

        Observable.concat(
            getMovieDetail.execute(parcel.id).toObservable(),
            getMovieCredits.execute(parcel.id).toObservable()
        ).subscribe(object : Observer<Any> {
            override fun onSubscribe(d: Disposable) {
                Timber.d("onSubscribe = $d")
            }

            override fun onNext(t: Any) {
                when(t) {
                    is TheMovie -> {
                        movie.postValue(t)
                        addDetailsItem(TheMovieDetailHeader(overview = t.overview, genres = t.genres))
                    }
                    is TheMovieCredits -> addDetailsItem(t)
                    else -> Timber.e("Something unexpected")
                }
            }

            override fun onError(e: Throwable) {
                Timber.e(e)
            }

            override fun onComplete() {
                Timber.d("onComplete")
            }
        })
    }

    private fun addDetailsItem(item: TheMovieDetails) {
        val list = _movieDetailItems.value
        list?.add(item)
        _movieDetailItems.postValue(list)
    }
}