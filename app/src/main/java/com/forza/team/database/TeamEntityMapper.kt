import com.forza.api.model.Team
import com.forza.team.database.TeamEntity

object TeamEntityMapper {
    fun toEntity(team: Team): TeamEntity {
        return TeamEntity(team.id, team.gender, team.national, team.name)
    }

    fun toVO(teamEntity: TeamEntity): Team {
        return Team(teamEntity.teamId, teamEntity.gender, teamEntity.national, teamEntity.name)
    }
}