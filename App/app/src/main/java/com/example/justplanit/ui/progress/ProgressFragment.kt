package com.example.justplanit.ui.progress

<<<<<<< Updated upstream
import android.content.Context
=======
import android.graphics.Picture
>>>>>>> Stashed changes
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
<<<<<<< Updated upstream
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
=======
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
>>>>>>> Stashed changes
import com.example.justplanit.Fortschritt
import com.example.justplanit.ProgressAdapter
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

<<<<<<< Updated upstream
        binding.progressAdd.setOnClickListener {
=======
        setAdapter(root.findViewById<RecyclerView>(R.id.progress_recycler_view))

        root.findViewById<Button>(R.id.progress_add).setOnClickListener {
            Toast.makeText(requireContext().applicationContext,"A new resolution was created",Toast.LENGTH_SHORT).show()
>>>>>>> Stashed changes
            SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData.insFortschritt(
                Fortschritt(
                    datum = Date(),
                    aktivitaet = 0,
                    /*
                    metrik = SqlDatabase.getDatabase(requireContext().applicationContext).
                        getSqlData.selMetrik(root.findViewById<TextView>(R.id.item_progress_metric).text.toString()),
                     */
                    metrik = 0,
                    zielmenge = root.findViewById<TextView>(R.id.progress_amount).text.toString().toInt())
            )
        }
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