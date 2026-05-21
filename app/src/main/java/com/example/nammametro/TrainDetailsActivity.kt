package com.example.nammametro

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class TrainDetailsActivity : AppCompatActivity() {

    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train_details)

        val announceButton = findViewById<Button>(R.id.announceButton)

        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.forLanguageTag("kn-IN")
            }
        }

        announceButton.setOnClickListener {
            tts.speak(
                "ಮೈಸೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್ ಪ್ಲಾಟ್‌ಫಾರ್ಮ್ 2ಕ್ಕೆ ಬರುತ್ತಿದೆ. ಜನರಲ್ ಕೋಚ್ ಪಿಲ್ಲರ್ 3 ಬಳಿ ಇರುತ್ತದೆ.",
                TextToSpeech.QUEUE_FLUSH,
                null,
                "KannadaAnnouncement"
            )
        }

        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {

            val intent = Intent(this, CoachLayoutActivity::class.java)
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
