package ru.akostiuchek.dnd_application

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.util.rangeTo
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import ru.akostiuchek.dnd_application.Character
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Character>
    private var jsonName: String = "characters.json"


//    private var jsonArray: JSONArray = JSONArray(readJson())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Character>()
        getUserData()

        val btnAdd : ImageView = findViewById(R.id.icPlus)
        btnAdd.setOnClickListener {
            val addCharacterActivityIntent : Intent = Intent(this, AddNewCharacterActivity::class.java)
            startActivity(addCharacterActivityIntent)
        }

    }

    private fun getUserData() {
        var json: String? = null

        try {
            val inputStream: InputStream = assets.open(jsonName)
            json = inputStream.bufferedReader().use { it.readText() }

            val jsonArray = JSONArray(json)

            for (i in 0..<jsonArray.length())
            {
                val jsonObject = jsonArray.getJSONObject(i)
                val newCharacterName = jsonObject.getString("name")
                val newCharacterRace = jsonObject.getString("race")
                val newCharacterClass = jsonObject.getString("class")
                newArrayList.add(Character(newCharacterName, newCharacterRace, newCharacterClass))
            }

            newRecyclerView.adapter = MyAdapter(newArrayList)


        } catch (_: IOException)
        {
            val textHead : TextView = findViewById(R.id.tvHeader)
            textHead.text = "ERROR"
        }
    }
}