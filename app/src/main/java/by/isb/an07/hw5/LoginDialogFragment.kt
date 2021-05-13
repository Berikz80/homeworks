package by.isb.an07.hw5

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import by.isb.an07.R
import com.google.android.material.textfield.TextInputEditText

class LoginDialogFragment : DialogFragment() {

    companion object {
        val TAG = "LOGIN_DIALOG"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder
            .setTitle("Login successful")
            .setIcon(R.drawable.login)
            .setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                dismiss()
            }
            .setNegativeButton("Login") { dialogInterface: DialogInterface, i: Int ->

                val nameUser = requireActivity().findViewById<TextInputEditText>(R.id.input_login)
                val intent = Intent(context, HW5ActivityWelcome::class.java)
                intent.putExtra("NAME",nameUser.text.toString())
                startActivity(intent)
            }
            .create()
    }
}