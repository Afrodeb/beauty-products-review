/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afrodeb
 */
@Entity
@Table(name = "user_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLocation.findAll", query = "SELECT u FROM UserLocation u")
    , @NamedQuery(name = "UserLocation.findById", query = "SELECT u FROM UserLocation u WHERE u.id = :id")
    , @NamedQuery(name = "UserLocation.findByUserId", query = "SELECT u FROM UserLocation u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserLocation.findByLocationId", query = "SELECT u FROM UserLocation u WHERE u.locationId = :locationId")
    , @NamedQuery(name = "UserLocation.findByCreated", query = "SELECT u FROM UserLocation u WHERE u.created = :created")})
public class UserLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "location_id")
    private int locationId;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public UserLocation() {
    }

    public UserLocation(Integer id) {
        this.id = id;
    }

    public UserLocation(Integer id, int userId, int locationId, Date created) {
        this.id = id;
        this.userId = userId;
        this.locationId = locationId;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLocation)) {
            return false;
        }
        UserLocation other = (UserLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reviews.models.UserLocation[ id=" + id + " ]";
    }
    
}
