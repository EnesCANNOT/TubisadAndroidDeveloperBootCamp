package com.helloworldstudios.paparaclone

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.helloworldstudios.paparaclone.databinding.ContactDesignBinding
import com.helloworldstudios.paparaclone.databinding.QuickLinkDesignBinding

class QuickLinkAdapter(var mContext: Context, var quickLinkList: List<User>): RecyclerView.Adapter<QuickLinkAdapter.QuickLinkHolder>() {
    inner class QuickLinkHolder(binding: QuickLinkDesignBinding): RecyclerView.ViewHolder(binding.root) {
        var binding: QuickLinkDesignBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickLinkHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = QuickLinkDesignBinding.inflate(layoutInflater, parent, false)
        return QuickLinkHolder(binding)
    }

    override fun onBindViewHolder(holder: QuickLinkHolder, position: Int) {
        var user = quickLinkList.get(position)
        val holderBinding = holder.binding

        holderBinding.userImage.setImageResource(mContext.resources.getIdentifier(user.userImageName, "drawable", mContext.packageName))
        holderBinding.userTitle.text = user.userTitle
    }

    override fun getItemCount(): Int {
        return quickLinkList.size
    }
}