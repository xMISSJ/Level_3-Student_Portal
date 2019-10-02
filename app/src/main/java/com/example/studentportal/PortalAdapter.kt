package com.example.studentportal

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PortalAdapter(private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return portals.size
    }

/**
 * Called by RecyclerView to display the data at the specified position.
 */
override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(portals[position])
}

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val btnAddedPortal: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(portal: Portal) {
            btnAddedPortal.text = portal.portalName + "\n" +portal.portalUri
        }
    }
}
