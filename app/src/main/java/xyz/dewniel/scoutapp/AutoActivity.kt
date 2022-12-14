package xyz.dewniel.scoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import xyz.dewniel.scoutapp.databinding.ActivityCreateAutoBinding
import xyz.dewniel.scoutapp.databinding.ActivityCreateTeamBinding

class AutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAutoBinding
    private lateinit var teamArrayList: ArrayList<Team>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateAutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val team = intent.getStringExtra("team")
        val color = intent.getStringExtra("team_color")
        var taxi: Boolean = false

        var lowplus: Int = 0
        var highplus: Int = 0

        binding.lowPointPlus.setOnClickListener() {
            lowplus++
        }

        binding.highpointplus.setOnClickListener() {
            highplus++
        }



        binding.nextButton.setOnClickListener() {

            val i = Intent(this, TeleActivity::class.java)
            i.putExtra("team", team)
            i.putExtra("team_color", color)
            i.putExtra("low_points", lowplus)
            i.putExtra("high_points", highplus)

            if(binding.taxi.isChecked) {
                i.putExtra("taxi", true)
            }
            else {
                i.putExtra("taxi", false)
            }
            startActivity(i)


        }

    }
}