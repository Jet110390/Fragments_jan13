package com.example.fragments_jan13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.util.Log
import androidx.core.widget.addTextChangedListener

import com.example.fragments_jan13.databinding.FragmentPasswordBinding

class PasswordFragment: Fragment() {
    private var _binding: FragmentPasswordBinding? = null

    private val binding: FragmentPasswordBinding get( )= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            secondBackButton.setOnClickListener{
                activity?.supportFragmentManager?.popBackStack()
            }
            thirdButton.setOnClickListener{
                val password=passwordEt.editText?.text.toString()
                val bundle = Bundle()
                bundle.putString("First Name",arguments?.getString("First Name"))
                bundle.putString("Surname", arguments?.getString("Surname"))
                bundle.putString("Email", arguments?.getString("Email"))
                bundle.putString("Password", password)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, InfoFragment::class.java,bundle)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val TAG = PasswordFragment::class.java.name
    }
}