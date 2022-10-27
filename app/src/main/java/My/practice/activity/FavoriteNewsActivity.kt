package My.practice.activity

import My.practice.databinding.ActivityFavoriteNewsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FavoriteNewsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}