package com.tindeo.BryanGomezHincapie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tindeo.BryanGomezHincapie.databinding.FragmentCommentBinding


class CommentFragment : Fragment() {

    private var _binding : FragmentCommentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCommentBinding.inflate(inflater,container, false)
        return binding.root
    }


}