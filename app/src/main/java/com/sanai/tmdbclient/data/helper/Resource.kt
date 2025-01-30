package com.sanai.tmdbclient.data.helper

data class Resource<T>(val status: Status, val data: T?, val message: String?)
