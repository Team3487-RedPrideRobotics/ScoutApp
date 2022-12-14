package xyz.dewniel.scoutapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "TeamDB"
val TABLE_NAME = "Teams"
val COL_ID = "History Collumn"
var COL_TEAM = "Team"
var COL_LOW = "Low Points"
var COL_HIGH = "High Points"
var COL_CLIMB = "Climb Points"
var COL_TAXI = "Taxi"

class DataBaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_TEAM + " INTEGER," + COL_LOW + " INTEGER," + COL_HIGH + " INTEGER," + COL_CLIMB + " INTEGER," +
                COL_TAXI + "BOOLEAN)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(team: Team) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_ID, team.id)
        cv.put(COL_TEAM, team.team)
        cv.put(COL_LOW, team.low_points)
        cv.put(COL_HIGH, team.high_points)
        cv.put(COL_CLIMB, team.climb_points)
        cv.put(COL_TAXI, team.taxi)
        var result = db.insert(TABLE_NAME, null, cv)
        /* (result == -1.toLong())
            Toast.makeText(context, "Failed to create Team", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context, "Made the Team!", Toast.LENGTH_LONG).show()
         */
    }
}