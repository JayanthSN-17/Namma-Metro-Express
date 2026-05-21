package com.example.nammametro

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SelectTrainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_train)

        val spinner = findViewById<Spinner>(R.id.trainSpinner)
        val nextButton = findViewById<Button>(R.id.nextButton)

        val trains = arrayOf(
            "Mysuru Express - ಮೈಸೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್",
            "Mangaluru Express - ಮಂಗಳೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್",
            "Hubballi Express - ಹುಬ್ಬಳ್ಳಿ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
            "Koppal Passenger - ಕೊಪ್ಪಳ ಪ್ಯಾಸೆಂಜರ್",
            "Hassan Express - ಹಾಸನ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
            "Bidar Express - ಬೀದರ್ ಎಕ್ಸ್‌ಪ್ರೆಸ್"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            trains
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        nextButton.setOnClickListener {
            val intent = Intent(this, TrainDetailsActivity::class.java)
            intent.putExtra("selectedTrain", spinner.selectedItem.toString())
            startActivity(intent)
        }
    }
}