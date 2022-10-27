package My.practice.activity

import My.practice.databinding.ActivityRandomNewsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class RandomNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvNews.layoutManager = LinearLayoutManager(this@RandomNewsActivity)
    }
}