package com.example.justplanit.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.justplanit.*
import com.example.justplanit.databinding.FragmentHomeBinding
import java.util.Date

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    companion object {
        val RESOLUTION_ID = "RESOLUTION_ID"
        val RESOLUTION_VIEW = 1
    }


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // Button for creating a new resolution
        val button: Button = root.findViewById(R.id.home_resolution_create)
        button.setOnClickListener {
            val intent = Intent(activity, CreateResolutionActivity::class.java)
            activity?.startActivity(intent)
        }

        //sample data for recyclerView
        val resolutionSample = mutableListOf<Vorsatz>()
        resolutionSample.add(Vorsatz(1,"Tetst",1,1,Date(),1,2,true))
        resolutionSample.add(Vorsatz(3,"laufen",1,1,Date(),1,2,true))
        resolutionSample.add(Vorsatz(5,"fitness",1,1,Date(),1,2,true))


        val resAdapter = ResolutionAdapter(resolutionSample) {
            val intent = Intent(activity, ViewResolutionActivity::class.java)
            intent.putExtra(RESOLUTION_ID, it.id)
            startActivity(intent)
        }

        val recyclerView = root.findViewById<RecyclerView>(R.id.home_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = resAdapter

        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}