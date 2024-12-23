package karel.hudera.spacetrace.data_cache.sqldelight

import app.cash.sqldelight.ColumnAdapter
import karel.hudera.spacetrace.platform.DatabaseDriverFactory

class SharedDatabase(
    private val driverProvider: DatabaseDriverFactory,
) {
    private var database: ArticleDatabase? = null

    private val boolAdapter = object : ColumnAdapter<Boolean, String> {
        override fun decode(databaseValue: String): Boolean = when (databaseValue) {
            "true" -> true
            "false" -> false
            else -> false
        }

        override fun encode(value: Boolean): String = when (value) {
            true -> "true"
            false -> "false"
        }
    }

    private suspend fun initDatabase() {
        if (database == null) {
            database = ArticleDatabase.invoke(
                driverProvider.createDriver(),
                //FavoriteArticles.Adapter(boolAdapter)
            )
        }
    }

    suspend operator fun <R> invoke(block: suspend (ArticleDatabase) -> R): R {
        initDatabase()
        return block(database!!)
    }
}