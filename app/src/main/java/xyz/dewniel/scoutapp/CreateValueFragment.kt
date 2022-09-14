package xyz.dewniel.scoutapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import xyz.dewniel.scoutapp.R.layout.activity_main
import xyz.dewniel.scoutapp.R.layout.fragment_create
import xyz.dewniel.scoutapp.databinding.FragmentCreateBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CreateValueFragment : Fragment() {

    private var _binding: FragmentCreateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.saveButton.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val teamNumber = binding.teamNumberInput.text
        val totalPoints = binding.totalScore.text
        val lowPoints = binding.lowScore.text
        val highPoints = binding.highScore.text
        val climbPoints = binding.climbScore.text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}