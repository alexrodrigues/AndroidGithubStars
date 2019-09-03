package br.com.rodriguesalex.githubstars.core.di.modules

import br.com.rodriguesalex.githubstars.core.api.ApiGithub
import br.com.rodriguesalex.githubstars.features.home.domain.StarsRepository
import br.com.rodriguesalex.githubstars.features.home.domain.StarsRepositoryImpl
import br.com.rodriguesalex.githubstars.features.home.domain.service.StarsService
import br.com.rodriguesalex.githubstars.features.home.domain.service.StarsServiceImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(10000, TimeUnit.SECONDS)
            .writeTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(30000, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/search/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideGithubApi(retrofit: Retrofit): ApiGithub {
        return retrofit.create(ApiGithub::class.java)
    }

    @Provides
    @Singleton
    fun provideApiService(apiGithub: ApiGithub): StarsService {
        return StarsServiceImpl(apiGithub)
    }

    @Provides
    @Singleton
    fun provideStarsRepository(service: StarsService): StarsRepository {
        return StarsRepositoryImpl(service)
    }

}