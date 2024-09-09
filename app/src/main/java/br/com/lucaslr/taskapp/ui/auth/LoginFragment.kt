package br.com.lucaslr.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.lucaslr.taskapp.R
import br.com.lucaslr.taskapp.databinding.FragmentLoginBinding
import br.com.lucaslr.taskapp.util.showBottonSheet

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener(){
        binding.btnLogin.setOnClickListener {
            validateData()
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnRecover.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }
    }

    private fun validateData() {
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        
        if(email.isEmpty()){
            showBottonSheet(message = getString(R.string.text_email_empty))
        }
        else if(password.isEmpty()){
            showBottonSheet(message = getString(R.string.text_password_empty))
        }
        else
        {
            findNavController().navigate(R.id.action_global_homeFragment)
        }
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}