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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afrodeb
 */
@Entity
@Table(name = "survey_questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SurveyQuestions.findAll", query = "SELECT s FROM SurveyQuestions s")
    , @NamedQuery(name = "SurveyQuestions.findById", query = "SELECT s FROM SurveyQuestions s WHERE s.id = :id")
    , @NamedQuery(name = "SurveyQuestions.findBySurveyId", query = "SELECT s FROM SurveyQuestions s WHERE s.surveyId = :surveyId")
    , @NamedQuery(name = "SurveyQuestions.findByCreated", query = "SELECT s FROM SurveyQuestions s WHERE s.created = :created")})
public class SurveyQuestions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "survey_id")
    private int surveyId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public SurveyQuestions() {
    }

    public SurveyQuestions(Integer id) {
        this.id = id;
    }

    public SurveyQuestions(Integer id, int surveyId, String question, Date created) {
        this.id = id;
        this.surveyId = surveyId;
        this.question = question;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
        if (!(object instanceof SurveyQuestions)) {
            return false;
        }
        SurveyQuestions other = (SurveyQuestions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reviews.models.SurveyQuestions[ id=" + id + " ]";
    }
    
 /*   public List<SurveyQuestions> getSurveyQuestions(Long id){
    
    }*/
}
