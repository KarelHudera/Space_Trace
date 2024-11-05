package karel.hudera.spacetrace.repository

import karel.hudera.spacetrace.domain.model.Picture


interface IRemoteData {
    suspend fun getPictureFromApi(): Picture
}