package com.uzlabina.eshop.data.datasources

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.uzlabina.eshop.data.models.ShoppingItemModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface EshopDataStorage {
    fun addShoppingItem(shoppingItemModel: ShoppingItemModel)
    suspend fun getShoppingItems(): MutableList<ShoppingItemModel>
}

class EshopDatabaseHelperImpl(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION), EshopDataStorage {

    companion object {
        const val DATABASE_NAME = "eshop_database"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(EshopTable.CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(EshopTable.DROP_TABLE_QUERY)
        onCreate(db)
    }

    override fun addShoppingItem(shoppingItemModel: ShoppingItemModel) {
        CoroutineScope(Dispatchers.IO).launch {
            val values = ContentValues()
            values.put(EshopTable.COLUMN_NAME, shoppingItemModel.name)
            values.put(EshopTable.COLUMN_DESCRIPTION, shoppingItemModel.description)
            values.put(EshopTable.COLUMN_PRICE, shoppingItemModel.price)
            values.put(EshopTable.COLUMN_IMAGEID, shoppingItemModel.imageID)

            val db = this@EshopDatabaseHelperImpl.writableDatabase
            db.insert(EshopTable.TABLE_NAME, null, values)
            db.close()
        }
    }

    override suspend fun getShoppingItems(): MutableList<ShoppingItemModel> {
        return withContext(Dispatchers.IO) {
        val shoppingItems = mutableListOf<ShoppingItemModel>()

        val db = this@EshopDatabaseHelperImpl.readableDatabase
        val columns = arrayOf(
            EshopTable.COLUMN_ID,
            EshopTable.COLUMN_NAME,
            EshopTable.COLUMN_DESCRIPTION,
            EshopTable.COLUMN_PRICE,
            EshopTable.COLUMN_IMAGEID
        )
        val cursor = db.query(
            EshopTable.TABLE_NAME, columns, null, null, null, null,
            EshopTable.COLUMN_ID, null)

        if (cursor.moveToFirst()) {
            do {
                val idIndex = cursor.getColumnIndex(EshopTable.COLUMN_ID)
                val nameIndex = cursor.getColumnIndex(EshopTable.COLUMN_NAME)
                val descIndex = cursor.getColumnIndex(EshopTable.COLUMN_DESCRIPTION)
                val priceIndex = cursor.getColumnIndex(EshopTable.COLUMN_PRICE)
                val imageIdIndex = cursor.getColumnIndex(EshopTable.COLUMN_IMAGEID)

                // Check if all columns exist in the results.
                if (idIndex != -1 && nameIndex != -1 && descIndex != -1 && priceIndex != -1 && imageIdIndex != -1) {
                    val id = cursor.getInt(idIndex)
                    val name = cursor.getString(nameIndex)
                    val description = cursor.getString(descIndex)
                    val price = cursor.getInt(priceIndex)
                    val imageid = cursor.getInt(imageIdIndex)
                    val book = ShoppingItemModel(id, name, description, price, imageid)
                    shoppingItems.add(book)
                } else {
                    Log.e("Database", "One or more COLUMNS were NOT FOUND in the result set.")
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        shoppingItems
        }
    }
}