package com.example.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.menu.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.nav_header.*

/**
 * A simple [Fragment] subclass.
 */

class Login : Fragment() {

    lateinit var handler: AccDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)

        handler = AccDatabase(binding.root.context)

        binding.txtSignup.setOnClickListener(){

            view?.findNavController()?.navigate(R.id.action_login_to_register)

        }

        binding.loginbtn.setOnClickListener {

            if (login_username.text.toString().isNotEmpty() && login_pass.text.toString().isNotEmpty()) {
                if (handler.userLogin(login_username.text.toString(), login_pass.text.toString())) {
                    Toast.makeText(activity, "Login Successful", Toast.LENGTH_SHORT).show()
                    view?.findNavController()?.navigate(R.id.action_login_to_menu)
                    //var data = handler.retrieveData(login_username.text.toString())

                    //afterUsername.text = ""
                    //for (i in 0..(data.size - 1)) {
                    //afterUsername.append(data.get(i).username)
                    //}
                } else {
                Toast.makeText(activity, "Username Or Password Incorrect, Please enter again~", Toast.LENGTH_SHORT).show()
                }
            }else
               Toast.makeText(activity, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}
