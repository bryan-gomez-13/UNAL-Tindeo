package com.tindeo.BryanGomezHincapie.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tindeo.BryanGomezHincapie.R
import com.tindeo.BryanGomezHincapie.databinding.FragmentAddCommentBinding
import com.tindeo.BryanGomezHincapie.databinding.FragmentCommentBinding
import com.tindeo.BryanGomezHincapie.ui.viewmodels.CommentViewModel
import com.tindeo.BryanGomezHincapie.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class AddCommentFragment : Fragment() {

    private var _binding : FragmentAddCommentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add_comment, container, false)
        _binding = FragmentAddCommentBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        events()
    }

    private fun events(){
        binding.buttonAddComment.setOnClickListener {

        }
    }
}