package com.example.quickjobapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quickjobapp.Model.AddPostModel
import com.example.quickjobapp.R

class JobAdapter (private val jobList: ArrayList<AddPostModel>) :
    RecyclerView.Adapter<JobAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.job_item,
        parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JobAdapter.ViewHolder, position: Int) {
        val currentList = jobList[position]

        holder.location.text = currentList.location
        holder.title.text = currentList.title
        holder.role.text = currentList.role
        holder.description.text = currentList.description
        holder.salary.text = currentList.salary
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val location : TextView = itemView.findViewById(R.id.tvLocation)
        val title : TextView = itemView.findViewById(R.id.tvTitle)
        val role : TextView = itemView.findViewById(R.id.tvRole)
        val description : TextView = itemView.findViewById(R.id.tvDescription)
        val salary : TextView = itemView.findViewById(R.id.tvSalary)

    }


}

