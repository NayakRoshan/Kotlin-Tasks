package com.example.mytask2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mytask2.R

class DetailsFragment : Fragment() {

    lateinit var name : String
    private val bundleKeys : Array<String> = resources.getStringArray(R.array.bundle_keys)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = requireArguments().getString(bundleKeys[0]).toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val displayName : TextView = view.findViewById(R.id.displayName)
        displayName.text = name
    }
}