package karel.hudera.spacetrace.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import karel.hudera.spacetrace.data_cache.sqldelight.ArticleDatabase

actual class DatabaseDriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(ArticleDatabase.Schema, "test.db")
    }
}