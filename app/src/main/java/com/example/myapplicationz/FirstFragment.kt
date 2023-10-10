package com.example.myapplicationz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplicationz.databinding.FragmentFirstBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    // private var count = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToast.setOnClickListener {
            val myToast = Toast.makeText(context, "Hello Toast", Toast.LENGTH_LONG)
            myToast.show()
        }
        binding.btnRandom.setOnClickListener {
            val lastNumber = binding.counttext.text.toString().toInt()

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(lastNumber)
             findNavController().navigate(action)
        }

        binding.btnCount.setOnClickListener {
            //count++
            //binding.counttext.text = count.toString()

            Count(binding)
        }




    }
    fun  Count(binding: FragmentFirstBinding){
        val num= binding.counttext.text.toString()
        val count = num.toInt() +1
        binding.counttext.text=count.toString()    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
