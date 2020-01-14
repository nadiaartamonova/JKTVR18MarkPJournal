
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class SubCategoryStage implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private SubCategory subCategory;
    @OneToOne
    private Stage stage;

    public SubCategoryStage() {
    }

    public SubCategoryStage(SubCategory subCategory, Stage stage) {
        
        this.subCategory = subCategory;
        this.stage = stage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.subCategory);
        hash = 89 * hash + Objects.hashCode(this.stage);
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
        final SubCategoryStage other = (SubCategoryStage) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.subCategory, other.subCategory)) {
            return false;
        }
        if (!Objects.equals(this.stage, other.stage)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SubCategoryStage{" 
                + "id=" + id 
                + ", subCategory=" + subCategory.getSubCategoryName()
                + ", stage=" + stage.getStageName()
                + '}';
    }

    
    
    
}
