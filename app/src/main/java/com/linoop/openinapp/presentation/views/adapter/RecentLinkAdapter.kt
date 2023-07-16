package com.linoop.openinapp.presentation.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linoop.openinapp.R
import com.linoop.openinapp.data.DashboardData
import com.linoop.openinapp.databinding.CardViewRecentLinkBinding

class RecentLinkAdapter: RecyclerView.Adapter<RecentLinkAdapter.RecentLinkViewHolder>() {

    private var data: List<DashboardData.Data.RecentLink> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentLinkViewHolder {
        return RecentLinkViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_recent_link, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecentLinkViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(productList: List<DashboardData.Data.RecentLink>) {
        this.data = productList
        notifyDataSetChanged()
    }

    inner class RecentLinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(recentLink: DashboardData.Data.RecentLink) {
            val bind = CardViewRecentLinkBinding.bind(itemView)
            bind.apply {
                name.text = recentLink.title
                link.text = recentLink.webLink
                createdAt.text = recentLink.createdAt
            }
        }

    }
}