package com.saraloan.retailersdk.services

import com.saraloan.retailersdk.models.EmbedSession
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface EmbedService {
    @FormUrlEncoded
    @POST("core/businesses/get_embed_session/")
    fun getEmbedSession(
        @Field("mobile") mobile: String,
        @Header("Authorization") auth: String
    ): Call<EmbedSession>;
}