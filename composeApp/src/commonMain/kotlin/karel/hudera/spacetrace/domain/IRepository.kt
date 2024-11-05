package karel.hudera.spacetrace.domain

import karel.hudera.spacetrace.domain.model.Picture

interface IRepository {
    suspend fun getPicture(): Picture
}