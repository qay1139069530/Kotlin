package com.kotlin.kotlinapplication.bean

/**
 * Created by dell on 2017/1/16.
 */
class Person {

    var name: String = ""

        get() = field.toUpperCase()
        set(value) {
            field = "Name:$value"

        }

    var sex: String = ""
        /**自定义方法*/

        get() = field.toUpperCase()
        set(value) {
            field = "Sex:$value"

        }


}