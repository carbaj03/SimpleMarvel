package com.acv.simplemarvel.app.di

import com.acv.simplemarvel.BuildConfig
import com.acv.simplemarvel.app.common.RealTimeProvider
import com.acv.simplemarvel.app.common.TimeProvider
import com.acv.simplemarvel.data.local.MemoryMarvelDataSource
import com.acv.simplemarvel.data.network.NetworkMarvelDataSource
import com.acv.simplemarvel.data.network.client.MarvelClient
import com.acv.simplemarvel.data.repository.MarvelDataSource
import com.acv.simplemarvel.data.repository.MarvelRepository
import com.acv.simplemarvel.domain.usecase.GetHeroByName
import com.acv.simplemarvel.domain.usecase.GetHeroes
import com.acv.simplemarvel.presenter.heroes.HeroesPresenter
import com.acv.simplemarvel.presenter.heroes.HeroesView
import com.acv.simplemarvel.presenter.heroes.detail.HeroeDetailPresenter
import com.acv.simplemarvel.presenter.heroes.detail.HeroeDetailView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

interface Injection {

    fun provideDetailPresenter(view: HeroeDetailView): HeroeDetailPresenter =
        HeroeDetailPresenter(view, GetHeroByName(MarvelRepository(listOf(NetworkMarvelDataSource(client())))), provideCoroutineContext())

    fun providePresenter(view: HeroesView): HeroesPresenter =
        HeroesPresenter(view, GetHeroes(MarvelRepository(listOf(NetworkMarvelDataSource(client())))), provideCoroutineContext())

    fun create() =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.API_URL_MARVEL)
            .client(OkHttpClient.Builder().apply { addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }) }.build())
            .build()

    fun client(): MarvelClient =
        create().create<MarvelClient>(MarvelClient::class.java)

    fun provideTimeProvider(): TimeProvider =
        RealTimeProvider()

    fun provideRandomUserRepository(
        network: MarvelDataSource = provideNetwork(client()),
        localStorage: MarvelDataSource = provideLocal(provideTimeProvider())
    ): MarvelRepository =
        MarvelRepository(listOf(localStorage, network))


    fun provideLocal(timeProvider: TimeProvider): MarvelDataSource =
        MemoryMarvelDataSource(timeProvider)

    fun provideNetwork(apiClient: MarvelClient): MarvelDataSource =
        NetworkMarvelDataSource(apiClient)

    fun provideCoroutineContext(job: Job = Job()): CoroutineContext = job + Dispatchers.Main
}