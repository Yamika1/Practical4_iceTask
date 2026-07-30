package com.example.practical4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.time.LocalDate


class FragmentWeatherTomorrow : Fragment() {
    private lateinit var textView5: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_tomorrow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView5 = view.findViewById<TextView>(R.id.textView5)

        val viewModel = (requireActivity() as MainActivity).viewModel

        val tomorrow = LocalDate.now()


        textView5.text = tomorrow.toString()

        viewModel.getForecast("Pietermaritzburg", "units")
        viewModel.forecast.observe(viewLifecycleOwner) {



        }
    }
}