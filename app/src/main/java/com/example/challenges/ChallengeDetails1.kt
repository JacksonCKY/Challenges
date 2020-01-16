package com.example.challenges

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_challenge_details1.*

class ChallengeDetails1 : AppCompatActivity() {

    private var challengeDatabase: ChallengeDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_details1)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        challengeDatabase = ChallengeDatabase(this)

        buttonConfirm1.setOnClickListener{
            challengeDatabase!!.insertChallenge(R.drawable.armmuscle, "Starfit Arm Muscle Challenge", "Time left : 3 Months")
            val intent = Intent(this, MyChallenges::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or  Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}
