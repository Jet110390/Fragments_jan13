package com.example.fragments_jan13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments_jan13.databinding.FragmentInfoBinding

class InfoFragment: Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            thirdBackButton.setOnClickListener{
                val bundle = Bundle()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, NameFragment::class.java,bundle)
                    .addToBackStack(null)
                    .commit()
            }

            firstNameTv.text = arguments?.getString("First Name") ?: "First Name"
            surnameTv.text = arguments?.getString("Surname") ?: "Surname"
            emailTv.text = arguments?.getString("Email") ?: "Email"
            passwordTv.text = arguments?.getString("Password") ?: "Password"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}