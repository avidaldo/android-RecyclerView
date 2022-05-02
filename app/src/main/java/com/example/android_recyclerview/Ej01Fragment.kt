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
import com.example.android_recyclerview.databinding.FragmentEj01Binding
import java.util.*


class Ej01Fragment : Fragment() {
    private var _binding: FragmentEj01Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEj01Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lenguajes: List<String> =
            ArrayList(listOf(*resources.getStringArray(R.array.lenguajes)))

        binding.recyclerView1
            .apply {  // RecyclerView requiere utilizar un adaptador personalizado
                adapter = Custom1Adapter(lenguajes)
            }
            .apply {
                /* Seteamos el Layaout Manager, que es el que generará la distribución interna de la lista
                para el número de columnas que queramos. Para una única columna, se utiliza internamente
                un LinearLayout, generado por LinearLayoutManager; para varias, se utiliza GridLayout */
                layoutManager = LinearLayoutManager(requireContext());
                //layoutManager = GridLayoutManager(requireContext(), 3)
            }


    }


    class Custom1Adapter(private val listadoDatos: List<String>) :
        RecyclerView.Adapter<Custom1Adapter.ViewHolder>() {
        /** El constructor recibirá los datos que queramos que el adaptador vuelque a la lista  */


        /**
         * Método al que se llama cada vez que se crea uno de los elementos de la lista
         * Infla una vista definida en "R.layout.elemento" para cada elemento
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.elemento, parent, false)
            )
        }

        /**
         * Clase que describe la vista de cada elemento de la lista y su posición en esta.
         */
        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val textView: TextView

            init {

                // Aquí podemos setear un escuchador para cada elemento
                view.setOnClickListener { v ->
                    Toast.makeText(
                        view.context,
                        "Has elegido: " + (v as TextView).text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                textView = view.findViewById<View>(R.id.tv_elemento) as TextView
            }
        }

        /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
         * cada elemento
         */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = listadoDatos[position]
        }

        override fun getItemCount(): Int {
            return listadoDatos.size
        }
    }


}