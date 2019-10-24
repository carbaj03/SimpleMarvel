package com.acv.simplemarvel.data.local

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import arrow.core.toOption
import com.acv.simplemarvel.domain.common.DomainError
import com.acv.simplemarvel.app.common.TimeProvider
import com.acv.simplemarvel.data.repository.MarvelDataSource
import com.acv.simplemarvel.domain.common.NotIndexFoundDomainError
import com.acv.simplemarvel.domain.common.Return
import com.acv.simplemarvel.domain.entities.Hero
import java.util.concurrent.TimeUnit

class MemoryMarvelDataSource(
    private val timeProvider: TimeProvider
) : MarvelDataSource {

    companion object {
        private val TIME_UPDATE: Long =
            TimeUnit.SECONDS.toMillis(1)
    }

    private val cache = LinkedHashMap<String, Hero>()
    private var lastUpdate = 0L

    override fun isUpdated(): Boolean =
        timeProvider.time - lastUpdate < TIME_UPDATE

    override fun contains(key: String): Boolean =
        cache.contains(key)

    override suspend fun getAll(): Either<DomainError, List<Hero>> =
        cache.values.toList().right()

    override fun populate(superHeroes: List<Hero>) {
        lastUpdate = timeProvider.time
        cache.putAll(superHeroes.map { it.name to it })
    }

    override suspend fun get(name: String): Return<Hero> =
        cache[name].toOption().toEither { NotIndexFoundDomainError(name) }
}