package com.example.practical4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.time.LocalDate
import kotlin.collections.get


class FragmentWeatherToday : Fragment() {

    private lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView3 = view.findViewById<TextView>(R.id.textView3)

        val viewModel = (requireActivity() as MainActivity).viewModel

        val today = LocalDate.now()


        textView3.text = today.toString()


        viewModel.forecast.observe(viewLifecycleOwner){
            textView3.text = viewModel.forecast.value?.list[0]?.main?.temp.toString()
        }

    }
}