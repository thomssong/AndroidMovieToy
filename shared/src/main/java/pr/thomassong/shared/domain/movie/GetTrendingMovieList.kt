package pr.thomassong.shared.domain.movie

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import pr.thomassong.model.TheMovie
import pr.thomassong.shared.data.TheMovieService
import pr.thomassong.shared.data.TrendingMovieDataSource
import javax.inject.Inject


/**
 *  author thomassong
 */
open class GetTrendingMovieList @Inject constructor(
    private val movieService: TheMovieService
): DataSource.Factory<Int, TheMovie>() {

    private val dataSource = MutableLiveData<PageKeyedDataSource<Int, TheMovie>>()

    override fun create(): DataSource<Int, TheMovie> {
        val source = TrendingMovieDataSource(movieService)
        dataSource.postValue(source)
        return source
    }
}