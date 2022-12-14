package xyz.dewniel.scoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import xyz.dewniel.scoutapp.databinding.ActivityCreateTeamBinding

class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateTeamBinding
    private lateinit var teamArrayList: ArrayList<Team>


    override fun onCreate(savedInstanceState: Bundle?) {
        var color: Boolean = false;
        // red is always false

        super.onCreate(savedInstanceState)

        binding = ActivityCreateTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.colorButton.setBackgroundColor(getResources().getColor(R.color.red))

        binding.colorButton.setOnClickListener() {
            if (color == false) {
                color == true
                binding.colorButton.setBackgroundColor(getResources().getColor(R.color.blue))
            }
            else {
                color == false
                binding.colorButton.setBackgroundColor(getResources().getColor(R.color.red))
            }
        }

        binding.nextButton.setOnClickListener() {
            val team = binding.teamName.toString()

            val i = Intent(this, AutoActivity::class.java)
            i.putExtra("team", team)
            i.putExtra("team_color", color)
            startActivity(i)


        }

    }
}