package xyz.dewniel.scoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import xyz.dewniel.scoutapp.databinding.ActivityMainBinding
import xyz.dewniel.scoutapp.Team

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var teamArrayList: ArrayList<Team>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamArrayList = ArrayList()

        for(element in allTeams) {
            teamArrayList.add(element)
        }
        binding.teamList.adapter = TeamAdapter(this, teamArrayList)
        binding.teamList.isClickable = true
        binding.teamList.setOnItemClickListener { _, _, position, _ ->
            val thing = allTeams[position]
            val team = thing.team.toString()
            val totalPoints = thing.total_points.toString()
            val lowPoints = thing.low_points.toString()
            val highPoints = thing.high_points.toString()
            val climbPoints = thing.climb_points.toString()



            val i = Intent(this, TeamViewer::class.java)
            i.putExtra("team", team)
            i.putExtra("total_points", totalPoints)
            i.putExtra("low_points", lowPoints)
            i.putExtra("high_points", highPoints)
            i.putExtra("climb_points", climbPoints)
            startActivity(i)


        }

    }
}