package com.uzlabina.eshop.data.datasources

data class EshopTable(val id: Long?, val name: String, val age: Int) {
    companion object {
        const val TABLE_NAME = "eshop_table"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_PRICE = "price"
        const val COLUMN_IMAGEID = "imageid"

        const val CREATE_TABLE_QUERY = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT NOT NULL,
                $COLUMN_DESCRIPTION TEXT,
                $COLUMN_PRICE INTEGER NOT NULL,
                $COLUMN_IMAGEID INTEGER NOT NULL
            );
        """

        const val DROP_TABLE_QUERY = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}