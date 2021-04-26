package by.isb.an07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider

class HW5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw5)

        val loginButton = findViewById<Button>(R.id.login_button)
        val loginInput = findViewById<EditText>(R.id.input_login)
        val loginPassword = findViewById<EditText>(R.id.input_password)
        val loginPasswordLayout = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.input_password_layout)
        val loginInputLayout = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.input_login_layout)

        loginButton.setOnClickListener {
            var hasError = false
            if (loginInput.text.isEmpty()) {
                loginInputLayout.error = getString(R.string.login_empty)
                hasError = true
            }
            if (loginPassword.text.length<8) {
                loginPasswordLayout.error = getString(R.string.password_mim)
                hasError = true
            }
            if (!hasError) {
                LoginDialogFragment().show(supportFragmentManager,LoginDialogFragment.TAG)
            }
        }

        loginPassword.doOnTextChanged { text, start, before, count ->
            if (loginPasswordLayout.isErrorEnabled) loginPasswordLayout.error = null
        }

        loginInput.doOnTextChanged { text, start, before, count ->
            if (loginInputLayout.isErrorEnabled) loginInputLayout.error = null
        }

    }
}