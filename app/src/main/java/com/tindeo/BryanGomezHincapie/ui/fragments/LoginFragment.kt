package com.tindeo.BryanGomezHincapie.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tindeo.BryanGomezHincapie.ui.activities.HomeActivity
import com.tindeo.BryanGomezHincapie.R
import com.tindeo.BryanGomezHincapie.databinding.FragmentLoginBinding
import com.tindeo.BryanGomezHincapie.isValidEmail
import com.tindeo.BryanGomezHincapie.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModels()
        binding.singUpButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_accountOptionsFragment)
        }
        binding.loginButton.setOnClickListener {
            var isValid = true

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

            if(isValid){
                loginViewModel.login(binding.loginEmail.text.toString(),binding.loginPassword.text.toString())
            }
        }
    }

    private fun observeViewModels(){
        loginViewModel.user.observe(viewLifecycleOwner, Observer{ user ->
            if(user != null){
                //No deberia ser asi, ya que hace que haya fuerte acoplamiento
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
            }

        })
        loginViewModel.error.observe(viewLifecycleOwner,Observer{error->
            Toast.makeText(requireContext(),error, Toast.LENGTH_LONG).show()
        })
    }
}