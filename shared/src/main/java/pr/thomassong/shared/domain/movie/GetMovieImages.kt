package pr.thomassong.shared.domain.movie

import io.reactivex.Single
import pr.thomassong.model.TheMovieImageResponse
import pr.thomassong.shared.data.remote.TheMovieService
import pr.thomassong.shared.domain.SingleUseCase
import pr.thomassong.shared.executor.ThreadExecutor
import javax.inject.Inject


/**
 *  author thomassong
 */
open class GetMovieImages @Inject constructor(
    threadExecutor: ThreadExecutor,
    private val movieService: TheMovieService
): SingleUseCase<TheMovieImageResponse, Long>(threadExecutor) {

    override fun buildUseCaseObservable(params: Long?): Single<TheMovieImageResponse> {
        return if(params != null) {
            movieService.getMovieImages(params)
        } else {
            throw NullPointerException()
        }
    }

}