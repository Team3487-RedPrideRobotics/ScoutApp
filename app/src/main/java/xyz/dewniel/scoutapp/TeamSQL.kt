package xyz.dewniel.scoutapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class TeamSQL(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "teams.db"
        private const val TBL_TEAM = "tbl_team"
        private const val TEAM_ID = "team_id"
        private const val TOTAL_POINTS = "total_points"
        private const val LOW_POINTS = "low_points"
        private const val HIGH_POINTS = "high_points"
        private const val CLIMB_POINTS = "climb_points"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTblTeam = ("CREATE TABLE " + TBL_TEAM + "(" + TEAM_ID + "INTEGER PRIMARY KEY," + TOTAL_POINTS + "INTEGER" + LOW_POINTS + "INTEGER" + HIGH_POINTS + "INTEGER" + CLIMB_POINTS + "INTEGER" + ")")
        db?.execSQL(createTblTeam)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_TEAM")
        onCreate(db)
    }

    fun insertTeam(tmd: TeamModel): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(TEAM_ID, tmd.team_id)
        contentValues.put(TOTAL_POINTS, tmd.total_points)
        contentValues.put(LOW_POINTS, tmd.low_points)
        contentValues.put(HIGH_POINTS, tmd.high_points)
        contentValues.put(CLIMB_POINTS, tmd.climb_points)

        val success = db.insert(TBL_TEAM, null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getAllTeams(): ArrayList<TeamModel> {
        val stdList: ArrayList<TeamModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_TEAM"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var team_id: Int
        var total_points: Int
        var low_points: Int
        var high_points: Int
        var climb_points: Int

        if (cursor.moveToFirst()) {
            do {
                team_id = cursor.getInt(cursor.getColumnIndex("team_id"))
                total_points = cursor.getInt(cursor.getColumnIndex("total_points"))
                low_points = cursor.getInt(cursor.getColumnIndex("low_points"))
                high_points = cursor.getInt(cursor.getColumnIndex("high_points"))
                climb_points = cursor.getInt(cursor.getColumnIndex("climb_points"))

                val std = TeamModel(team_id = team_id, total_points = total_points, low_points = low_points, high_points = high_points, climb_points = climb_points)
                stdList.add(std)
            } while (cursor.moveToNext())
        }
        return stdList
    }

}
