package com.example.android_recyclerview.ej05

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_recyclerview.R
import com.example.android_recyclerview.databinding.Elemento6Binding

class Custom5Adapter(val listadoDatos: MutableList<LenguajeProg5>) : RecyclerView.Adapter<Custom5Adapter.ViewHolder>() {


    /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
    class ViewHolder(binding: Elemento6Binding) : RecyclerView.ViewHolder(binding.root) {
        val mView = binding.root
        val textView = binding.textView
        val imageView = binding.imageView
        val remove = binding.remove

        init {
            textView.setOnClickListener {
                Toast.makeText(binding.root.context,
                    "Has elegido: " + binding.textView.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        Elemento6Binding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = listadoDatos[position].nombre

        /* Utilizando la libreía externa Glide (https://bumptech.github.io/glide/) */
        Glide.with(holder.mView.context) // Busca en internet la ruta de una imagen
            .load(listadoDatos[position].uriImagen) // Indicamos una imagen local para usar mientras no se recupera la de Internet
            //.placeholder(R.drawable.generica) // Indicamos la vista de destino
            .into(holder.imageView)

        /* Modificamos el color de cada elemento en función de su posición */
        if (position % 2 == 0) {
            holder.mView.setBackgroundColor(Color.CYAN)
            holder.textView.setTextColor(Color.BLUE)
        } else {
            holder.mView.setBackgroundColor(Color.TRANSPARENT)
            holder.textView.setTextColor(Color.GRAY)
        }

        holder.textView.setOnClickListener {
            Toast.makeText(it.context,
                "Has elegido: " + (it as TextView).text,
                Toast.LENGTH_SHORT).show()
        }

        holder.imageView.setOnClickListener {
            Toast.makeText(it.context,
                "Logo de : " + holder.textView.text,
                Toast.LENGTH_SHORT).show()
        }

        holder.remove.setOnClickListener {
            listadoDatos.removeAt(position)
            // notificamos la eliminación del elemento
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, listadoDatos.size)
        }

    }

    override fun getItemCount(): Int = listadoDatos.size


}
