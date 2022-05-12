package com.example.android_recyclerview.ej06

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_recyclerview.R


class Ej06Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
            with(view as RecyclerView) {
                layoutManager = LinearLayoutManager(context)
                adapter = Custom6Adapter(PlaceholderContent.ITEMS)
            }
        return view
    }


}
