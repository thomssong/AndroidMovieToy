package pr.thomassong.shared.domain.movie

import io.reactivex.Single
import pr.thomassong.model.TheMovieCredits
import pr.thomassong.shared.data.remote.TheMovieService
import pr.thomassong.shared.domain.SingleUseCase
import pr.thomassong.shared.executor.ThreadExecutor
import javax.inject.Inject


/**
 *  author thomassong
 */
open class GetMovieCredits @Inject constructor(
    threadExecutor: ThreadExecutor,
    private val movieService: TheMovieService
): SingleUseCase<TheMovieCredits, Long>(threadExecutor) {

    override fun buildUseCaseObservable(params: Long?): Single<TheMovieCredits> {
        return if(params != null) {
            movieService.getMovieCredits(params)
        } else {
            throw NullPointerException()
        }
    }

}