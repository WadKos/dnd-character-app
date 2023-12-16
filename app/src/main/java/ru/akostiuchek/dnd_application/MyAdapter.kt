package ru.akostiuchek.dnd_application

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val characterList : ArrayList<Character>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val characterView = LayoutInflater.from(parent.context).inflate(R.layout.character_view, parent, false)
        return MyViewHolder(characterView)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = characterList[position]
        holder.tvName.text = currentItem.characterName
        holder.tvRaceClass.text = "${currentItem.characterRace} : ${currentItem.characterClass}"
    }

    class MyViewHolder(characterView: View) : RecyclerView.ViewHolder(characterView) {


        val tvName : TextView = characterView.findViewById(R.id.name)
        val tvRaceClass : TextView = characterView.findViewById(R.id.raceClass)
    }
}