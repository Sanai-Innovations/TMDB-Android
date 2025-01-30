package com.sanai.tmdbclient.data.model.tv_show


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    var results: List<TvShow>
)