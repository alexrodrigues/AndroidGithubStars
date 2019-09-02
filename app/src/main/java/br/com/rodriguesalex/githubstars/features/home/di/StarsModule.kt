package br.com.rodriguesalex.githubstars.features.home.di

import androidx.lifecycle.ViewModel
import br.com.rodriguesalex.githubstars.core.di.modules.ViewModelKey
import br.com.rodriguesalex.githubstars.core.di.scope.ActivityScope
import br.com.rodriguesalex.githubstars.features.home.domain.StarsRepository
import br.com.rodriguesalex.githubstars.features.home.domain.StarsRepositoryImpl
import br.com.rodriguesalex.githubstars.features.home.domain.service.StarsService
import br.com.rodriguesalex.githubstars.features.home.domain.service.StarsServiceImpl
import br.com.rodriguesalex.githubstars.features.home.presentation.StarsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StarsModule {
    @Binds
    abstract fun providesRepository(repository: StarsRepositoryImpl): StarsRepository

    @ActivityScope
    @Binds
    abstract fun providesService(service : StarsServiceImpl): StarsService

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(StarsViewModel::class)
    abstract fun bindStarsViewModel(starsViewModel: StarsViewModel): ViewModel
}