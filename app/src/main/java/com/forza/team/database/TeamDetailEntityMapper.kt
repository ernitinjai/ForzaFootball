import com.forza.api.model.TeamDetail
import com.forza.team.database.TeamDetailEntity

object TeamDetailEntityMapper {
    fun toEntity(teamDetail: TeamDetail, teamId: Long): TeamDetailEntity {
        return TeamDetailEntity(
            description = teamDetail.description,
            badgeUrl = teamDetail.badge_url,
            teamId = teamId
        )
    }

    fun toVO(teamDetailEntity: TeamDetailEntity?, teamId: Long): TeamDetail? {
        teamDetailEntity?.run {
            return TeamDetail(
                teamId,
                this.description,
                this.badgeUrl
            )
        }
        return null
    }
}
