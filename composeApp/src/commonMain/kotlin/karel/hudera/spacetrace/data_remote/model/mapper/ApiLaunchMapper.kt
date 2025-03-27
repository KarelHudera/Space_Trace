package karel.hudera.spacetrace.data_remote.model.mapper

import karel.hudera.spacetrace.data_remote.model.apiLaunch.ApiLaunchResult
import karel.hudera.spacetrace.domain.model.Launch
import karel.hudera.spacetrace.domain.model.map.Mapper

class ApiLaunchMapper : Mapper<ApiLaunchResult, Launch>() {
    override fun map(model: ApiLaunchResult): Launch = model.run {
        Launch(
            id,
            image.imageUrl,
            name,
            windowStart
        )
    }

    override fun inverseMap(model: Launch): ApiLaunchResult {
        TODO("Not yet implemented")
    }
}