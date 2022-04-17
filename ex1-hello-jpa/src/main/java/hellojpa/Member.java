package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//@Table(name="USER")
@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	
	private String city;
	private String street;
	private String zipcode;
	
	@OneToMany
	@JoinColumn(name = "ORDER_ID")
	private List<Order> orders = new ArrayList<Order>();
	
	
	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "TEAM_ID")
//	private Team team;
	
//	@Column(name = "TEAM_ID")
//	private Long teamId;


	public Long getId() {
		return id;
	}

	public Member() {
	super();
	}


	public Member(Long id, String name, String city, String street, String zipcode, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
