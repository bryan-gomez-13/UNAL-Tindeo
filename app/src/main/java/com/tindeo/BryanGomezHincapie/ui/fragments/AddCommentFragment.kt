package com.tindeo.BryanGomezHincapie.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.tindeo.BryanGomezHincapie.R
import com.tindeo.BryanGomezHincapie.databinding.FragmentAddCommentBinding
import com.tindeo.BryanGomezHincapie.ui.viewmodels.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class AddCommentFragment : Fragment() {

    private var _binding : FragmentAddCommentBinding? = null
    private val binding get() = _binding!!

    private val commentViewModel: CommentViewModel by viewModel()

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

            commentViewModel.addComment(binding.addCommentIdInput.text.toString(),
                null,
                binding.addCommentTitleInput.text.toString(),
                binding.addCommentDescriptionInput.text.toString(),
                "27-11-2021",
                null,
                0,
                0,
                binding.addCommentCalificacionInput.text.toString())
            Toast.makeText(requireContext(),"Comentario creado", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addCommentFragment_to_commentFragment)
        }
    }
}