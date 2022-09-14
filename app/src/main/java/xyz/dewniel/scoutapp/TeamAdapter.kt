package xyz.dewniel.scoutapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TeamAdapter(private val context : Activity, private val arrayList : ArrayList<Team>) : ArrayAdapter<Team>(context, R.layout.list_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // control of the viewing (the list and the visuals)
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item, null)

        // listing of the variables used by the lists (showing team, total, low, high, and climb
        val team : TextView = view.findViewById(R.id.teamName)
        val totalPoints : TextView = view.findViewById(R.id.editTotal)
        val lowPoints : TextView = view.findViewById(R.id.editLow)
        val highPoints : TextView = view.findViewById(R.id.editHigh)
        val climbPoints : TextView = view.findViewById(R.id.editClimb)

        // appending them into the Array List
        team.text = arrayList[position].team.toString()
        totalPoints.text = arrayList[position].totalPoints.toString()
        lowPoints.text = arrayList[position].lowPoints.toString()
        highPoints.text = arrayList[position].highPoints.toString()
        climbPoints.text = arrayList[position].climbPoints.toString()

        return view
    }
}