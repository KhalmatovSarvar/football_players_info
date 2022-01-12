package com.example.football_players_info

data class Player(
    val name: String,
    val image: Int,
    val description: String,
    var expand: Boolean = false,
    val moreInfoUrl:String,
)
