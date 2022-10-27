package My.practice.adapter

import My.practice.databinding.ItemNewsBinding
import My.practice.model.Article
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(
    private var newsModels: List<Article>,
    private val newsSelectedCallBack: NewsSelectedCallBack
    ):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    var onItemClick: ((Article) -> Unit)? = null

    inner class ViewHolder(var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                newsSelectedCallBack.onNewsSelected(newsModels[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsModel = newsModels[position]
        with(holder){
            Glide.with(binding.ivNews.context).load(newsModel.urlToImage).into(binding.ivNews)
            binding.tvName.text = newsModel.title
        }
    }

    override fun getItemCount(): Int {
        return newsModels.size
    }

    interface NewsSelectedCallBack{
        fun onNewsSelected(article: Article)
    }
}