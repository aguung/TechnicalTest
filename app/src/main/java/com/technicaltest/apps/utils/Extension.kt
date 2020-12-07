package com.technicaltest.apps.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.technicaltest.apps.data.ErrorType
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.errorMapper(): ErrorType {
    return when (this) {
        is UnknownHostException,
        is SocketTimeoutException -> ErrorType.CONNECTION
        is HttpException -> {
            when {
                this.code() == HttpURLConnection.HTTP_UNAUTHORIZED -> {
                    ErrorType.UNAUTHORIZED
                }
                this.code() == HttpURLConnection.HTTP_NOT_FOUND -> {
                    ErrorType.NOT_FOUND
                }
                else -> {
                    ErrorType.SOMETHING_WRONG
                }
            }
        }
        else -> {
            ErrorType.SOMETHING_WRONG
        }
    }
}

fun View.snackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}