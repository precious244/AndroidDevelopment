package My.practice.activity

import My.practice.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.startbutton)

        button.setOnClickListener {
            Toast.makeText(
                this@MainActivity, "Clicked!",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }}
