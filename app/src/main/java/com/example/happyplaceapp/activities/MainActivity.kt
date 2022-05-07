package com.example.happyplaceapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.happyplaceapp.R
import com.example.happyplaceapp.database.DatabaseHandler
import com.example.happyplaceapp.models.HappyPlaceModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val fabAddHappyPlace = findViewById<FloatingActionButton>(R.id.fabAddHappyPlace)
        fabAddHappyPlace.setOnClickListener{
            val intent = Intent(this, AddHappyPlaceActivity::class.java)
            startActivity(intent)
        }
        getHappyPlacesListFromLocalDB()
    }

    private fun getHappyPlacesListFromLocalDB(){
        val dbHandler = DatabaseHandler(this)
        val getHappyPlaceList : ArrayList<HappyPlaceModel> = dbHandler.getHappyPlacesList()

        if(getHappyPlaceList.size > 0){
            for(i in getHappyPlaceList){
                Log.e("Title",i.title)
                Log.e("Description",i.description)
            }
        }
    }
}

