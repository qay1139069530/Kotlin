package com.qbase.kotlin.bean

class Person(name: String, age: Int) : Animal(name) {


    var address: String =""

        get() = field.toLowerCase()
        set(value) {
            field = "Name:$value"
        }


}