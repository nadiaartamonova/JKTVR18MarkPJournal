
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Orders implements Serializable {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String orderName;
    @OneToOne
    private Client client;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateStart;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinish;
    private float summa;
    @OneToOne
    private Category category;
    @OneToOne
    private SubCategory subCategory;
    private boolean status;

    public Orders() {
    }

    public Orders( String orderName, Client client, Date dateStart, Date dateFinish, float summa, Category category, SubCategory subCategory, boolean status) {
        
        this.orderName = orderName;
        this.client = client;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.summa = summa;
        this.category = category;
        this.subCategory = subCategory;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public float getSumma() {
        return summa;
    }

    public void setSumma(float summa) {
        this.summa = summa;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.orderName);
        hash = 67 * hash + Objects.hashCode(this.client);
        hash = 67 * hash + Objects.hashCode(this.dateStart);
        hash = 67 * hash + Objects.hashCode(this.dateFinish);
        hash = 67 * hash + Float.floatToIntBits(this.summa);
        hash = 67 * hash + Objects.hashCode(this.category);
        hash = 67 * hash + Objects.hashCode(this.subCategory);
        hash = 67 * hash + (this.status ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orders other = (Orders) obj;
        if (Float.floatToIntBits(this.summa) != Float.floatToIntBits(other.summa)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.orderName, other.orderName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.dateStart, other.dateStart)) {
            return false;
        }
        if (!Objects.equals(this.dateFinish, other.dateFinish)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.subCategory, other.subCategory)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" 
                + "id=" + id 
                + ", orderName=" + orderName 
                + ", client=" + client 
                + ", dateStart=" + dateStart 
                + ", dateFinish=" + dateFinish 
                + ", summa=" + summa 
                + ", category=" + category.getCategoryName()
                + ", subCategory=" + subCategory.getSubCategoryName()
                + ", status=" + status 
                + '}';
    }
    
    
    

    
}
