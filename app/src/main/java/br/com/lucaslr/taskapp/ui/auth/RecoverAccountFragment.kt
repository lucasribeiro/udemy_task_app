package br.com.lucaslr.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.lucaslr.taskapp.R
import br.com.lucaslr.taskapp.databinding.FragmentRecoverAccountBinding
import br.com.lucaslr.taskapp.util.initToolbar
import br.com.lucaslr.taskapp.util.showBottonSheet

class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)

        initListener()
    }

    private fun initListener(){
        binding.btnRecover.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        var email = binding.etEmail.text.toString()

        if(email.isEmpty()){
            showBottonSheet(message = getString(R.string.text_email_empty))
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