package com.acv.simplemarvel.domain.common

import arrow.core.Either

typealias Return<A> = Either<DomainError, A>