package com.example.fragments_jan13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments_jan13.databinding.FragmentEmailBinding

class EmailFragment: Fragment() {

    private var _binding: FragmentEmailBinding? = null

    private val binding: FragmentEmailBinding get( )= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            firstBackButton.setOnClickListener {
                activity?.supportFragmentManager?.popBackStack()
            }

            secondButton.setOnClickListener{
                val email=emailEt.editText?.text.toString()
                val bundle = Bundle()
                bundle.putString("First Name",arguments?.getString("First Name"))
                bundle.putString("Surname", arguments?.getString("Surname"))
                bundle.putString("Email", email)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, PasswordFragment::class.java,bundle)
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