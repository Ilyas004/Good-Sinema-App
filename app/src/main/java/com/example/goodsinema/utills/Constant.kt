package com.example.goodsinema.utills

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/"
    const val KEY_API = "9bc5acfca646d35337c31a0560bcd23c"

    const val GET_FAVORITES_FILMS = "get_favorites"
    const val GET_BROKER_FILMS = "get_broker"

    fun checkSelected(currentRoute: String, nowRoute: String): Boolean {
        return if (currentRoute.contains("/")) {
            nowRoute.contains(Constant.GET_FAVORITES_FILMS)
        } else {
            true
        }
    }
}
