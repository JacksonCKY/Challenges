package com.example.challenges
import java.io.Serializable

class ChallengeModel : Serializable {

    private var img: Int = 0
    var challengeTitles: String? = null
    var challengeDescription: String? = null
    var id: Int = 0

    fun getIds(): Int {
        return id
    }

    fun setIds(id: Int) {
        this.id = id
    }

    fun getImage(): Int {
        return img
    }

    fun setImage(img: Int) {
        this.img = img
    }

    fun getTitles(): String {
        return challengeTitles.toString()
    }

    fun setTitles(challengeTitles: String) {
        this.challengeTitles = challengeTitles
    }

    fun getDescription(): String {
        return challengeDescription.toString()
    }

    fun setDescription(challengeDescription: String) {
        this.challengeDescription = challengeDescription
    }
}