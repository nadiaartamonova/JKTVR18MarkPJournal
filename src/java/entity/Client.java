
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String regnr;
    private String address;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(String clientName, String regnr, String address, String phone, String email) {
        this.clientName = clientName;
        this.regnr = regnr;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.clientName);
        hash = 79 * hash + Objects.hashCode(this.regnr);
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.email);
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.clientName, other.clientName)) {
            return false;
        }
        if (!Objects.equals(this.regnr, other.regnr)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Client{" 
                + "id=" + id 
                + ", clientName=" + clientName 
                + ", regnr=" + regnr 
                + ", address=" + address 
                + ", phone=" + phone 
                + ", email=" + email 
                
                + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
