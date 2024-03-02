package com.appdev.contactlistapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdev.contactlistapp.R
import com.appdev.contactlistapp.models.Result
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(
    private val context: Context, private val listener: RecyclerViewEvent,
    private val userList: List<Result?>?
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    // ViewHolder class to create instances of the xml layout
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val userName: TextView
        val userPhoneNumber: TextView
        val userImage: ImageView

        init {
            userName = itemView.findViewById(R.id.userName)
            userPhoneNumber = itemView.findViewById(R.id.userPhoneNumber)
            userImage = itemView.findViewById(R.id.userImage)
            itemView.setOnClickListener(this)
        }

        // to handle click on contact cards
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if( position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }

    }


    // Implementing methods of RecyclerView interface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.contact_card, parent, false)
        return ViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return userList!!.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentUser = userList?.get(position)

        holder.userName.text = currentUser!!.fullName

        //Log.d("UserName", currentUser!!.fullName.toString())
        //Log.d("UserName2", holder.userName.toString())

        holder.userPhoneNumber.text = currentUser!!.phoneNumber
        Picasso.get().load(currentUser!!.image).placeholder(R.drawable.baseline_account_circle_24).into(holder.userImage)

    }

    // new interface for the click item function
    interface RecyclerViewEvent{
        fun onItemClick(position: Int)
    }

}