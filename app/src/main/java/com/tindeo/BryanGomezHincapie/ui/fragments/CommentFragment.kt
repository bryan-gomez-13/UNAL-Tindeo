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


class CommentFragment : Fragment() {

    private var _binding : FragmentCommentBinding? = null
    private val binding get() = _binding!!

    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentManager: LinearLayoutManager

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
        commentAdapter = CommentAdapter(
            listOf(
                Comment("1","Bryan Gomez","Good store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","27-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",70,10,5),
                Comment("2","Carlos Vesga","Bad store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","26-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",10,70,1),
                Comment("3","Sisa","So so store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","25-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",50,50,3)
            )
        )
        commentManager = LinearLayoutManager(requireContext())
        binding.commentRecycler.apply {
            adapter = commentAdapter
            layoutManager = commentManager
        }
    }


}