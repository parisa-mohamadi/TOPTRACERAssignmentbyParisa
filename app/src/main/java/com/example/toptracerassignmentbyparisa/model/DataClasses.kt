package com.example.toptracerassignmentbyparisa

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data") val res: List<GifInfo>
)
data class GifInfo(val title: String , val images:DataImage )
data class DataImage(
    @SerializedName("original") val ogImage: OgImage
)
data class OgImage(val url:String)