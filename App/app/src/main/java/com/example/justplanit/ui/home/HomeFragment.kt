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
import androidx.room.Room
import com.example.justplanit.*
import com.example.justplanit.databinding.FragmentHomeBinding
import java.util.Date

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null


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

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

         */

        // Button for creating a new resolution
        val button: Button = root.findViewById(R.id.home_resolution_create)
        button.setOnClickListener {
            val intent = Intent(activity, CreateResolutionActivity::class.java)
            activity?.startActivity(intent)
        }

        // Creating and filling the ListView with current resolutions
        val resolutionList:ListView = root.findViewById(R.id.home_listview)


        //database tests
        //val db = SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData
        //val db2 = Room.databaseBuilder(requireContext().applicationContext, SqlDatabase::class.java, "db").build()
        //db.insVorsatz(Vorsatz(0,"spazieren gehen",2,3,Date(),6,2,true))
        //db.insVorsatz(Vorsatz(0,"fitnessstudio gehen",2,3,Date(),6,2,true))
        //val resolutions2: Array<String> =  db2.getSqlData.selVorsatzBez() ?: arrayOf("asv","asdasd") //not working, maybe be
        //Log.e("test",resolutions2[0])


        val resolutions: Array<String> = arrayOf("asdsdfa","asddsggdfs")
        val resolutionAdapter:ArrayAdapter<String>  = ArrayAdapter(requireContext().applicationContext,android.R.layout.simple_list_item_1,resolutions)
        resolutionList.adapter = resolutionAdapter

        resolutionList.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(activity,ViewResolutionActivity::class.java)
            intent.putExtra("Resolution_id",adapterView.getItemAtPosition(i).toString()) // instead if "12345" use id of resolution from database
            activity?.startActivity(intent)
        }


        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}