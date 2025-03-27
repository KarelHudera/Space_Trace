package karel.hudera.spacetrace.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import karel.hudera.spacetrace.db.AppDatabase
import app.cash.sqldelight.async.coroutines.synchronous

actual class DatabaseDriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema.synchronous(), "test.db")
    }
}