package br.com.rodriguesalex.githubstars.core.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (private val application: Application) {
    @Provides
    @Singleton
    fun providesApplication(): Application = application
}