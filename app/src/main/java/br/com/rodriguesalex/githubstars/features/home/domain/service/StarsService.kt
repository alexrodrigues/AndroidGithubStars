package br.com.rodriguesalex.githubstars.features.home.domain.service

import br.com.rodriguesalex.githubstars.core.api.ApiGithub
import br.com.rodriguesalex.githubstars.features.home.domain.model.GithubResponse
import io.reactivex.Observable
import javax.inject.Inject

interface StarsService {
    fun fetch(): Observable<GithubResponse>
}

class StarsServiceImpl @Inject constructor(private val api: ApiGithub): StarsService {

    override fun fetch(): Observable<GithubResponse> {
        return api.fetch()
    }

}
