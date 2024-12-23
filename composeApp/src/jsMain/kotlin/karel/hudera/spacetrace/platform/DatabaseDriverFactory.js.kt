package karel.hudera.spacetrace.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.sqljs.initSqlDriver
import karel.hudera.spacetrace.data_cache.sqldelight.ArticleDatabase
import kotlinx.coroutines.await

actual class DatabaseDriverFactory {
    actual suspend fun createDriver(): SqlDriver = initSqlDriver(ArticleDatabase.Schema).await()
}