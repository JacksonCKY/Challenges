package com.example.challenges

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_my_challenges.*

class MyChallenges : AppCompatActivity() {

    private var listView: ListView? = null
    private var challengeModelArrayList: ArrayList<ChallengeModel>? = null
    private var challengeAdapter: ChallengesAdapter? = null
    private var challengeDatabase: ChallengeDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_challenges)

        listView = findViewById(R.id.listViewChallenges)
        challengeDatabase = ChallengeDatabase(this)
        challengeModelArrayList = challengeDatabase!!.getAllData
        challengeAdapter = ChallengesAdapter(this, this.challengeModelArrayList!!)
        listView!!.adapter = challengeAdapter

        buttonExplore.setOnClickListener {
            val intent = Intent(this, ChallengesActivity::class.java)
            startActivity(intent)
        }
    }
}
