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

        val today = LocalDate.now()
        val tomorrow = today.plusDays(1)

        textView5.text = today.toString()

        viewModel.getForecast("This is a description","temp", "2026-07-30 15:00:00")
        viewModel.forecast.observe(viewLifecycleOwner){
            textView5.text = viewModel.forecast.value?.list[0]?.main?.temp.toString()


        }
    }
}