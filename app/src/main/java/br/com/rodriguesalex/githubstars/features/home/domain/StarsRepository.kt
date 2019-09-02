package br.com.rodriguesalex.githubstars.features.home.domain

import br.com.rodriguesalex.githubstars.features.home.domain.service.StarsService
import javax.inject.Inject

interface StarsRepository {
}

class StarsRepositoryImpl @Inject constructor(private val service: StarsService) : StarsRepository {

}