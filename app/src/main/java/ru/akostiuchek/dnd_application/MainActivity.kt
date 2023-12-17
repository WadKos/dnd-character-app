package ru.akostiuchek.dnd_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.akostiuchek.dnd_application.Character
//import ru.akostiuchek.dnd_application.ActivityMain

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    lateinit var newArrayList: ArrayList<Character>
    lateinit var characterName : Array<String>
    lateinit var characterRace : Array<String>
    lateinit var characterClass : Array<String>

//    private var _binding: ActivityLearnWordBinding? = null
//    private val binding
//        get() = _binding ?: throw IllegalStateException("Binding for ActivityLearnWordBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        characterName = arrayOf(
            "Pidrilkin",
            "Shtormar",
            "Slonid",
            "Kuban",
        )

        characterRace = arrayOf(
            "Dwarf",
            "Human",
            "Elephant",
            "Asian",
        )

        characterClass = arrayOf(
            "Hunter",
            "Mage",
            "Druid",
            "Powerlifter",

        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Character>()
        getUserData()

        val newCharacterName : String = intent.getStringExtra("name") ?: "New Name"
        val newCharacterRace : String = intent.getStringExtra("race") ?: "New Race"
        val newCharacterClass : String = intent.getStringExtra("class") ?: "New class"


        val newCharacter : Character = Character(newCharacterName, newCharacterRace, newCharacterClass)

        newArrayList.add(newCharacter)

        val btnAdd : ImageView = findViewById(R.id.icPlus)
        btnAdd.setOnClickListener {
            val addCharacterActivityIntent : Intent = Intent(this, AddNewCharacterActivity::class.java)
            startActivity(addCharacterActivityIntent)
        }

    }

    private fun getUserData() {
        for (i in characterName.indices) {
            val character = Character(characterName[i], characterRace[i], characterClass[i])
            newArrayList.add(character)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}