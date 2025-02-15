package com.tiny.url.core.presentation

import com.tiny.url.core.domain.DataError
import tinyurlkmp.composeapp.generated.resources.Res
import tinyurlkmp.composeapp.generated.resources.error_disk_full
import tinyurlkmp.composeapp.generated.resources.error_empty_url
import tinyurlkmp.composeapp.generated.resources.error_invalid_url
import tinyurlkmp.composeapp.generated.resources.error_local_unknown
import tinyurlkmp.composeapp.generated.resources.error_method_not_allowed
import tinyurlkmp.composeapp.generated.resources.error_no_internet
import tinyurlkmp.composeapp.generated.resources.error_request_timeout
import tinyurlkmp.composeapp.generated.resources.error_serialization
import tinyurlkmp.composeapp.generated.resources.error_server
import tinyurlkmp.composeapp.generated.resources.error_too_many_requests
import tinyurlkmp.composeapp.generated.resources.error_unauthorized
import tinyurlkmp.composeapp.generated.resources.error_unknown

fun DataError.asUiText(): UiText {
    val stringRes = when (this) {
        DataError.Remote.UNAUTHORIZED -> Res.string.error_unauthorized
        DataError.Remote.METHOD_NOT_ALLOWED -> Res.string.error_method_not_allowed
        DataError.Remote.INVALID_URL -> Res.string.error_invalid_url
        DataError.Remote.EMPTY_URL -> Res.string.error_empty_url
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_server
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_local_unknown
    }

    return UiText.StringResourceId(stringRes)
}
