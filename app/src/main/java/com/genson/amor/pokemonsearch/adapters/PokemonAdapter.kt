package com.genson.amor.pokemonsearch

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*


/**
 * Created by Genson on 17/03/2018.
 */

class PokemonAdapter(private val pokemon: ArrayList<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.CustomViewHolder>() {


    override fun getItemCount(): Int {
        return pokemon.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

        holder?.itemView?.tV_height?.text = pokemon[position].height
        holder?.itemView?.tV_weight?.text = pokemon[position].weight

        holder?.itemView?.tV_pokeType?.text = pokemon[position].type.substring(0,1).toUpperCase() + pokemon[position].type.substring(1)
        holder?.itemView?.tV_pokeAbilities?.text = pokemon[position].abilities.substring(0, 1).toUpperCase() + pokemon[position].abilities.substring(1)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {

        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent, false)
        return CustomViewHolder(itemView)
    }


//    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
////        val imgPokemon = view.findViewById<ImageView>(R.id.imgView_pokemon)
////        val pokeName = view.findViewById<TextView>(R.id.tV_pokeName)
////        val pokeType = view.findViewById<TextView>(R.id.tV_pokeType)
//
//    }

    class CustomViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


    }
}





