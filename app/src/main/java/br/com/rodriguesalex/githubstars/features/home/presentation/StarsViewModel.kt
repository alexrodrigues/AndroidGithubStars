package br.com.rodriguesalex.githubstars.features.home.presentation

import androidx.lifecycle.ViewModel
import br.com.rodriguesalex.githubstars.features.home.domain.StarsRepository
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class StarsViewModel @Inject constructor(
    private val repository: StarsRepository,
    @Named("IOScheduler") private val ioScheduler: Scheduler,
    @Named("MainScheduler") private val mainScheduler: Scheduler) : ViewModel() {

}