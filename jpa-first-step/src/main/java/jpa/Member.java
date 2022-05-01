package jpa;
import javax.persistence.*;

@Entity
public class Member {

	@Id @GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TEAM_ID")
	private Team team;

	@Embedded
	//기간
	private Period period;

	@Embedded
	private Address address;

	public Member() {
	}

	public Member(Long id, String name, Team team, Period period, Address address) {
		this.id = id;
		this.name = name;
		this.team = team;
		this.period = period;
		this.address = address;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
}
