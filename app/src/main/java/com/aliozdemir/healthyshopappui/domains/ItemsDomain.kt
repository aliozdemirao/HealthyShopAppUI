package com.aliozdemir.healthyshopappui.domains

import java.io.Serializable

class ItemsDomain(
    val imgPath: String,
    val title: String,
    val price: Float,
    val description: String,
    val rate: Float
) : Serializable {}