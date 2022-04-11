package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Table(name="USER")
@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
//	@Column(name = "TEAM_ID")
//	private Long teamId;

	public Team getTeam() {
		return team;
	}

	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	
}
