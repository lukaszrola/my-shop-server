package com.rola.lukasz.myshop.offer.model

class ComponentInput(val name: String, val configuration: String) {

    fun toComponent():Component = Component(
        name = name,
        configuration = configuration
    )
}