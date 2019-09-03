package br.com.rodriguesalex.githubstars.features.home.domain.model

import com.google.gson.annotations.SerializedName


data class GithubResponse(@SerializedName("items") val items: List<Repo>)

data class Repo(@SerializedName("name") val name: String,
                @SerializedName("stars") val stars: String,
                @SerializedName("owner") val owner: Owner)

data class Owner(@SerializedName("name") val name: String,
                 @SerializedName("profileImageUrl") val profileImageUrl: String)
