package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentAboutUsBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutUs : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutUsBinding>(inflater,
            R.layout.fragment_about_us,container,false)
        return binding.root
    }


}
