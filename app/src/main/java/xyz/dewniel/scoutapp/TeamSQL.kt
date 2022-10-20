package xyz.dewniel.scoutapp

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
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTblTeam = ("CREATE TABLE " + TBL_TEAM + "(" + TEAM_ID + "INTEGER PRIMARY KEY," + TOTAL_POINTS +)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}
