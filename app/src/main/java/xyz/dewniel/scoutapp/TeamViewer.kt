package xyz.dewniel.scoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.dewniel.scoutapp.databinding.ActivityViewerBinding

class TeamViewer : AppCompatActivity() {

    private lateinit var binding : ActivityViewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        println(intent.getStringExtra("team"))
        val team = intent.getStringExtra("team")
        val totalPoints = intent.getStringExtra("total_points")
        val lowPoints = intent.getStringExtra("low_points")
        val highPoints = intent.getStringExtra("high_points")
        val climbPoints = intent.getStringExtra("climb_points")

        binding.teamName.text = team
        binding.editTotal.text = totalPoints
        binding.editLow.text = lowPoints
        binding.editHigh.text = highPoints
        binding.editClimb.text = climbPoints
    }
}
