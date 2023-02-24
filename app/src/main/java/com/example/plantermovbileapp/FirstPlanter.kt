package com.example.plantermovbileapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_first_planter.*


class FirstPlanter : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      return inflater.inflate(R.layout.fragment_first_planter, container, false)



    savePlanter1.setOnClickListener {
        Toast.makeText(SecondActivity(), "Settings are now configured", Toast.LENGTH_LONG).show()
    }



    }


 }
