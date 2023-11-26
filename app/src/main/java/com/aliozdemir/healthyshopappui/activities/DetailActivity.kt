package com.aliozdemir.healthyshopappui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliozdemir.healthyshopappui.adapters.SimilarAdapter
import com.aliozdemir.healthyshopappui.databinding.ActivityDetailBinding
import com.aliozdemir.healthyshopappui.domains.ItemsDomain
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var similarAdapter: SimilarAdapter
    private lateinit var receivedObject: ItemsDomain
    private lateinit var itemsList: ArrayList<ItemsDomain>
    private var weight = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val similarLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.similarView.layoutManager = similarLayoutManager

        getBundles()
        setVariable()
        initSimilarList()
    }

    private fun getBundles() {
        receivedObject = intent.getSerializableExtra("object") as ItemsDomain
    }

    private fun setVariable() {
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val resourceId = binding.root.context.resources.getIdentifier(
            receivedObject.imgPath,
            "drawable",
            binding.root.context.packageName
        )

        Glide.with(binding.imag.context)
            .load(resourceId)
            .into(binding.imag)

        binding.priceKgText.text = "$" + receivedObject.price.toString() + "/kg"
        binding.titlText.text = receivedObject.title
        binding.ratingBar.rating = receivedObject.rate
        binding.ratingText.text = receivedObject.rate.toString()
        binding.descriptionText.text = receivedObject.description
        binding.totalText.text = "$" + receivedObject.price.toString()

        binding.plusButton.setOnClickListener {
            weight = weight + 1
            binding.weightText.text = weight.toString() + " kg"
            binding.totalText.text = "$" + (weight * receivedObject.price).toString()
        }

        binding.minusButton.setOnClickListener {
            if (weight > 1) {
                weight = weight - 1
            }
            binding.weightText.text = weight.toString() + " kg"
            binding.totalText.text = "$" +(weight * receivedObject.price).toString()
        }
    }

    private fun initSimilarList() {
        itemsList = intent.getSerializableExtra("itemsList") as ArrayList<ItemsDomain>
        similarAdapter = SimilarAdapter(itemsList)
        binding.similarView.adapter = similarAdapter
    }

}