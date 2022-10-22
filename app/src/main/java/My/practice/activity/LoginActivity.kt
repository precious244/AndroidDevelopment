package My.practice.activity

import My.practice.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button = findViewById(R.id.loginbtn)

        button.setOnClickListener {
            Toast.makeText(
                this@LoginActivity, "Login Successful!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
