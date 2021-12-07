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
import com.tindeo.BryanGomezHincapie.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class AddCommentFragment : Fragment() {

    private var _binding : FragmentAddCommentBinding? = null
    private val binding get() = _binding!!

    private val commentViewModel: CommentViewModel by viewModel()
    private val loginViewModel: LoginViewModel by viewModel()

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
        loginViewModel.loggedIn()
        events()
    }

    private fun events(){
        binding.buttonAddComment.setOnClickListener {
            //System.currentTimeMillis()
            //Date

            val date = Calendar.getInstance().time
            val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            val dateFormat2: DateFormat = SimpleDateFormat("yyyy-MM-dd")
            val strDate: String = dateFormat.format(date)
            val strDate2: String = dateFormat2.format(date)

            val  uid = loginViewModel.user.value


            commentViewModel.addComment(
                uid!!.uid,
                null,
                binding.addCommentTitleInput.text.toString(),
                binding.addCommentDescriptionInput.text.toString(),
                strDate2,
                null,
                0,
                0,
                binding.ratingBarAddComment.rating)
            Toast.makeText(requireContext(),"Comentario creado", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addCommentFragment_to_commentFragment)
        }
    }
}