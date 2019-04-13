package pr.thomassong.shared.domain.movie

import io.reactivex.Single
import pr.thomassong.model.TheMovieVideoResponse
import pr.thomassong.shared.data.remote.TheMovieService
import pr.thomassong.shared.domain.SingleUseCase
import pr.thomassong.shared.executor.ThreadExecutor
import javax.inject.Inject


/**
 *  author thomassong
 */
open class GetMovieVideos @Inject constructor(
    threadExecutor: ThreadExecutor,
    private val movieService: TheMovieService
): SingleUseCase<TheMovieVideoResponse, Long>(threadExecutor) {

    override fun buildUseCaseObservable(params: Long?): Single<TheMovieVideoResponse> {
        return if(params != null) {
            movieService.getMovieVideos(params)
        } else {
            throw NullPointerException()
        }
    }

}