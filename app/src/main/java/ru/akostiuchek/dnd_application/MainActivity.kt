package ru.akostiuchek.dnd_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.akostiuchek.dnd_application.Character

class MainActivity : AppCompatActivity() {

//    var listOfCharacter: MutableList<Character> = mutableListOf<Character>()

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Character>
    lateinit var characterName : Array<String>
    lateinit var characterRace : Array<String>
    lateinit var characterClass : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterName = arrayOf(
            "Pidrilkin",
            "Shtormar",
            "Slonid",
        )

        characterRace = arrayOf(
            "Dwarf",
            "Human",
            "Elephant",
        )

        characterClass = arrayOf(
            "Hunter",
            "Mage",
            "Druid",
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Character>()
        getUserData()
    }

    private fun getUserData() {
        for (i in characterName.indices) {
            val character = Character(i, characterName[i], characterRace[i], characterClass[i])
            newArrayList.add(character)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}