package com.example.fragments_jan13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragments_jan13.databinding.FragmentNameBinding

class NameFragment: Fragment() {
    private var _binding: FragmentNameBinding? = null

    private val binding: FragmentNameBinding get( )= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            firstButton.setOnClickListener{
                val firstName=firstNameEt.editText?.text.toString()
                val surname= surnameEt.editText?.text.toString()
                val bundle = Bundle()
                bundle.putString("First Name", firstName)
                bundle.putString("Surname", surname)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, EmailFragment::class.java,bundle)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}