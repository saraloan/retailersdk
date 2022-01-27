package com.saraloan.retailersdk.models

import com.google.gson.annotations.SerializedName

class EmbedSession {

    @SerializedName("business_id")
    var business_id: Int = 0

    @SerializedName("person_id")
    var person_id: Int = 0

    @SerializedName("distributor")
    var distributor: String = ""

    @SerializedName("session_id")
    var session_id: String = ""
}