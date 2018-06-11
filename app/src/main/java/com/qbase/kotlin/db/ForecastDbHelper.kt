package com.qbase.kotlin.db

import android.database.sqlite.SQLiteDatabase
import com.qbase.kotlin.app.KotlinApp
import com.qbase.kotlin.bean.table.CityForecastTable
import com.qbase.kotlin.bean.table.DayForecastTable
import org.jetbrains.anko.db.*

class ForecastDbHelper : ManagedSQLiteOpenHelper(KotlinApp.Instance, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "qbase.db"
        val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.createTable("CityForecastTable",true,
                Pair(CityForecastTable.NAME, TEXT),
                Pair(CityForecastTable.ID, INTEGER+ PRIMARY_KEY),
                Pair(CityForecastTable.CITY, TEXT),
                Pair(CityForecastTable.COUNTRY, TEXT))




        db?.createTable("DayForecastTable", true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)

        db?.createTable(DayForecastTable.NAME,true,DayForecastTable.DATE to INTEGER)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable("CityForecastTable", true)
        db?.dropTable("DayForecastTable", true)
        onCreate(db)
    }
}

//
//class ForecastDbHelper(ctx: Context = App.instance) :
//        ManagedSQLiteOpenHelper(ctx, ForecastDbHelper.DB_NAME, null,
//                ForecastDbHelper.DB_VERSION) {
//    ...
//}