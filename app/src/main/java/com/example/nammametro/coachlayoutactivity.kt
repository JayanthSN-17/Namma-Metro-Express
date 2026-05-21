package com.example.nammametro

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class CoachLayoutActivity : AppCompatActivity() {

    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_coach_layout)

        val announceButton =
            findViewById<Button>(R.id.arrivalAnnouncementButton)

        val ticketButton =
            findViewById<Button>(R.id.ticketButton)

        tts = TextToSpeech(this) { status ->

            if (status == TextToSpeech.SUCCESS) {

                tts.language = Locale.forLanguageTag("kn-IN")
            }
        }

        announceButton.setOnClickListener {

            tts.speak(
                "ಮುಂದಿನ ರೈಲು 30 ನಿಮಿಷಗಳಲ್ಲಿ ಪ್ಲಾಟ್‌ಫಾರ್ಮ್ 2ಕ್ಕೆ ಬರುತ್ತದೆ.",
                TextToSpeech.QUEUE_FLUSH,
                null,
                "NextTrainAnnouncement"
            )
        }

        ticketButton.setOnClickListener {

            val intent =
                Intent(this, TicketPriceActivity::class.java)

            startActivity(intent)
        }
    }

    override fun onDestroy() {

        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }

        super.onDestroy()
    }
}