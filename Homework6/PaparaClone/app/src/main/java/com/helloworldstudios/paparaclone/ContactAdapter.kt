package com.helloworldstudios.paparaclone

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.helloworldstudios.paparaclone.databinding.ContactDesignBinding

class ContactAdapter(var mContext: Context, var contactList: List<User>): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    inner class ContactHolder(binding: ContactDesignBinding): RecyclerView.ViewHolder(binding.root) {
        var binding: ContactDesignBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = ContactDesignBinding.inflate(layoutInflater, parent, false)
        return ContactHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        var user = contactList.get(position)
        val holderBinding = holder.binding

        holderBinding.userImage.setImageResource(mContext.resources.getIdentifier(user.userImageName, "drawable", mContext.packageName))
        holderBinding.tvUserName.text = user.userTitle
        holderBinding.tvUserPhoneNo.text = user.userPhoneNo
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}