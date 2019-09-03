package br.com.rodriguesalex.githubstars

import dagger.android.DaggerApplication
import br.com.rodriguesalex.githubstars.core.di.DaggerAppComponent

class GithubApp: DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector

}