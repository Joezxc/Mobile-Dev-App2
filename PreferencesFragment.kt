package com.example.app2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class PreferencesFragment : Fragment() {

    private lateinit var ordersTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_preferences, container, false)
        ordersTextView = view.findViewById(R.id.orders_text_view)
        loadPreferences()
        return view
    }

    private fun loadPreferences() {
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("com.example.app2.PREFERENCES", Context.MODE_PRIVATE)
        val orders = sharedPreferences.getStringSet("orders", setOf())?.toList() ?: listOf("No orders yet")
        ordersTextView.text = "Orders: \n${orders.joinToString("\n")}"
    }
}