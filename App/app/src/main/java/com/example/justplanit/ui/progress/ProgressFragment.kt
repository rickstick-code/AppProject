package com.example.justplanit.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justplanit.Fortschritt
import com.example.justplanit.ProgressAdapter
import com.example.justplanit.R
import com.example.justplanit.SqlDatabase
import com.example.justplanit.databinding.FragmentProgressBinding
import java.util.*


class ProgressFragment : Fragment()  {

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
            ViewModelProvider(this)[ProgressViewModel::class.java]

        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        val root: View = binding.root


        setAdapter(root.findViewById(R.id.progress_recycler_view))

        root.findViewById<Button>(R.id.progress_add).setOnClickListener {
            Toast.makeText(requireContext().applicationContext,"A new resolution was created",Toast.LENGTH_SHORT).show()
            SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData.insFortschritt(
                Fortschritt(
                    datum = Date(),
                    aktivitaet = SqlDatabase.getDatabase(requireContext().applicationContext).
                        getSqlData.selAktivitaet(root.findViewById<TextView>(R.id.item_progress_activity).text.toString()),
                    metrik = SqlDatabase.getDatabase(requireContext().applicationContext).
                        getSqlData.selMetrik(root.findViewById<TextView>(R.id.item_progress_metric).text.toString()),
                    zielmenge = root.findViewById<TextView>(R.id.progress_amount).text.toString().toInt())
            )
            setAdapter(root.findViewById(R.id.progress_recycler_view))
        }

        //Um den Aktvität-Spinner aufzufüllen
        root.findViewById<Spinner>(R.id.progress_activity).adapter = ArrayAdapter(
            requireContext().applicationContext,
            android.R.layout.simple_spinner_item,
            SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData.selAktivitaet().map { it.bezeichnung })


        //Um den Metrik-Spinner aufzufüllen
        root.findViewById<Spinner>(R.id.progress_unit).adapter = ArrayAdapter(
            requireContext().applicationContext,
            android.R.layout.simple_spinner_item,
            SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData.selMetrik().map { it.einheit })

        return root
    }

    private fun setAdapter(recyclerView: RecyclerView){
        val progressAdapter = ProgressAdapter(SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData.selFortschritte())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = progressAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}