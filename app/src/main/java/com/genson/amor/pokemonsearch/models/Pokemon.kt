package com.genson.amor.pokemonsearch

import com.google.gson.annotations.SerializedName

/**
 * Created by Genson on 17/03/2018.
 */
data class Pokemon (val sprites: Sprite,
                    val type: String,
                    val height: Float,
                    val mana: Long,
                    val count: Long)

data class Sprite(@SerializedName("front_default")
                  val frontDefault: String
)