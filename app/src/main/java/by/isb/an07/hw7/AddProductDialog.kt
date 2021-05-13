package by.isb.an07.hw7

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import by.isb.an07.R
import by.isb.an07.database.entity.Product
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout


class AddProductDialog : DialogFragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(HW7ViewModel::class.java)
    }

    companion object {
        const val TAG = "product dialog"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Add New Product")
            .setView(R.layout.dialog_add_product)
            .setPositiveButton("Save", null)
            .create()
    }

    override fun onStart() {
        super.onStart()

        with(dialog as AlertDialog) {
            val inputName = findViewById<TextInputLayout>(R.id.input_product_name)
            val inputImage = findViewById<TextInputLayout>(R.id.input_product_image)
            val inputPrice = findViewById<TextInputLayout>(R.id.input_product_price)

            getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                if (hasError(inputName) &&
                    hasError(inputImage) &&
                    hasError(inputPrice)
                ) {
                    viewModel.insert(
                        Product(
                            inputName?.editText?.text.toString(),
                            inputPrice?.editText?.text.toString().toInt(),
                            inputImage?.editText?.text.toString()
                        )
                    )
                    dismiss()
                }
            }
        }
    }

    private fun hasError(textInputLayout: TextInputLayout?): Boolean {
        textInputLayout?.editText?.doOnTextChanged { text, start, before, count ->
            if (textInputLayout?.isErrorEnabled) textInputLayout?.error = null
        }
        return if (textInputLayout?.editText?.text.isNullOrEmpty()) {
            textInputLayout?.error = "Please enter text"
            textInputLayout?.isErrorEnabled = true
            false
        } else true
    }
}