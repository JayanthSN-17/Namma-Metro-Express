package com.example.nammametro

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TicketPriceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ticket_price)

        val confirmButton =
            findViewById<Button>(R.id.confirmButton)

        confirmButton.setOnClickListener {

            Toast.makeText(
                this,
                "Ticket Confirmed 🚆",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}