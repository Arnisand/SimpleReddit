package com.arnisand.simplereddit.data.network.adapter

abstract class GeneralCauseError(message: String) : Throwable(message)

sealed class NetworkError(message: String) : GeneralCauseError(message)

class ServerUnavailable(message: String = "") : NetworkError(message)
class NotFound(message: String = "") : NetworkError(message)
class Unexpected(message: String = "") : NetworkError(message)
class Serialization(message: String = "") : NetworkError(message)
class Unauthorised(message: String = "") : NetworkError(message)
class Validation(message: String = "") : NetworkError(message)
class Denied(message: String = "") : NetworkError(message)

class IOException(message: String = ""): GeneralCauseError(message)
