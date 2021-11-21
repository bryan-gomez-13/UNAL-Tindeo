package com.tindeo.BryanGomezHincapie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tindeo.BryanGomezHincapie.databinding.FragmentAccountOptionsBinding
import com.tindeo.BryanGomezHincapie.databinding.FragmentLoginBinding


class AccountOptionsFragment : Fragment() {
    private var _binding: FragmentAccountOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }


}