package karel.hudera.spacetrace.platform

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import karel.hudera.spacetrace.data_cache.sqldelight.ArticleDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(ArticleDatabase.Schema, context, "test.db")
    }
}