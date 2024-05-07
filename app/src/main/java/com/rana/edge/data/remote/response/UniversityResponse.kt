package com.rana.edge.data.remote.response


import com.google.gson.annotations.SerializedName

class UniversityResponse : ArrayList<UniversityResponseItem>()

data class UniversityResponseItem(
    @SerializedName("alpha_two_code") val alphaTwoCode: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("domains") val domains: List<String?>?,
    @SerializedName("name") val name: String?,
    @SerializedName("state-province") val stateProvince: String?,
    @SerializedName("web_pages") val webPages: List<String?>?
)