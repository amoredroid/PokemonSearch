package com.genson.amor.pokemonsearch

import com.google.gson.annotations.SerializedName

/**
 * Created by Genson on 17/03/2018.
 */
data class Pokemon (val sprite: Sprite,
                    val id: Int,
                    val name: String,
                    val type: String,
                    val abilities: String,
                    val height: String,
                    val weight: String,
                    val pokemonWeight: String
)

data class Sprite(@SerializedName("front_default")
                  val frontDefault: String
)