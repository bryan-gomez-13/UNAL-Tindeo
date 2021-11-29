package com.tindeo.BryanGomezHincapie.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tindeo.BryanGomezHincapie.ui.adaptares.CommentAdapter
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.databinding.FragmentCommentBinding
import com.tindeo.BryanGomezHincapie.ui.viewmodels.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CommentFragment : Fragment() {

    private var _binding : FragmentCommentBinding? = null
    private val binding get() = _binding!!

    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentManager: LinearLayoutManager

    //Atado al ciclo de vida del fragmento "viewModel()"
    private val commentViewModel: CommentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCommentBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        commentViewModel.loadComment()
        commentAdapter = CommentAdapter(
            listOf()
        )
        commentManager = LinearLayoutManager(requireContext())
        binding.commentRecycler.apply {
            adapter = commentAdapter
            layoutManager = commentManager
        }
        observeViewModel()
    }

    //Si hay nueva informacion la pintan
    private fun observeViewModel(){
        commentViewModel.comment.observe(viewLifecycleOwner, {comments ->
            commentAdapter.newDataSet(comments)
        })
    }

}