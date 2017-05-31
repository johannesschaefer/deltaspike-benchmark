//******************************************************************
//                                                                 
//  RuleViolation.java                                               
//  Copyright 2017 PSI AG. All rights reserved.              
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
//                                                                 
// ******************************************************************

package de.psi.metals.futurelab.repo.benchmark;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * A representation of the model object '<em><b>RuleViolation</b></em>'.
 * @generated
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table( name = "RULEVIOLATION" )
@DiscriminatorColumn( name = "DISCRIMINATOR" )
@DiscriminatorValue( "RULEVIOLATION" )
public class RuleViolation implements Serializable, IdentifiableIf< String >
{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * Creates a new instance of an entity RuleViolation.
     *
     */
    public RuleViolation()
    {
        this.id = java.util.UUID.randomUUID().toString();
    }

    /**
     * @returns an identifier of RuleViolation entity.
     */
    @Override
    public String getId()
    {
        return id;
    }

    @Column( name = "version" )
    @Version
    private Long version;

    /**
     * @see de.psi.pjf.per.rt.VersioningIf#getVersion()
     */
    public Long getVersion()
    {
        return version;
    }

    @Column( name = "created_at" )
    @Temporal( javax.persistence.TemporalType.TIMESTAMP )
    private Date createdAt;

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#getCreatedAt()
     */
    public Date getCreatedAt()
    {
        return createdAt;
    }

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#setCreatedAt(Date)
     */
    public void setCreatedAt( Date aCreatedAt )
    {
        this.createdAt = aCreatedAt;
    }

    @Size( max = 20 )
    @Column( name = "created_by", length = 20 )
    private String createdBy;

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#getCreatedBy()
     */
    public String getCreatedBy()
    {
        return createdBy;
    }

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#setCreatedBy(String)
     */
    public void setCreatedBy( String aCreatedBy )
    {
        this.createdBy = aCreatedBy;
    }

    @Column( name = "updated_at" )
    @Temporal( javax.persistence.TemporalType.TIMESTAMP )
    private Date updatedAt;

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#getUpdatedAt()
     */
    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#setUpdatedAt(Date)
     */
    public void setUpdatedAt( Date aUpdatedAt )
    {
        this.updatedAt = aUpdatedAt;
    }

    @Size( max = 20 )
    @Column( name = "updated_by", length = 20 )
    private String updatedBy;

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#getUpdatedBy()
     */
    public String getUpdatedBy()
    {
        return updatedBy;
    }

    /**
     * @see de.psi.pjf.per.rt.AuditingIf#setUpdatedBy(String)
     */
    public void setUpdatedBy( String aUpdatedBy )
    {
        this.updatedBy = aUpdatedBy;
    }

    /**
     * Sets createdAt before insert.
     */
    @PrePersist
    public void setCreationDate()
    {
        this.createdAt = getCurrentDateTrimmed();
        this.updatedAt = this.createdAt;
    }

    /**
     * Sets updatedAt before update.
     */
    @PreUpdate
    public void setChangeDate()
    {
        this.updatedAt = getCurrentDateTrimmed();
    }

    /**
     * If you stumbled upon this method you might wonder - why the author did not simply use a new Date()?
     * Author sits and responds with another question: Why Oracle does not support milliseconds in TIMESTAMP?
     * 
     * @return date without milliseconds.
     */
    private static Date getCurrentDateTrimmed()
    {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime( new Date() );
        cal.set( Calendar.MILLISECOND, 0 );
        return cal.getTime();
    }

    /**
     * The cached value of the '{@link #getRule() <em><b>rule</b></em>}' attribute.
     * @see #getRule()
     * @generated
     */
    @Column( nullable = false, length = 100 )
    @Size( max = 100 )
    private String rule = "";

    /**
     * Returns a value of '<em><b>rule</b></em>' attribute.
     * @generated
     */
    public String getRule()
    {
        return this.rule;
    }

    /**
     * Sets a value of '<em><b>rule</b></em>' attribute.
     * @generated
     */
    public void setRule( String aRule )
    {
        this.rule = aRule;
    }

    /**
     * The cached value of the '{@link #getMessage() <em><b>message</b></em>}' attribute.
     * @see #getMessage()
     * @generated
     */
    @Column( nullable = false, length = 1000 )
    @Size( max = 1000 )
    private String message = "";

    /**
     * Returns a value of '<em><b>message</b></em>' attribute.
     * @generated
     */
    public String getMessage()
    {
        return this.message;
    }

    /**
     * Sets a value of '<em><b>message</b></em>' attribute.
     * @generated
     */
    public void setMessage( String aMessage )
    {
        this.message = aMessage;
    }

    /**
     * The cached value of the '{@link #getViolationLevel() <em><b>violationLevel</b></em>}' attribute.
     * @see #getViolationLevel()
     * @generated
     */
    private Integer violationLevel = Integer.valueOf( "1" );

    /**
     * Returns a value of '<em><b>violationLevel</b></em>' attribute.
     * @generated
     */
    public Integer getViolationLevel()
    {
        return this.violationLevel;
    }

    /**
     * Sets a value of '<em><b>violationLevel</b></em>' attribute.
     * @generated
     */
    public void setViolationLevel( Integer aViolationLevel )
    {
        this.violationLevel = aViolationLevel;
    }

    /**
     * Dumps class name, field names and values.
     * @return list of attribute names and values.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( this.getClass().getName() );
        builder.append( "[" );
        appendAttributeValues( builder );
        builder.append( "]" );
        return builder.toString();
    }

    /**
     * Appends field names and values.
     */
    protected void appendAttributeValues( StringBuilder aBuilder )
    {
        aBuilder.append( "rule = " );
        aBuilder.append( getRule() );
        aBuilder.append( ", message = " );
        aBuilder.append( getMessage() );

        aBuilder.append( ", violationLevel = " );
        aBuilder.append( getViolationLevel() );
    }

    @Override
    public boolean equals( Object aObject )
    {
        if( this == aObject )
        {
            return true;
        }
        if( aObject == null )
        {
            return false;
        }
        if( getClass() != aObject.getClass() )
        {
            return false;
        }
        IdentifiableIf< ? > other = (IdentifiableIf< ? >)aObject;
        if( this.getId() != other.getId() && (this.getId() == null || !this.getId().equals( other.getId() )) )
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
}
