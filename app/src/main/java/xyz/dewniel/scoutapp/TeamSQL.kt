package xyz.dewniel.scoutapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
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
    }

}
