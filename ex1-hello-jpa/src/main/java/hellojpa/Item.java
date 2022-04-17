package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {

	@Id @GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;
	
	
	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<Category>();
	
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public Item(Long id, String name, int price, int stockQuantity, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.categories = categories;
	}
	public Item() {
		super();
	}
	
	
}
