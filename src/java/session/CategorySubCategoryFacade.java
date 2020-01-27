/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.CategorySubCategory;
import entity.SubCategory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pupil
 */
@Stateless
public class CategorySubCategoryFacade extends AbstractFacade<CategorySubCategory> {

    @PersistenceContext(unitName = "JKTVR18MarkPJournalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorySubCategoryFacade() {
        super(CategorySubCategory.class);
    }

    public List<CategorySubCategory> findSubAndCat() {
        try {
            return em.createNativeQuery("SELECT category.CATEGORYNAME, subcategory.SUBCATEGORYNAME FROM categorysubcategory INNER JOIN subcategory ON subcategory.ID = categorysubcategory.SUBCATEGORY_ID INNER JOIN category ON categorysubcategory.CATEGORY_ID = category.ID ORDER BY category.CATEGORYNAME")
                    
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<SubCategory> findSubCategoryListByCategory(String categoryId) {
         try {
            return em.createQuery("SELECT categorySubCategory.subCategory FROM CategorySubCategory categorySubCategory WHERE categorySubCategory.category.id = :categoryId")
                    .setParameter("categoryId", Long.parseLong(categoryId))
                    .getResultList();
    } catch (Exception e) {
            return null;
        }
    }
    
}
