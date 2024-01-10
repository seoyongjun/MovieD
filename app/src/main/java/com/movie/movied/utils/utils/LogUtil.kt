package com.movie.movied.utils.utils

import timber.log.Timber


inline fun <reified T> T.debug(message: String) = Timber.d(message)
