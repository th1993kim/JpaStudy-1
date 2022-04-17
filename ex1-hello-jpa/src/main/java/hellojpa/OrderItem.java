package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class OrderItem {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;
	private int orderPrice;
	private int count;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public OrderItem() {}
	public OrderItem(Long id, Item item, Order order, int orderPrice, int count) {
		super();
		this.id = id;
		this.item = item;
		this.order = order;
		this.orderPrice = orderPrice;
		this.count = count;
	}
	
	
	
}
