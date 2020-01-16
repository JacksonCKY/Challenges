package com.example.challenges

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.challenge_activity.*


class ChallengesActivity : AppCompatActivity() {

    private var challengeDatabase: ChallengeDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenge_activity)

        challengeDatabase = ChallengeDatabase(this)

        buttonMyChallenge.setOnClickListener {
            val intent = Intent(this, MyChallenges::class.java)
            startActivity(intent)
        }

        buttonJoin1.setOnClickListener {
            val intent = Intent(this, ChallengeDetails1::class.java)
            startActivity(intent)
        }

        buttonJoin2.setOnClickListener {
            val intent = Intent(this, ChallengeDetails2::class.java)
            startActivity(intent)
        }

        buttonJoin3.setOnClickListener {
            val intent = Intent(this, ChallengeDetails3::class.java)
            startActivity(intent)
        }
    }
}
