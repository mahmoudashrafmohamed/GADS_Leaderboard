package com.mahmoud_ashraf.gadsleaderboard.data.models

data class Leader(
    val name: String,
    var hours:Int,
    val country:String,
    val badgeUrl : String,
    val score : Int ?= null
)