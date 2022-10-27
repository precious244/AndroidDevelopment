package My.practice.activity

import My.practice.R
import My.practice.databinding.ActivityLoginBinding
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginbtn.setOnClickListener {

            val email = binding.tvemail.text.toString()
            val password = binding.tvpassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                binding.tvStatus.setTextColor(getColor(R.color.red))
                binding.tvStatus.visibility = View.VISIBLE
                binding.tvStatus.text = "Email or Password must be filled"
            } else {
                Toast.makeText(this@LoginActivity,
                    "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity,
                    NavActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

