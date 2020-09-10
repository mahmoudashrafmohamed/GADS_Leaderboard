package com.mahmoud_ashraf.gadsleaderboard.presentation.submit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mahmoud_ashraf.gadsleaderboard.R
import com.mahmoud_ashraf.gadsleaderboard.databinding.ActivitySubmitBinding
import com.mahmoud_ashraf.gadsleaderboard.presentation.utils.Resource

class SubmitActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmitBinding
    private val viewModel : SubmitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            openWarningDialog()
        }

        viewModel.submitLiveData.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {
                    Toast.makeText(this, "Please wait ...", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> it.data?.let { list ->
                    openSuccessDialog()
                }
                is Resource.Error -> {
                    Toast.makeText(
                        this,
                        "Something wrong is happened!",
                        Toast.LENGTH_SHORT
                    ).show()
                    openErrorDialog()
                }
            }
        })
    }

    private fun openErrorDialog() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.dialog_error, null)
        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            alertDialog.dismiss()
        }, 2000)
    }

    private fun openSuccessDialog() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.dialog_success, null)
        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            alertDialog.dismiss()
        }, 2000)
    }

    private fun openWarningDialog() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.dialog_warning, null)
        dialogBuilder.setView(dialogView)

        val closeButton: ImageButton = dialogView.findViewById(R.id.closeImageButton) as ImageButton

        val yesButton: Button = dialogView.findViewById(R.id.yesButton) as Button

        val dialog = dialogBuilder.create()
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()

        closeButton.setOnClickListener {
            dialog?.dismiss()
        }

        yesButton.setOnClickListener {
            dialog?.dismiss()
          viewModel.submit(email = binding.editTextTextEmailAddress.text.toString(),
          firstName = binding.firstNameEditText.text.toString(),
              lastName = binding.lastNameEditText.text.toString(),
              projectLink = binding.editTextLink.text.toString()
              )
        }
    }
}