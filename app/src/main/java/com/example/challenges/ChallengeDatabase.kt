package com.example.challenges

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ChallengeDatabase (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    val getAllData: ArrayList<ChallengeModel>
        get() {
            val challengeModelArrayList = ArrayList<ChallengeModel>()

            val selectQuery = "SELECT  * FROM $TABLE_NAME"
            val db = this.readableDatabase
            val c = db.rawQuery(selectQuery, null)
            if (c.moveToFirst()) {
                do {
                    val challengeModel = ChallengeModel()
                    challengeModel.setIds(c.getInt(c.getColumnIndex(COL_1)))
                    challengeModel.setImage(c.getInt(c.getColumnIndex(COL_2)))
                    challengeModel.setTitles(c.getString(c.getColumnIndex(COL_3)))
                    challengeModel.setDescription(c.getString(c.getColumnIndex(COL_4)))
                    challengeModelArrayList.add(challengeModel)
                } while (c.moveToNext())
            }
            return challengeModelArrayList
        }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NAME TEXT,GALAXY TEXT,TYPE TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertChallenge(img: Int, title: String, description: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, img)
        contentValues.put(COL_3, title)
        contentValues.put(COL_4, description)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }


    fun deleteChallenge(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "ID = ?", arrayOf(id))
    }

    companion object {
        const val DATABASE_NAME = "challenge.db"
        const val TABLE_NAME = "challenge_table"
        const val COL_1 = "ID"
        const val COL_2 = "IMAGE"
        const val COL_3 = "TITLE"
        const val COL_4 = "DESCRIPTION"

    }
}