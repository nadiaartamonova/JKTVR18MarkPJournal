
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Order implements Serializable {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String orderName;
    private Client client;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateStart;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinish;
    

    
}
