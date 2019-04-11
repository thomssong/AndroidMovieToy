package pr.thomassong.movie.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import pr.thomassong.model.TheMovie
import pr.thomassong.movie.data.TheMovieParcel
import pr.thomassong.movie.data.mapper.TheMovieMapper
import pr.thomassong.shared.domain.movie.GetTrendingMovieList
import pr.thomassong.shared.executor.AppExecutors
import pr.thomassong.shared.result.Event
import javax.inject.Inject


/**
 *  author thomassong
 */
class MovieListViewModel @Inject constructor(
    appExecutors: AppExecutors,
    getTrendingMovieList: GetTrendingMovieList,
    private val theMovieMapper: TheMovieMapper
): ViewModel(), EventAction {

    private val _trendingMovieList: LiveData<PagedList<TheMovie>>
    val trendingMovieList: LiveData<PagedList<TheMovie>>
        get() = _trendingMovieList

    private val _navigateToMovieDetail = MutableLiveData<Event<TheMovieParcel>>()
    val navigateToMovieDetail: LiveData<Event<TheMovieParcel>>
        get() = _navigateToMovieDetail

    init {
        val pageConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .build()

        _trendingMovieList = LivePagedListBuilder<Int, TheMovie>(getTrendingMovieList, pageConfig)
            .setFetchExecutor(appExecutors.mainThread())
            .build()
    }

    override fun onMovieClicked(movie: TheMovie?) {
        movie?.let {
            _navigateToMovieDetail.postValue(Event(theMovieMapper.mapToParcel(it)))
        }
    }
}

interface EventAction {
    fun onMovieClicked(movie: TheMovie?)
}