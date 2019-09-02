package br.com.rodriguesalex.githubstars.core.di.modules

import br.com.rodriguesalex.githubstars.core.di.scope.ActivityScope
import br.com.rodriguesalex.githubstars.features.home.di.StarsModule
import br.com.rodriguesalex.githubstars.features.home.presentation.StarsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [StarsModule::class])
    internal abstract fun starsActivity(): StarsActivity
}