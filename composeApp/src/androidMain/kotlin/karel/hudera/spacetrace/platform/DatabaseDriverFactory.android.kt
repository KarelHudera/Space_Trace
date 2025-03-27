package karel.hudera.spacetrace.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import karel.hudera.spacetrace.AndroidApp.Companion.appContext
import karel.hudera.spacetrace.db.AppDatabase

actual class DatabaseDriverFactory() {
    actual suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(schema = AppDatabase.Schema.synchronous(), appContext, "test.db")
    }
}