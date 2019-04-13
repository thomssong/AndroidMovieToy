package pr.thomassong.shared.domain.movie

import io.reactivex.Single
import pr.thomassong.model.TheMovie
import pr.thomassong.shared.data.remote.TheMovieService
import pr.thomassong.shared.domain.SingleUseCase
import pr.thomassong.shared.executor.ThreadExecutor
import javax.inject.Inject


/**
 *  author thomassong
 */
open class GetMovieDetail @Inject constructor(
    threadExecutor: ThreadExecutor,
    private val movieService: TheMovieService
): SingleUseCase<TheMovie, Long>(threadExecutor) {

    override fun buildUseCaseObservable(params: Long?): Single<TheMovie> {
        return if(params != null) {
            movieService.getMovieDetail(params)
        } else {
            throw NullPointerException()
        }
    }

}