package karel.hudera.spacetrace.data_remote.model.mapper

import karel.hudera.spacetrace.data_remote.model.apiPicture.ApiPicture
import karel.hudera.spacetrace.domain.model.Picture
import karel.hudera.spacetrace.domain.model.map.Mapper

class ApiPictureMapper : Mapper<ApiPicture, Picture>() {
    override fun map(model: ApiPicture): Picture = model.run {
        Picture(
            copyright,
            date,
            explanation,
            hdurl,
            mediaType,
            serviceVersion,
            title,
            url
        )
    }

    override fun inverseMap(model: Picture): ApiPicture {
        TODO("Not yet implemented")
    }
}