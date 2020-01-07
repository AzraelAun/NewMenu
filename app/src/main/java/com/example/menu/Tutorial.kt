package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentTutorialBinding

/**
 * A simple [Fragment] subclass.
 */
class Tutorial: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTutorialBinding>(inflater,
            R.layout.fragment_tutorial,container,false)
        return binding.root

        }


}
