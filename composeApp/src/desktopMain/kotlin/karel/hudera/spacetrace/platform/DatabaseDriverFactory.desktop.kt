package karel.hudera.spacetrace.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import karel.hudera.spacetrace.data_cache.sqldelight.ArticleDatabase

actual class DatabaseDriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        return JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).apply {
            ArticleDatabase.Schema.create(this)
        }
    }
}