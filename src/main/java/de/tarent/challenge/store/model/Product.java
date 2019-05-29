package de.tarent.challenge.store.model;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Product {

    private @Id @GeneratedValue(strategy = SEQUENCE) Long id;

    @NotNull(message = "Associated SKU is required.")
    @Basic(optional = false)
    @Column(nullable = false, unique = true)
    private String sku;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @DecimalMin("0.00")
    @Column(nullable = false)
    private Double price;

    @Size(min = 1)
    @ElementCollection
    private Set<String> eans;

    private Product() {
    }

    public Product(String sku, String name, Double price, Set<String> eans) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.eans = eans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEans(Set<String> eans) {
        this.eans = eans;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Set<String> getEans() {
        return Sets.newHashSet(eans);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(sku, product.sku) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(eans, product.eans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, name, price, eans);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("sku", sku)
                .add("name", name)
                .add("price", price)
                .add("eans", eans)
                .toString();
    }
}
