package com.jba.cassandra.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5745533703420527370L;
	@PrimaryKey
	private ProductPrimaryKey productPrimaryKey;
	private String imageUrl;

	public ProductPrimaryKey getProductPrimaryKey() {
		return productPrimaryKey;
	}

	public void setProductPrimaryKey(ProductPrimaryKey productPrimaryKey) {
		this.productPrimaryKey = productPrimaryKey;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Product{" + "ProductPrimaryKey=" + productPrimaryKey + '}';
	}

	@PrimaryKeyClass
	public static class ProductPrimaryKey implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6846576463584269205L;
		@PrimaryKeyColumn(name = "name", type = PrimaryKeyType.PARTITIONED)
		private String name;
		@PrimaryKeyColumn(name = "description", type = PrimaryKeyType.CLUSTERED)
		private String description;
		@PrimaryKeyColumn(name = "price", type = PrimaryKeyType.CLUSTERED)
		private int price;

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			ProductPrimaryKey that = (ProductPrimaryKey) o;
			return price == that.price && Objects.equals(description, that.description)
					&& Objects.equals(name, that.name);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, description, price);
		}

		@Override
		public String toString() {
			return "ExampleTablePrimaryKey{" + "name='" + name + '\'' + ", description='" + description + '\''
					+ ", price=" + price + '}';
		}
	}

}
