package My.practice.adapter

import My.practice.databinding.ItemJobBinding
import My.practice.databinding.ItemJoblistBinding
import My.practice.model.JoblistModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class JobAdapter (private val joblistList: ArrayList<JoblistModel>):
    RecyclerView.Adapter<JobAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemJobBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemJobBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joblist =  joblistList[position]
        with(holder) {
            binding.textjob.text = joblist.joblistName
            // show image from asset drawable
            binding.imjob.setImageResource(joblist.joblistImage)
            //show image from remote url
            binding.companyjob.text = joblist.jobCompany

        }
    }

    override fun getItemCount(): Int {
        return joblistList.size
    }

}