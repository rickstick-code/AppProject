package com.example.justplanit.ui.achievements

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.justplanit.R
import com.example.justplanit.ViewAchievementActivity
import com.example.justplanit.databinding.FragmentAchievementsBinding

class AchievementsFragment : Fragment() {

    private var _binding: FragmentAchievementsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(AchievementsViewModel::class.java)

        _binding = FragmentAchievementsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        /*

        val textView: TextView = binding.textAchievements
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

         */

        // Creating and filling the ListView with achievements
        val achievementList: ListView = root.findViewById(R.id.achievements_listview)
        val achievements:Array<String> = arrayOf("Achievement 1","Achievement 2", "Achievement 3","Achievement 4")  // replace with achievements
        val achievementAdapter: ArrayAdapter<String> = ArrayAdapter(requireContext().applicationContext,android.R.layout.simple_list_item_1,achievements)
        achievementList.adapter = achievementAdapter

        achievementList.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(activity, ViewAchievementActivity::class.java)
            intent.putExtra("Achievement_id",adapterView.getItemAtPosition(i).toString()) // instead if "12345" use id of resolution from database
            activity?.startActivity(intent)
        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}