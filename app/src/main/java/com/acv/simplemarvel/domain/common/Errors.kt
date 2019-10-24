package com.acv.simplemarvel.domain.common

sealed class DomainError(val error: String = "Error")
object NotInternetDomainError : DomainError()
data class UnknownDomainError(val errorMessage: String = "Unknown Error") : DomainError(errorMessage)
data class NotIndexFoundDomainError(val key: String) : DomainError()
