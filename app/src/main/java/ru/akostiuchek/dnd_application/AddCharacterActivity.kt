package ru.akostiuchek.dnd_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.akostiuchek.dnd_application.Character

class AddCharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_character)

        val btnCorrect : ImageView = findViewById(R.id.icCorrect)

        btnCorrect.setOnClickListener {
            val characterName : EditText = findViewById(R.id.etName)
            val characterRace : EditText = findViewById(R.id.etRace)
            val characterClass : EditText = findViewById(R.id.etClass)

            val character : Character = Character(
                characterName.text.toString(),
                characterRace.text.toString(),
                characterClass.text.toString())


            MainActivity().newArrayList.add(character)
            val mainActivityIntent : Intent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }
    }
}