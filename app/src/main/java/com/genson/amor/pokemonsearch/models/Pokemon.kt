package com.genson.amor.pokemonsearch

import com.google.gson.annotations.SerializedName

/**
 * Created by Genson on 17/03/2018.
 */
data class Pokemon(val sprite: Sprite,
                   val id: Int,
                   val name: String,
                   val type: String,
                   val abilities: String,
                   val height: String,
                   val weight: String,
                   val pokemonWeight: String,
                   val moves1: Move,
                   val moves2: Move,
                   val hp: baseStats,
                   val attack: baseStats,
                   val defence: baseStats,
                   val spAttack: baseStats,
                   val spDefence: baseStats,
                   val speed: baseStats
)

data class Sprite(@SerializedName("front_default")
                  val frontDefault: String
)

class Move(val pokemonMove: String)

class baseStats(val stats: String)