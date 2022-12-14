package xyz.dewniel.scoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.SeekBar
import xyz.dewniel.scoutapp.databinding.ActivityCreateTeamBinding
import xyz.dewniel.scoutapp.databinding.ActivityCreateTeleBinding

class TeleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateTeleBinding
    private lateinit var teamArrayList: ArrayList<Team>

    val team = intent.getStringExtra("team")
    val color = intent.getStringExtra("team_color")
    val low_points = intent.getStringExtra("low_points")
    val high_points = intent.getStringExtra("high_points")
    val taxi = intent.getStringExtra("taxi")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var lowplus: Int = 0
        var highplus: Int = 0

        binding.lowPointPlus.setOnClickListener() {
            lowplus++
        }

        binding.button.setOnClickListener() {
            highplus++
        }



        binding.nextButton.setOnClickListener() {
            var oldlow: Int = (low_points?.toInt()!!.times(2))
            var oldHigh: Int = (high_points?.toInt()!!.times(4))
            var climb_points = (binding.climb.progress * 4)

            val result = Team(team?.toInt() ?: 0, (oldlow + lowplus), (oldHigh + (highplus *2)), climb_points, taxi.toBoolean())
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }



}