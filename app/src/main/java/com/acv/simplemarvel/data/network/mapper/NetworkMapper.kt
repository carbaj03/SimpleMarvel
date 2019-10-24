package com.acv.simplemarvel.data.network.mapper

import com.acv.simplemarvel.domain.common.DomainError
import com.acv.simplemarvel.domain.common.NotInternetDomainError
import com.acv.simplemarvel.domain.common.UnknownDomainError
import java.net.ConnectException

interface NetworkMapper {

    fun Exception.mapException(): DomainError =
        when {
            cause is ConnectException -> NotInternetDomainError
            else -> UnknownDomainError()
        }
}