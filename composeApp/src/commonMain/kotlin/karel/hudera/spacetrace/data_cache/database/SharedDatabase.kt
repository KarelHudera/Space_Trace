package karel.hudera.spacetrace.data_cache.database

import karel.hudera.spacetrace.db.AppDatabase
import karel.hudera.spacetrace.platform.DatabaseDriverFactory

class SharedDatabase(
    private val driverProvider: DatabaseDriverFactory,
) {
    private var database: AppDatabase? = null

    private suspend fun initDatabase() {
        database.takeIf { it != null } ?: run {
            database = AppDatabase(driverProvider.createDriver())
        }
    }


    suspend operator fun <R> invoke(block: suspend (AppDatabase) -> R): R {
        initDatabase()
        return database.takeIf { it != null }?.let {
            block(it)
        } ?: throw IllegalStateException("Database is not initialized")
    }
}