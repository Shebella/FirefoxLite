package org.mozilla.rocket.urlinput

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.search_portal_item.view.search_portal_img
import org.mozilla.focus.R

class SearchPortalAdapter(private val clickListener: (SearchPortal) -> Unit) : ListAdapter<SearchPortal, SearchPortalAdapter.PortalViewHolder>(SearchPortalDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): PortalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.search_portal_item, parent, false)
        return PortalViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: PortalViewHolder, i: Int) {
        viewHolder.bind(getItem(i), clickListener)
        (viewHolder as? PortalViewHolder)?.icon?.setImageResource(R.drawable.youtube)
    }

    class PortalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icon: ImageView = itemView.search_portal_img

        fun bind(item: SearchPortal, clickListener: (SearchPortal) -> Unit) {
            icon.setImageResource(item.iconResId)
            itemView.setOnClickListener { clickListener(item) }
        }
    }
}
