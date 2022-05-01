package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery  extends BaseEntity{
	
	@Id @GeneratedValue
	private Long id;
	
	private String city;
	private String street;
	private String zipcode;
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@OneToOne (mappedBy = "delivery", fetch = LAZY)
	private Order order;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public DeliveryStatus getStatus() {
		return status;
	}
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
	public Delivery(Long id, String city, String street, String zipcode, DeliveryStatus status) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.status = status;
	}
	public Delivery() {
		super();
	}
	
	
	
	
}
