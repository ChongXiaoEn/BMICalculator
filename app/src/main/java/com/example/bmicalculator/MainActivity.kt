package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            try {
            buttonCalculate.setOnClickListener() {
                val txtWeight: String = editTextWeight.text.toString()
                val txtHeight: String = editTextHeight.text.toString()

                val weight: Double = txtWeight.toDouble()
                val height: Double = txtHeight.toDouble()

                val result: Double = weight / (height * height)

                txtResult.text = "%.2f".format(result)

                when {
                    result < 18.5 -> {
                        textViewBMI.text = "UnderWeight"
                        imageViewProfile.setImageResource(R.drawable.under)
                    }

                    result < 24.9 -> {
                        textViewBMI.text = "Normal"
                        imageViewProfile.setImageResource(R.drawable.normal)
                    }

                    else -> {
                        textViewBMI.text = "OverWeight"
                        imageViewProfile.setImageResource(R.drawable.over)
                    }
                }
            }
        }catch (ex:Exception)
        {
            val toast:Toast = Toast.makeText(this, "Invalid Input.",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0,0)
        }
            buttonReset.setOnClickListener(){
                editTextWeight.text.clear()
                editTextHeight.text.clear()
                textViewBMI.text = ""
                txtResult.text = ""
                imageViewProfile.setImageResource(R.drawable.empty)
                editTextWeight.requestFocus()
            }
        }

    }

