package com.genson.amor.pokemonsearch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
//import com.genson.amor.pokemonsearch.models.Pokemon
import kotlinx.android.synthetic.main.activity_pokemon.view.*

/**
 * Created by Genson on 17/03/2018.
 */
class PokemonAdapter(private val mContext: Context,
                     private val mPokemonList: ArrayList<Pokemon>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    fun add(pokemon: Pokemon){
        mPokemonList.add(pokemon)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mPokemonList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.activity_pokemon, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pokemon = mPokemonList[position]
        Glide.with(mContext).load(pokemon.sprites.frontDefault).into(holder.imgView_pokemon)

    }


//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
//        val itemView = LayoutInflater.from(mContext).inflate(R.layout.activity_pokemon, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
//        val pokemon = mPokemonList[position]
//
//        //implement glide in gradle
//        Glide.with(mContext).load(pokemon.sprites.frontDefault).into(holder.imgView_pokemon)
//        holder.tV_pokeType.text = pokemon.type
//        holder.tV_height.text = pokemon.height
//        holder.tV_mana.text = pokemon.mana

}



class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val imgView_pokemon = itemView.findViewById<ImageView>(R.id.imgView_pokemon)
    val tV_pokeType = itemView.findViewById<TextView>(R.id.tV_pokeType)
    val tV_height = itemView.findViewById<TextView>(R.id.tV_height)
    val tV_mana = itemView.findViewById<TextView>(R.id.tV_mana)
}
}

