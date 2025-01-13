package karel.hudera.spacetrace.data_cache.database

import karel.hudera.spacetrace.db.AppDatabase
import karel.hudera.spacetrace.platform.DatabaseDriverFactory

class SharedDatabase(
    private val driverProvider: DatabaseDriverFactory,
) {
    private var database: AppDatabase? = null

    private suspend fun initDatabase() {
        if (database == null) {
            database = AppDatabase.invoke(
                driverProvider.createDriver(),
            )
        }
    }

    suspend operator fun <R> invoke(block: suspend (AppDatabase) -> R): R {
        initDatabase()
        return block(database!!)
    }
}