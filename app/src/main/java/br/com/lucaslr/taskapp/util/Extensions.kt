package br.com.lucaslr.taskapp.util

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.fragment.app.Fragment
import br.com.lucaslr.taskapp.R
import br.com.lucaslr.taskapp.databinding.BottonSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.initToolbar(toolbar: Toolbar) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    (activity as AppCompatActivity).title = ""
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressed()
    }

}

fun Fragment.showBottonSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String,
    onClick: () -> Unit = {}
){
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding: BottonSheetBinding = BottonSheetBinding.inflate(layoutInflater, null, false)

    binding.tvTitle.text = getText(titleDialog ?: R.string.text_title_warning)
    binding.tvMessage.text =  message
    binding.btnOk.text = getText(titleButton ?: R.string.text_button_warning)
    binding.btnOk.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()

}