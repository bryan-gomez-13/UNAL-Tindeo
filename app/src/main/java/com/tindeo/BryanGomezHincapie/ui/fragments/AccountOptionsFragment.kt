package com.tindeo.BryanGomezHincapie.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tindeo.BryanGomezHincapie.R
import com.tindeo.BryanGomezHincapie.databinding.FragmentAccountOptionsBinding
import com.tindeo.BryanGomezHincapie.databinding.FragmentLoginBinding
import com.tindeo.BryanGomezHincapie.ui.activities.HomeActivity
import com.tindeo.BryanGomezHincapie.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AccountOptionsFragment : Fragment() {
    private var _binding: FragmentAccountOptionsBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountOptionsBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onStart() {
        super.onStart()
        observeViewModels()
        binding.RegisterRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            binding.RegisterScrollCli.isVisible = binding.RegisterRolCli.isChecked
            binding.RegisterScrollStore.isVisible = binding.RegisterRolStore.isChecked
        }
        binding.singUpButton.setOnClickListener{
            loginViewModel.singUp(binding.CliCorreoTextInput.text.toString(),binding.CliNombreTextInput.text.toString(),binding.CliPassTextInput.text.toString())
        }
    }

    private fun observeViewModels(){
        loginViewModel.user.observe(viewLifecycleOwner, Observer{ user ->
            if(user != null){
                findNavController().navigate(R.id.action_accountOptionsFragment_to_loginFragment)
            }

        })
        loginViewModel.error.observe(viewLifecycleOwner,Observer{error->
            Toast.makeText(requireContext(),error, Toast.LENGTH_LONG).show()
        })
    }
}