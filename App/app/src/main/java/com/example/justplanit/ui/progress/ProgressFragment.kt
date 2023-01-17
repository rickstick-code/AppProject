package com.example.justplanit.ui.progress

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justplanit.ProgressAdapter
import com.example.justplanit.R
import androidx.room.Room
import com.example.justplanit.Fortschritt
import com.example.justplanit.R
import com.example.justplanit.SqlDatabase
import com.example.justplanit.databinding.FragmentProgressBinding
import java.util.*

class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dashboardViewModel =
            ViewModelProvider(this).get(ProgressViewModel::class.java)

        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // create recycler view
        /*
        val recyclerView = root.findViewById<RecyclerView>(R.id.progress_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ProgressAdapter("Test")  //replace with progress class

         */

        binding.progressAdd.setOnClickListener {
            SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData.insFortschritt(
                Fortschritt(0, Date(),0,0, binding.progressAmount.text.toString().toInt())
            )
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}