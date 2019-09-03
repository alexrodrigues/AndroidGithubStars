package br.com.rodriguesalex.githubstars.features.home.domain

import br.com.rodriguesalex.githubstars.features.home.domain.model.GithubResponse
import br.com.rodriguesalex.githubstars.features.home.domain.service.StarsService
import io.reactivex.Observable
import javax.inject.Inject

interface StarsRepository {
    fun fetch(): Observable<GithubResponse>
}

class StarsRepositoryImpl @Inject constructor(private val service: StarsService) : StarsRepository {

    override fun fetch(): Observable<GithubResponse> {
        return service.fetch()
    }

}