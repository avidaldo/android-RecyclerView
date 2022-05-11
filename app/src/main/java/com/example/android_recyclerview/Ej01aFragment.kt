package com.example.android_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_recyclerview.databinding.ElementoBinding
import java.util.*


class Ej01aFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val lenguajes: List<String> =
            ArrayList(resources.getStringArray(R.array.lenguajes).asList())

        val view = inflater.inflate(R.layout.fragment_ej01a, container, false)

        //if (view is RecyclerView) {
        with(view as RecyclerView) {  // RecyclerView requiere utilizar un adaptador personalizado
            adapter = Custom1Adapter(lenguajes)

            /* Seteamos el Layout Manager, que es el que generará la distribución interna de la lista
            para el número de columnas que queramos. Para una única columna, se utiliza internamente
            un LinearLayout, generado por LinearLayoutManager; para varias, se utiliza GridLayout */
            layoutManager = LinearLayoutManager(requireContext());
            //layoutManager = GridLayoutManager(requireContext(), 3)
        }
        // }

        return view
    }


    class Custom1Adapter(private val listadoDatos: List<String>) :
    /** El constructor recibirá los datos que queramos que el adaptador vuelque a la lista  */
        RecyclerView.Adapter<Custom1Adapter.ViewHolder>() {


        /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
        class ViewHolder(binding: ElementoBinding) : RecyclerView.ViewHolder(binding.root) {
            val textView = binding.root

            init {
                textView.setOnClickListener {
                    Toast.makeText(
                        binding.root.context,
                        "Has elegido: " + (it as TextView).text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        /** Método al que se llama cada vez que se crea uno de los elementos de la lista. */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ElementoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


        /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
         * cada elemento */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = listadoDatos[position]
        }

        override fun getItemCount(): Int {
            return listadoDatos.size
        }
    }


}