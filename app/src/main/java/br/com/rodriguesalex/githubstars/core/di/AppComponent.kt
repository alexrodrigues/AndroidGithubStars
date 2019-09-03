package br.com.rodriguesalex.githubstars.core.di

import android.app.Application
import br.com.rodriguesalex.githubstars.GithubApp
import br.com.rodriguesalex.githubstars.core.di.modules.ActivityModule
import br.com.rodriguesalex.githubstars.core.di.modules.AppModule
import br.com.rodriguesalex.githubstars.core.di.modules.NetworkModule
import br.com.rodriguesalex.githubstars.core.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class),
    (ActivityModule::class),
    (ViewModelModule::class),
    (AppModule::class),
    (NetworkModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        @BindsInstance
        fun build(): AppComponent
    }

    fun inject(instance: GithubApp)
}