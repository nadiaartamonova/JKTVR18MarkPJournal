/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.CategorySubCategory;
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
            return em.createNativeQuery("select subcategory.SUBCATEGORYNAME, category.CATEGORYNAME from categorysubcategory inner join subcategory ON subcategory.ID = categorysubcategory.SUBCATEGORY_ID INNER JOIN category ON categorysubcategory.CATEGORY_ID = category.ID")
                    
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
