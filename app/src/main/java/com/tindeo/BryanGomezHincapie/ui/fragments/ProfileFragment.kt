package com.tindeo.BryanGomezHincapie.ui.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.tindeo.BryanGomezHincapie.R
import com.tindeo.BryanGomezHincapie.databinding.FragmentProfileBinding
import com.tindeo.BryanGomezHincapie.ui.activities.MainActivity
import com.tindeo.BryanGomezHincapie.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception


class ProfileFragment : Fragment() {

    private var _binding:FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val REQUEST_CAMERA_PERMISSION = 1
    private val REQUEST_IMAGE = 2

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        loginViewModel.loggedIn()
        observeViewModels()
        checkPermission()
        events()
    }

    private fun events() {
        binding.profileImage.setOnClickListener{
            if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA )
                == PackageManager.PERMISSION_GRANTED){
                    //Solo si tengo los permisos lanza la actividad
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{ intent->
                    try{
                        startActivityForResult(intent,REQUEST_IMAGE)
                    }catch (e: Exception){

                    }
                }
            }
        }
        binding.profileLogOut.setOnClickListener{
            loginViewModel.logOut()
        }
    }
    private fun observeViewModels(){
        loginViewModel.user.observe(viewLifecycleOwner, Observer{ user ->
            if(user != null){
                binding.profileName.text = user!!.displayName
                binding.profileEmail.text  = user!!.email
                if(user!!.photoUrl!= null){
                    Glide.with(binding.root).load(user.photoUrl).into(binding.profileImage)
                }
            }else{
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }

        })
        loginViewModel.error.observe(viewLifecycleOwner,Observer{error->
            Toast.makeText(requireContext(),error, Toast.LENGTH_LONG).show()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Si resultado es correcto y el codigo de solitus request image es que ya tengo la imagen
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == REQUEST_IMAGE){
                //Convertir la imagen
                val bitmap = data?.extras?.get("data") as Bitmap
                // binding.profileImage.setImageBitmap(bitmap)
                loginViewModel.uploadImage(bitmap)
            }
        }
    }
    private fun checkPermission () {
        //Verificar permisos que si estan activa la camara y si no esta lo pide
        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA )
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION)
        }
    }

}