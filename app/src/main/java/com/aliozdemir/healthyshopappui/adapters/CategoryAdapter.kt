package com.aliozdemir.healthyshopappui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliozdemir.healthyshopappui.databinding.ViewholderCategoryBinding
import com.aliozdemir.healthyshopappui.domains.CategoryDomain
import com.bumptech.glide.Glide

class CategoryAdapter(private val items: ArrayList<CategoryDomain>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(val binding: ViewholderCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleText.text = items[position].title

        val resourceId = getResourceIdByName(holder.binding.root.context, items[position].imgPath)

        Glide.with(holder.binding.img.context)
            .load(resourceId)
            .into(holder.binding.img)
    }

    private fun getResourceIdByName(context: Context, name: String): Int {
        return context.resources.getIdentifier(name, "drawable", context.packageName)
    }

}