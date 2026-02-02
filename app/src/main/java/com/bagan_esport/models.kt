package com.bagan_esport

import java.io.Serializable

data class Hero(
    val name: String,
    val price: Int
) : Serializable

data class Player(
    val name: String,
    val price: Int
) : Serializable

data class Team(
    val name: String,
    var trophies: Int = 0,
    var championships: Int = 0,
    var money: Int = 1000,
    var wealthRank: Int = 0,
    var heroes: MutableList<Hero> = mutableListOf(),
    var players: MutableList<Player> = mutableListOf(),
    var logoPath: String = ""
) : Serializable
