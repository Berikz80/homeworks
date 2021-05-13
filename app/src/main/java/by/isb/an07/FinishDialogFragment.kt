package by.isb.an07

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class FinishDialogFragment(private val myTitle:String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder
            .setTitle(myTitle)
            .setIcon(R.drawable.corn)
            .setPositiveButton("OK", null)
            .create()
    }
}