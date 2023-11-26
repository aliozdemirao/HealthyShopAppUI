package com.aliozdemir.healthyshopappui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliozdemir.healthyshopappui.adapters.BestDealAdapter
import com.aliozdemir.healthyshopappui.adapters.CategoryAdapter
import com.aliozdemir.healthyshopappui.databinding.ActivityMainBinding
import com.aliozdemir.healthyshopappui.domains.CategoryDomain
import com.aliozdemir.healthyshopappui.domains.ItemsDomain

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var bestDealAdapter: BestDealAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val catLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.catView.layoutManager = catLayoutManager

        val bestDealLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.bestView.layoutManager = bestDealLayoutManager

        initRecyclerViewCat()
        initLocation()
        initRecyclerViewBestDeal()
    }

    private fun initRecyclerViewCat() {
        val items: ArrayList<CategoryDomain> = ArrayList()

        items.add(CategoryDomain("cat1", "Vegetable"))
        items.add(CategoryDomain("cat2", "Fruits"))
        items.add(CategoryDomain("cat3", "Dairy"))
        items.add(CategoryDomain("cat4", "Drinks"))
        items.add(CategoryDomain("cat5", "Grain"))

        categoryAdapter = CategoryAdapter(items)
        binding.catView.adapter = categoryAdapter
    }

    private fun initLocation() {
        val items: ArrayList<String> = ArrayList()

        items.add("Las Vegas, United States")
        items.add("San Francisco, United States")
        items.add("Seattle, United States")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
            .also { it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        binding.spinner.adapter = adapter
    }

    private fun initRecyclerViewBestDeal() {
        getData()
    }

    private fun getData() {
        val items: ArrayList<ItemsDomain> = ArrayList()

        items.add(
            ItemsDomain(
                "pineaplle",
                "Fresh Pineapple",
                10f,
                "Transport yourself to the tropics with the exotic taste of pineapple. Juicy and tantalizingly sweet, this golden fruit is not only a delight for your taste buds, it's also a rich source of vitamins and enzymes, supports digestive health and adds sunshine to your day.",
                4.0f
            )
        )
        items.add(
            ItemsDomain(
                "orange",
                "Fresh Orange",
                6f,
                "With its vibrant orange hue and refreshing citrus flavor, juicy orange is a natural source of vitamin C, invigorates your senses and supports your immune system. A delightful snack that combines health and taste.",
                4.2f
            )
        )
        items.add(
            ItemsDomain(
                "apple",
                "Fresh Apple",
                7.5f,
                "Crisp and fleshy apples are nature's candy. Each bite offers a symphony of sweetness and a satisfying crunch. Packed with fiber and antioxidants, apples are a healthy snack and keep you energized all day long.",
                4.4f
            )
        )
        items.add(
            ItemsDomain(
                "watermelon",
                "Fresh Watermelon",
                5f,
                "Quench your thirst and satisfy your sweet tooth with the moisturizing goodness of watermelon. Juicy and full of vibrant color, this summer favorite is a natural way to cool down and refresh. Enjoy the taste of summer in every juicy bite.",
                3.5f
            )
        )
        items.add(
            ItemsDomain(
                "berry",
                "Fresh Cherry",
                4f,
                "Immerse yourself in the goodness of cherries, a delicious and nutritious delight. Whether enjoyed on their own or added to dishes, these vibrant flavors bring vitamin C, antioxidants and natural sweetness.",
                3.0f
            )
        )
        items.add(
            ItemsDomain(
                "strawberry",
                "Fresh Strawberry",
                12f,
                "Indulge in the goodness of strawberries, a delicious and nutritious delight. Whether enjoyed on their own or in dishes, these red gems offer vitamin C, antioxidants and natural sweetness.",
                5.0f
            )
        )

        bestDealAdapter = BestDealAdapter(items)
        binding.bestView.adapter = bestDealAdapter

    }

}