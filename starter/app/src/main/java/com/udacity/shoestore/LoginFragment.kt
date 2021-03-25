package com.udacity.shoestore

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var sharePrefs: SharedPreferences

    companion object {
        val EMAIL = "test@gmail.com"
        val PASSWORD = "test"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        sharePrefs = requireActivity().getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)

        binding.login.setOnClickListener { view: View ->

            val email = binding.emailLabel.editText?.text.toString()
            val password = binding.passwordTextLabel.editText?.text.toString()

            if (login(email, password)) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragment4ToWelcomeFragment())

                with(sharePrefs.edit()) {
                    this?.putString("email", email)
                    this?.putString("password", password)
                    this?.apply()
                }
            }

        }

        return binding.root
    }

    private fun login(email: String, password: String) : Boolean {
        return if (email == EMAIL && password == PASSWORD) {
            true
        } else {
            Toast.makeText(context, "Incorrect login", Toast.LENGTH_SHORT).show()
            false
        }
    }

    override fun onStart() {
        super.onStart()

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)

        val email = sharedPref?.getString("email", "test@gmail.com ")
        val password = sharedPref?.getString("password", "test")

        if (email.equals(EMAIL) && password.equals(PASSWORD)) {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment2())
        }
    }
}