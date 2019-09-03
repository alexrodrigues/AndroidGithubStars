package br.com.rodriguesalex.githubstars.features.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.rodriguesalex.githubstars.features.home.domain.StarsRepository
import br.com.rodriguesalex.githubstars.features.home.domain.model.Repo
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class StarsViewModel @Inject constructor(
    private val repository: StarsRepository,
    @Named("IOScheduler") private val ioScheduler: Scheduler,
    @Named("MainScheduler") private val mainScheduler: Scheduler) : ViewModel() {

    val repoList = MutableLiveData<List<Repo>>()
    private val disposableList = CompositeDisposable()

    init {
        fetch()
    }

    private fun fetch() {
        disposableList.add(
            repository.fetch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    repoList.value = it.items
                }, {
                    it.printStackTrace()
                })
        )
    }

}