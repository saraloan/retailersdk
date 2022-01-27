package com.saraloan.retailersdk.util

class Constants {
    companion object {
        val TAG = "---------> SARALOAN_LOG"
        val STAG_API_URL = "https://stag.saraloan.in/api/v1/"
        val STAG_PWA_URL = "https://dev.app.saraloan.in/"

        val PROD_API_URL = "https://api.blacksoil.co.in/api/v1/"
        val PROD_PWA_URL = "https://app.blacksoil.co.in/"

        var urls = mapOf(
            "embed_session" to "core/businesses/get_embed_session/"
        )
    }

}