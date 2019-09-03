package br.com.rodriguesalex.githubstars.core.api

import br.com.rodriguesalex.githubstars.features.home.domain.model.GithubResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiGithub {

    @GET("repositories?q=language:swift&sort=stars")
    fun fetch(): Observable<GithubResponse>


}