package xyz.dewniel.scoutapp

public var allTeams = mutableListOf<Team>()

class Team {
    var id : Int = 0
    var team : Int = 0
    var total_points : Int = 0
    var low_points : Int = 0
    var high_points : Int = 0
    var climb_points : Int = 0
    var taxi: Boolean = false

    constructor(team: Int, low_points: Int, high_points: Int, climb_points: Int, taxi: Boolean) {
        this.id = id
        this.team = team
        this.low_points = low_points
        this.high_points = high_points
        this.climb_points = climb_points
        this.taxi = taxi
        id += 1

        if (taxi == true) {
            this.total_points += 2
        }

        this.total_points = this.total_points + high_points + low_points + climb_points

        allTeams.add(this)

    }

}
