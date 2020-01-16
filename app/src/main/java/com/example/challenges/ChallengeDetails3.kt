package com.example.challenges

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_challenge_details3.*

class ChallengeDetails3 : AppCompatActivity() {

    private var challengeDatabase: ChallengeDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_details3)

        challengeDatabase = ChallengeDatabase(this)

        buttonConfirm3.setOnClickListener{
            challengeDatabase!!.insertChallenge(R.drawable.situp, "Starfit Sit-Up Challenge", "Time left : 4 Months")
            val intent = Intent(this, MyChallenges::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }
    }
}
