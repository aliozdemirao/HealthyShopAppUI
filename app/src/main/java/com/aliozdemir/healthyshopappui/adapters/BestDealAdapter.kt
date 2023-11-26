package com.aliozdemir.healthyshopappui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliozdemir.healthyshopappui.activities.DetailActivity
import com.aliozdemir.healthyshopappui.databinding.ViewholderBestDealBinding
import com.aliozdemir.healthyshopappui.domains.ItemsDomain
import com.bumptech.glide.Glide

class BestDealAdapter(private val items: ArrayList<ItemsDomain>) : RecyclerView.Adapter<BestDealAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderBestDealBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewholderBestDealBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceText.text = "$" + items[position].price.toString() + "/kg"

        val resourceId = getResourceIdByName(holder.binding.root.context, items[position].imgPath)

        Glide.with(holder.binding.image.context)
            .load(resourceId)
            .into(holder.binding.image)

        holder.binding.image.setOnClickListener {
            val intent = Intent(holder.binding.image.context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            intent.putExtra("itemsList", items)
            holder.binding.image.context.startActivity(intent)
        }

    }

    private fun getResourceIdByName(context: Context, name: String): Int {
        return context.resources.getIdentifier(name, "drawable", context.packageName)
    }

}