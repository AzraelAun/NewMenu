package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentCompletePracticalBinding

/**
 * A simple [Fragment] subclass.
 */
class CompletePractical : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCompletePracticalBinding>(inflater,
            R.layout.fragment_complete_practical,container,false)

        return binding.root

    }


}
