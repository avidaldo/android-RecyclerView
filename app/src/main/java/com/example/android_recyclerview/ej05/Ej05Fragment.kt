package com.example.android_recyclerview.ej05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_recyclerview.Ej01aFragment
import com.example.android_recyclerview.Ej03Fragment
import com.example.android_recyclerview.LenguajeProg
import com.example.android_recyclerview.R
import com.example.android_recyclerview.databinding.FragmentEj04Binding
import java.util.ArrayList


class Ej05Fragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {



        val view = inflater.inflate(R.layout.fragment_ej01a, container, false)

        if (view is RecyclerView) {
            with(view) {  // RecyclerView requiere utilizar un adaptador personalizado
                adapter = Custom5Adapter(getData())

                /* Seteamos el Layout Manager, que es el que generará la distribución interna de la lista
                para el número de columnas que queramos. Para una única columna, se utiliza internamente
                un LinearLayout, generado por LinearLayoutManager; para varias, se utiliza GridLayout */
                layoutManager = LinearLayoutManager(requireContext());
                //layoutManager = GridLayoutManager(requireContext(), 3)
            }
        }

        return view
    }

}