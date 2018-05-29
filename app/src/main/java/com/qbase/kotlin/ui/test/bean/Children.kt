package com.kotlin.kotlinapplication.bean

/**
 * Created by dell on 2017/1/11.
 */
class Children(name: String, age: Int) : Parent(name) {
    var name:String=""
    var age:Int=0
    init {
        this.name = name
        this.age = age
    }
}