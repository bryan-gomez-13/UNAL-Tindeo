package com.tindeo.BryanGomezHincapie.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tindeo.BryanGomezHincapie.ui.activities.HomeActivity
import com.tindeo.BryanGomezHincapie.R
import com.tindeo.BryanGomezHincapie.databinding.FragmentLoginBinding
import com.tindeo.BryanGomezHincapie.isValidEmail


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.singUpButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_accountOptionsFragment)
        }
        binding.loginButton.setOnClickListener {
            var isValid = true
            /*
            if(!binding.loginEmail.text.isValidEmail()){
                isValid = false
                binding.loginEmailLayout.error = "Correo electronico no valido"
            }else{
                binding.loginEmailLayout.error = null
            }

            if(binding.loginPassword.text.toString().length < 4){
                isValid = false
                binding.loginPasswordLayout.error = "Contraseña invalida"
            }else{
                binding.loginPasswordLayout.error = null
            }
            */
            if(isValid){
                //No deberia ser asi, ya que hace que haya fuerte acoplamiento
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}