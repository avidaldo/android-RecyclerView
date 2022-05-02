package com.example.android_recyclerview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android_recyclerview.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listaEjemplos
            .apply {
                adapter = ArrayAdapter.createFromResource(
                    requireActivity(),
                    R.array.ejemplos,
                    android.R.layout.list_content
                )
            }
            .apply {
                onItemClickListener = onItemClickListener
            }


    }


    object onItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            Log.i("---","""OnItemSelectedListener:
                parent.selectedItem = ${parent?.selectedItem}
                parent?.getItemAtPosition(position) = ${parent?.getItemAtPosition(position)}
                (view as TextView).text = ${(view as TextView).text}
                position = $position
                id = $id
                """.trimIndent())

            parent?.findNavController()?.navigate(
                when (position) {
                    0 -> MainFragmentDirections.actionFirstFragmentToSecondFragment()
/*                                1 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj02OnItemSelectedFragment()
                                2 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj03FromArrayFragment()
                                3 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj04FromResourceFragment()
                                4 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj05FromArrayListFragment()
                                5 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj06Fragment()*/
                    else -> throw Exception("Ejemplo no existente")
                }
            )
        }

    }
}
