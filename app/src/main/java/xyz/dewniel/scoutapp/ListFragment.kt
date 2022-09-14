package xyz.dewniel.scoutapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.navigation.fragment.findNavController
import xyz.dewniel.scoutapp.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private lateinit var teamArrayList: ArrayList<Team>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val team = arrayOf<Int>(3487, 1624, 3012)
        val totalPoints = arrayOf<Int>(20, 15, 10)
        val lowPoints = arrayOf<Int>(3, 10, 5)
        val highPoints = arrayOf<Int>(100, 20, 1)
        val climbPoints = arrayOf<Int>(15, 3, 0)

        teamArrayList = ArrayList()

        for( i in team.indices) {
            val section = Team(team[i], totalPoints[i], lowPoints[i], highPoints[i], climbPoints[i])
            teamArrayList.add(section)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}