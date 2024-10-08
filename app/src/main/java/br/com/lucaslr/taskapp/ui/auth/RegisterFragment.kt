package br.com.lucaslr.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.lucaslr.taskapp.R
import br.com.lucaslr.taskapp.databinding.FragmentRegisterBinding
import br.com.lucaslr.taskapp.util.initToolbar
import br.com.lucaslr.taskapp.util.showBottonSheet

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)

        initListener()
    }

    private fun initListener(){

        binding.btnRegister.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()

        if(email.isEmpty()){
            showBottonSheet(message = getString(R.string.text_email_empty_register))
        }
        else if(password.isEmpty()){
            showBottonSheet(message = getString(R.string.text_password_empty_register))
        }
        else
        {
            Toast.makeText(requireContext(), "Tudo certo", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}