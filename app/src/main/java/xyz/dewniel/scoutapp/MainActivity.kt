package xyz.dewniel.scoutapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import xyz.dewniel.scoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var teamArrayList: ArrayList<Team>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val team = arrayOf(3487, 1624, 3012)
        val totalPoints = arrayOf(20, 15, 10)
        val lowPoints = arrayOf(3, 10, 5)
        val highPoints = arrayOf(100, 20, 1)
        val climbPoints = arrayOf(15, 3, 0)

        teamArrayList = ArrayList()

        for( i in team.indices) {
            val section = Team(team[i], totalPoints[i], lowPoints[i], highPoints[i], climbPoints[i])
            teamArrayList.add(section)
        }

        binding.teamList.isClickable = true

    }

}