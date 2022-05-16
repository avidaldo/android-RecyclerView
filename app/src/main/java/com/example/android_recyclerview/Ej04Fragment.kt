package com.example.android_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_recyclerview.databinding.FragmentEj04Binding


class Ej04Fragment : Fragment() {
    private var _binding: FragmentEj04Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEj04Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonEj4.setOnClickListener {
            cargarLista()
            binding.recyclerView4.visibility=View.VISIBLE
        }


    }

    private fun cargarLista() {
        val lenguajes: MutableList<LenguajeProg> = ArrayList()
        lenguajes.add(LenguajeProg("Java", R.drawable.java))
        lenguajes.add(LenguajeProg("Kotlin", R.drawable.kotlin))
        lenguajes.add(LenguajeProg("JavaScript", R.drawable.javascript))
        lenguajes.add(LenguajeProg("Swift", R.drawable.swift))
        lenguajes.add(LenguajeProg("Python", R.drawable.python))
        lenguajes.add(LenguajeProg("PHP", R.drawable.php))
        lenguajes.add(LenguajeProg("C#", R.drawable.csharp))
        lenguajes.add(LenguajeProg("Go", R.drawable.go))
        lenguajes.add(LenguajeProg("Rust", R.drawable.rust))

        with(binding.recyclerView4) {
            adapter = Ej03Fragment.Custom3Adapter(lenguajes)
            layoutManager = LinearLayoutManager(requireContext())
        }

    }


}