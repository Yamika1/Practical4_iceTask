package com.example.practical4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.getValue

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var button2: Button

    public val viewModel : WeatherItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
            FragmentInitial()).commit()


        textView = findViewById<TextView>(R.id.textView)
        button = findViewById<Button>(R.id.button)
        button2 = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                FragmentWeatherToday()).addToBackStack(null).commit()
        }

        button2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                FragmentWeatherTomorrow()).addToBackStack(null).commit()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}