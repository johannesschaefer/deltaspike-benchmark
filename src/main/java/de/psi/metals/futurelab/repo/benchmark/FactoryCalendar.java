//******************************************************************
//                                                                 
//  FactoryCalendar.java                                               
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
 * A representation of the model object '<em><b>FactoryCalendar</b></em>'.
 * @generated
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table( name = "FACTORYCALENDAR" )
@DiscriminatorColumn( name = "DISCRIMINATOR" )
@DiscriminatorValue( "FACTORYCALENDAR" )
public class FactoryCalendar implements Serializable, IdentifiableIf< String >
{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * Creates a new instance of an entity FactoryCalendar.
     *
     */
    public FactoryCalendar()
    {
        this.id = java.util.UUID.randomUUID().toString();
    }

    /**
     * @returns an identifier of FactoryCalendar entity.
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
     * The cached value of the '{@link #getSchedulableType() <em><b>schedulableType</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Type of entity (e.g.: "STEP", "SCHEDULE" just used for empty schedules, "DOWNTIMES",...)
     * <!-- end-model-doc -->
     * @see #getSchedulableType()
     * @generated
     */
    @Column( nullable = false, length = 50 )
    @Size( max = 50 )
    private String schedulableType = "";

    /**
     * Returns a value of '<em><b>schedulableType</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Type of entity (e.g.: "STEP", "SCHEDULE" just used for empty schedules, "DOWNTIMES",...)
     * <!-- end-model-doc -->
     * @generated
     */
    public String getSchedulableType()
    {
        return this.schedulableType;
    }

    /**
     * Sets a value of '<em><b>schedulableType</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Type of entity (e.g.: "STEP", "SCHEDULE" just used for empty schedules, "DOWNTIMES",...)
     * <!-- end-model-doc -->
     * @generated
     */
    public void setSchedulableType( String aSchedulableType )
    {
        this.schedulableType = aSchedulableType;
    }

    /**
     * The cached value of the '{@link #getContentId() <em><b>contentId</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Position of this entity in the upper level (e.g.: position of a P.S. in the schedule)
     * <!-- end-model-doc -->
     * @see #getContentId()
     * @generated
     */
    @Column( nullable = false )
    private String contentId = "";

    /**
     * Returns a value of '<em><b>contentId</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Position of this entity in the upper level (e.g.: position of a P.S. in the schedule)
     * <!-- end-model-doc -->
     * @generated
     */
    public String getContentId()
    {
        return this.contentId;
    }

    /**
     * Sets a value of '<em><b>contentId</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Position of this entity in the upper level (e.g.: position of a P.S. in the schedule)
     * <!-- end-model-doc -->
     * @generated
     */
    public void setContentId( String aContentId )
    {
        this.contentId = aContentId;
    }

    /**
     * The cached value of the '{@link #getStartTime() <em><b>startTime</b></em>}' attribute.
     * @see #getStartTime()
     * @generated
     */
    @Column( nullable = false )
    @Temporal( javax.persistence.TemporalType.TIMESTAMP )
    private Date startTime = null;

    /**
     * Returns a value of '<em><b>startTime</b></em>' attribute.
     * @generated
     */
    public Date getStartTime()
    {
        return this.startTime;
    }

    /**
     * Sets a value of '<em><b>startTime</b></em>' attribute.
     * @generated
     */
    public void setStartTime( Date aStartTime )
    {
        this.startTime = aStartTime;
    }

    /**
     * The cached value of the '{@link #getEndTime() <em><b>endTime</b></em>}' attribute.
     * @see #getEndTime()
     * @generated
     */
    @Temporal( javax.persistence.TemporalType.TIMESTAMP )
    private Date endTime = null;

    /**
     * Returns a value of '<em><b>endTime</b></em>' attribute.
     * @generated
     */
    public Date getEndTime()
    {
        return this.endTime;
    }

    /**
     * Sets a value of '<em><b>endTime</b></em>' attribute.
     * @generated
     */
    public void setEndTime( Date aEndTime )
    {
        this.endTime = aEndTime;
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
        aBuilder.append( "schedulableType = " );
        aBuilder.append( getSchedulableType() );
        aBuilder.append( ", contentId = " );
        aBuilder.append( getContentId() );

        aBuilder.append( ", startTime = " );
        aBuilder.append( getStartTime() );

        aBuilder.append( ", endTime = " );
        aBuilder.append( getEndTime() );
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
