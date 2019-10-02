package com.example.studentportal

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*


/*
 * An ArrayList of Portal objects is added to the class constructor
 * so the RecyclerView knows which Portal objects it needs to display.
 */
class PortalAdapter (private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    /*
     *  For the context variable the lateinit declaration has been used to let Kotlin
     *  know that this variable will be initialized later (in the onCreateViewHolder method).
     */
    lateinit var context: Context

    /*
     * In onCreateViewHolder a ViewHolder object is created which inflates the layout file we created (item_portal.xml).
     * We will be needing Context later on so a variable context is set.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_portal, parent, false)
        )
    }

    // Size of Portals.
    override fun getItemCount(): Int {
        return portals.size
    }

    // Bind method to bind the data to the ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    /*
     * The ViewHolders bind method uses kotlin synthetics to get the
     * references from the layout file for the ImageView and TextView.
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(portal: Portal) {
            itemView.btnAddedPortal.text = portal.portalName + "\n" + portal.portalUri
        }
    }
}
