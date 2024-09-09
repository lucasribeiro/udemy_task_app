package br.com.lucaslr.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.lucaslr.taskapp.R
import br.com.lucaslr.taskapp.databinding.FragmentFormTaskBinding
import br.com.lucaslr.taskapp.databinding.FragmentRecoverAccountBinding
import br.com.lucaslr.taskapp.util.initToolbar
import br.com.lucaslr.taskapp.util.showBottonSheet

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)

        initListener()

    }

    private fun initListener(){
        binding.btnSave.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        var description = binding.edtDescription.text.toString()

       if(description.isEmpty()){
           binding.edtDescription.error = R.string.text_description_empty.toString()
           showBottonSheet(message = getString(R.string.text_description_empty))
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