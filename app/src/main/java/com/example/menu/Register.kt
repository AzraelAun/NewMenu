package com.example.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.menu.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * A simple [Fragment] subclass.
 */
class Register : Fragment() {

    lateinit var handler: AccDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)

        handler = AccDatabase(binding.root.context)

        binding.textView5.setOnClickListener(){

            view?.findNavController()?.navigate(R.id.action_register_to_login)

        }

        binding.signButton.setOnClickListener {
            if(binding.username.text.toString().isNotEmpty()){
                if (handler.verifyUsername(binding.username.text.toString())) {
                    if (binding.pass.text.toString().isNotEmpty()) {
                       if (binding.pass.text.toString() == binding.password.text.toString()) {
                           if (binding.email.text.toString().isNotEmpty() && binding.phone.text.toString().isNotEmpty() && binding.address.text.toString().isNotEmpty()) {
                               handler.insertUserData(username.text.toString(), pass.text.toString(), email.text.toString(),phone.text.toString(), address.text.toString())
                               Toast.makeText(activity, "Register Successful", Toast.LENGTH_SHORT).show()
                               view?.findNavController()?.navigate(R.id.action_register_to_login)
                           } else {
                            Toast.makeText(activity, "Cannot be empty", Toast.LENGTH_SHORT).show()
                           }
                       } else
                            Toast.makeText(activity, "Incorrect Confirm Password", Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(activity, "Password cannot be empty", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(activity, "Username Been Used", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(activity, "Username cannot be empty", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}
