package com.linoop.openinapp.presentation.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linoop.openinapp.R
import com.linoop.openinapp.data.DashboardData
import com.linoop.openinapp.databinding.CardViewTopLinkBinding

class TopLinkAdapter : RecyclerView.Adapter<TopLinkAdapter.UserListViewHolder>() {


    private var data: List<DashboardData.Data.TopLink> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListViewHolder {
        return UserListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_top_link, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(productList: List<DashboardData.Data.TopLink>) {
        this.data = productList
        notifyDataSetChanged()
    }

    inner class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(topLink: DashboardData.Data.TopLink) {
            val bind = CardViewTopLinkBinding.bind(itemView)
            bind.apply {
                name.text = topLink.title
                link.text = topLink.webLink
                createdAt.text = topLink.createdAt
            }
        }

    }
}