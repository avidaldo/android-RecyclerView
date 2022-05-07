package com.example.android_recyclerview

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_recyclerview.databinding.ElementoBinding
import com.example.android_recyclerview.databinding.FragmentEj01bBinding


class Ej02Fragment : Fragment() {
    private var _binding: FragmentEj01bBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEj01bBinding.inflate(inflater, container, false)

        val lenguajes: List<String> =
            ArrayList(resources.getStringArray(R.array.lenguajes).asList())

        with(binding.recyclerView1) {
            adapter = Custom2Adapter(lenguajes)
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    class Custom2Adapter(private val listadoDatos: List<String>) :
        RecyclerView.Adapter<Custom2Adapter.ViewHolder>() {


        /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
        class ViewHolder(binding: ElementoBinding) : RecyclerView.ViewHolder(binding.root) {
            val textView = binding.tvElemento

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
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ElementoBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

        /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
         * cada elemento */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = listadoDatos[position]

            /* Modificamos el diseño de cada elemento en función de su posición */
            if (position % 2 == 0) { // Si la posición de la fila es par
                with(holder.textView) {
                    setBackgroundColor(Color.CYAN)
                    setTextColor(Color.BLUE)
                    gravity = Gravity.START
                }
            } else { // Si la posición es impar
                holder.textView.setBackgroundColor(Color.TRANSPARENT)
                holder.textView.setTextColor(Color.BLUE)
                holder.textView.gravity = Gravity.END
            }

        }

        override fun getItemCount(): Int {
            return listadoDatos.size
        }
    }


}