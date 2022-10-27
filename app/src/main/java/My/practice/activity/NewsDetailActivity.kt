package My.practice.activity

import My.practice.databinding.ActivityNewsDetailBinding
import My.practice.model.Article
import My.practice.utils.ResponseStatus
import My.practice.viewmodel.RandomNewsViewModel
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding
    private val viewModel: RandomNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val article = intent.getParcelableExtra<Article>("article")
        if (article != null){
            Glide.with(binding.newsImage.context).load(article.urlToImage).into(binding.newsImage)
            binding.newsTitle.text = article.title
            binding.newsAuthor.text = article.author
            binding.newsDesc.text = article.description
            binding.newsPublished.text = article.publishedAt
        }

        binding.btnFavorites.setOnClickListener {
            viewModel.insertNewsLiveData(article)
        }
        setObserver()
    }

    private fun setObserver() {
        viewModel.getInsertNewsLiveData().observe(this) {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    Toast.makeText(
                        this@NewsDetailActivity, "Success insert data",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                ResponseStatus.ERROR -> {
                    Toast.makeText(
                        this@NewsDetailActivity, it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {}
            }
        }
    }
}