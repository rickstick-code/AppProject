package com.example.justplanit.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.justplanit.*
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



        //sample data for recyclerView
        val progressSample = mutableListOf<Fortschritt>()
        progressSample.add(Fortschritt(0,Date(),1,1,1))
        progressSample.add(Fortschritt(1,Date(),2,2,5))
        progressSample.add(Fortschritt(2,Date(),2,2,5))
        progressSample.add(Fortschritt(3,Date(),2,2,5))
        progressSample.add(Fortschritt(4,Date(),2,2,5))
        progressSample.add(Fortschritt(5,Date(),2,2,5))
        progressSample.add(Fortschritt(6,Date(),2,2,5))
        progressSample.add(Fortschritt(7,Date(),2,2,5))
        progressSample.add(Fortschritt(8,Date(),2,2,5))
        progressSample.add(Fortschritt(9,Date(),2,2,5))
        progressSample.add(Fortschritt(10,Date(),2,2,5))
        progressSample.add(Fortschritt(11,Date(),2,2,5))
        progressSample.add(Fortschritt(12,Date(),2,2,5))
        progressSample.add(Fortschritt(13,Date(),2,2,5))
        progressSample.add(Fortschritt(14,Date(),2,2,5))
        progressSample.add(Fortschritt(15,Date(),2,2,5))



        // create recycler view
        val recyclerView = root.findViewById<RecyclerView>(R.id.progress_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ProgressAdapter(progressSample) //   GetSqlData.selFortschritt() ?


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