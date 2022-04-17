package hellojpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id @GeneratedValue
	@Column(name ="ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="MEMBER_ID")
	private Member member;
	
	@OneToOne
	@JoinColumn(name ="DELIVERY_ID")
	private Delivery delivery;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public Member getMember() {
		return member;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}
	
	

}
