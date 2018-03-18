package com.genson.amor.pokemonsearch

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pokemon.*
import okhttp3.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val mTag = "PokemonSearch"
    private lateinit var mAdapter: PokemonAdapter

//    private var pokemonList = ArrayList<Pokemon>()
//    private val url = "https://pokeapi.co/api/v2/pokemon/?type="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = PokemonAdapter(this, ArrayList() )
        val layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = layoutManager

        fetchPokemons()

    }


    private fun fetchPokemons() {
        val url = "https://pokeapi.co/api/v2/pokemon/?type="

        val request = Request.Builder.url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(mTag, "Failed to fetch pokemon", e)
            }

            override fun onResponse(call: Call?, response: Response?) {
                if (response!=null && response.isSuccessful){
                    val json = response.body()?.string()
                    val gson = GsonBuilder().create()
                    val pokemon = gson.fromJson(json, Pokemon::class.java)

                    runOnUiThread {
                        mAdapter.add(pokemon)
                    }

                }
            }


        })
    }
}




//
//        btnSearch.setOnClickListener {
//            progressBar.visibility = View.VISIBLE
//            // to hide the output layouts
//
//            tV_pokeType.visibility = View.GONE
//            tV_height.visibility = View.GONE
//            tV_mana.visibility = View.GONE
//
//            //should be added?
//
//            val type = tV_SearchPoke.text.toString()
//            doAsync {
//                val resultJson = URL(url + type).readText()
//                uiThread {
//                    val pokemon: Pokemon = Gson().fromJson(resultJson, Pokemon::class.java)
//                    val type = pokemon.type
//                    tV_pokeType.text = type
//
//                    ///try out height
//                    val heightSpan = pokemon.height
//                    tV_height.text = heightSpan.toString()
//                    ///try out mana
//                    val mana = pokemon.mana
//                    tV_mana.text = mana.toString()
//
//                    progressBar.visibility = View.GONE
//
//                    tV_pokeType.visibility = View.VISIBLE
//                    tV_height.visibility = View.VISIBLE
//                    tV_mana.visibility = View.VISIBLE
//                }
//            }
//        }