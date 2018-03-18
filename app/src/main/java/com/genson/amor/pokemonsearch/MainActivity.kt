package com.genson.amor.pokemonsearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val POKEMON_KEY_ID = "id"
    private val POKEMON_KEY_NAME = "name"
    private val POKEMON_KEY_SPRITES = "sprites"
    private val POKEMON_KEY_FRONT_DEFAULT = "front_default"
    private val addPokemon = ArrayList<Pokemon>()
    private val url = "https://pokeapi.co/api/v2/pokemon/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.GONE

        btnSearch.setOnClickListener {
            addPokemon.clear()
            progressBar.visibility = View.VISIBLE
            scrollView.visibility = View.GONE
            relative_layout.visibility = View.GONE
            imgView_pokemon.visibility = View.GONE
            tV_pokeName.visibility = View.GONE
            tV_pokeType.visibility = View.GONE
            tV_height.visibility = View.GONE
            tV_id.visibility = View.GONE

            fetchPokemons()
        }



    }


    private fun fetchPokemons() {

        doAsync {
            var tempName = eT_SearchPoke.text.toString()
            val resulJson = URL(url + tempName).readText()
            val jsonObject = JSONObject(resulJson)
            val pokemonID = jsonObject.getInt(POKEMON_KEY_ID)
            val pokemonName = jsonObject.getString(POKEMON_KEY_NAME)
            val pokemonSprite = jsonObject.getJSONObject(POKEMON_KEY_SPRITES).getString(POKEMON_KEY_FRONT_DEFAULT)

            val pokemonType = jsonObject.getJSONArray("types").getJSONObject(0)
                    .getJSONObject("type").getString("name")


            uiThread {

                recyclerView.adapter = PokemonAdapter(addPokemon)
                addPokemon.add(Pokemon(Sprite(pokemonSprite),
                        pokemonID,
                        pokemonName,
                        pokemonType))

                when {
                    pokemonID < 10 -> tV_id.text = "#00" + pokemonID
                    pokemonID > 100 -> tV_id.text = "#" + pokemonID
                    pokemonID > 10 -> tV_id.text = "#0" + pokemonID
                }
                tV_id.text = pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1)

                Picasso.with(this@MainActivity).load(pokemonSprite).into(imgView_pokemon)

                progressBar.visibility = View.GONE
                scrollView.visibility = View.VISIBLE
                relative_layout.visibility = View.VISIBLE
                imgView_pokemon.visibility = View.VISIBLE
                tV_pokeName.visibility = View.VISIBLE
                tV_pokeType.visibility = View.VISIBLE
                tV_height.visibility = View.VISIBLE
                tV_id.visibility = View.VISIBLE

            }

        }
    }


}

