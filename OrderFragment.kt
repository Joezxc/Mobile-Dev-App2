package com.example.app2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val appleButton: Button = view.findViewById(R.id.apple_smoothie_button)
        val grapeButton: Button = view.findViewById(R.id.grape_smoothie_button)
        val strawberryButton: Button = view.findViewById(R.id.strawberry_smoothie_button)
        val mangoButton: Button = view.findViewById(R.id.mango_smoothie_button)

        val orderListener = View.OnClickListener { v ->
            val smoothie = when (v.id) {
                R.id.apple_smoothie_button -> "Apple Smoothie"
                R.id.grape_smoothie_button -> "Grape Smoothie"
                R.id.strawberry_smoothie_button -> "Strawberry Smoothie"
                R.id.mango_smoothie_button -> "Mango Smoothie"
                else -> ""
            }
            Toast.makeText(activity, "Thank you for ordering $smoothie", Toast.LENGTH_SHORT).show()
            savePreference(smoothie)
        }

        appleButton.setOnClickListener(orderListener)
        grapeButton.setOnClickListener(orderListener)
        strawberryButton.setOnClickListener(orderListener)
        mangoButton.setOnClickListener(orderListener)

        return view
    }

    private fun savePreference(smoothie: String) {
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("com.example.app2.PREFERENCES", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Get the existing orders
        val existingOrders = sharedPreferences.getStringSet("orders", mutableSetOf()) ?: mutableSetOf()
        // Add the new order
        existingOrders.add(smoothie)
        // Save the updated orders
        editor.putStringSet("orders", existingOrders)
        editor.apply()
    }
}