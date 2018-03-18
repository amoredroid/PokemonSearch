package com.genson.amor.pokemonsearch

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
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

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

        holder?.itemView?.tV_pokeType?.text = pokemon[position].type.substring(0,1).toUpperCase() + pokemon[position].type.substring(1)

    }


    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPokemon = view.findViewById<ImageView>(R.id.imgView_pokemon)
        val pokeName = view.findViewById<TextView>(R.id.tV_pokeName)
        val pokeType = view.findViewById<TextView>(R.id.tV_pokeType)

    }

}



//
//class PokemonAdapter(private val pokemon: ArrayList<Pokemon>) :
//        RecyclerView.Adapter<RecyclerView.ViewHolder>(), Parcelable {
//
//    constructor(parcel: Parcel) : this(TODO("mPokemonList")) {
//    }
//
//    override fun getItemCount(): Int {
//        return pokemon.size
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
//        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//         txtPokemonName.text = pokeName.substring(0, 1).toUpperCase() + pokeName.substring(1)
//         holder?.view?.txtType?.text = poke[position].types.substring(0, 1).toUpperCase() +poke[position].types.substring(1)
//    }
//
//
//
//
//}
//
//





