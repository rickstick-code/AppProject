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
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
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

        setAdapter(root.findViewById(R.id.home_recycler_view))

        parseJson()

        val motd: TextView = root.findViewById(R.id.home_motd)
        adviceFromApi(
            success = {
                motd.text = it.advice
            },
            error = {
                Log.w("Error", it)
                motd.text = "Never run a marathon in Crocs."
            }
        )

        return root
    }

    private fun parseJson() {
        val json = """
            {
                "slip":{
                    "id":127,
                    "advice":"When hugging, hug with both arms and apply reasonable, affectionate pressure."
                }
            }
        """
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<Advice>(Advice::class.java)
        val result = jsonAdapter.fromJson(json)
    }

    override fun onResume() {
        activity?.let { setAdapter(it.findViewById(R.id.home_recycler_view)) }
        super.onResume()
    }

    //Um den RecyclerView zu setzten
    private fun setAdapter(recyclerView: RecyclerView){
        //Um den Vorsatz anzuklicken
        val resolutionAdapter = ResolutionAdapter(SqlDatabase.getDatabase(requireContext().applicationContext).getSqlData.selVorsatz()) {
            val intent = Intent(activity, ViewResolutionActivity::class.java)
            intent.putExtra(RESOLUTION_ID, it.id)
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = resolutionAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun adviceFromApi(success: (lessonList: Slip) -> Unit, error: (errorMessage: String) -> Unit){
        AdviceApi.retrofitService.getAdvice().enqueue(object : Callback<Slip?> {
            override fun onResponse(call: Call<Slip?>, response: Response<Slip?>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    success(responseBody)
                } else {
                    error("Something went wrong")
                }
            }

            override fun onFailure(call: Call<Slip?>, t: Throwable) {
                error("The call failed")
            }
        })
    }
}