package com.aliozdemir.healthyshopappui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliozdemir.healthyshopappui.databinding.ViewholderSimilarBinding
import com.aliozdemir.healthyshopappui.domains.ItemsDomain
import com.bumptech.glide.Glide

class SimilarAdapter(private val items: ArrayList<ItemsDomain>) : RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderSimilarBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewholderSimilarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resourceId = getResourceIdByName(holder.binding.root.context, items[position].imgPath)

        Glide.with(holder.binding.ima.context)
            .load(resourceId)
            .into(holder.binding.ima)
    }

    private fun getResourceIdByName(context: Context, name: String): Int {
        return context.resources.getIdentifier(name, "drawable", context.packageName)
    }

}