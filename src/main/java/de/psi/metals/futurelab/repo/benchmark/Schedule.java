//******************************************************************
//                                                                 
//  Schedule.java                                               
//  Copyright 2017 PSI AG. All rights reserved.              
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
//                                                                 
// ******************************************************************

package de.psi.metals.futurelab.repo.benchmark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

/**
 * A representation of the model object '<em><b>Schedule</b></em>'.
 * @generated
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table( name = "SCHEDULE" )
@DiscriminatorColumn( name = "DISCRIMINATOR" )
@DiscriminatorValue( "SCHEDULE" )
public class Schedule implements Serializable, IdentifiableIf< String >
{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * Creates a new instance of an entity Schedule.
     *
     */
    public Schedule()
    {
        this.id = java.util.UUID.randomUUID().toString();
    }

    /**
     * @returns an identifier of Schedule entity.
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
     * The cached value of the '{@link #getScheduleName() <em><b>scheduleName</b></em>}' attribute.
     * @see #getScheduleName()
     * @generated
     */
    @Column( nullable = false, length = 50 )
    @Size( max = 50 )
    private String scheduleName = "";

    /**
     * Returns a value of '<em><b>scheduleName</b></em>' attribute.
     * @generated
     */
    public String getScheduleName()
    {
        return this.scheduleName;
    }

    /**
     * Sets a value of '<em><b>scheduleName</b></em>' attribute.
     * @generated
     */
    public void setScheduleName( String aScheduleName )
    {
        this.scheduleName = aScheduleName;
    }

    /**
     * The cached value of the '{@link #getScheduleType() <em><b>scheduleType</b></em>}' attribute.
     * @see #getScheduleType()
     * @generated
     */
    @Column( nullable = false, length = 50 )
    @Size( max = 50 )
    private String scheduleType = "";

    /**
     * Returns a value of '<em><b>scheduleType</b></em>' attribute.
     * @generated
     */
    public String getScheduleType()
    {
        return this.scheduleType;
    }

    /**
     * Sets a value of '<em><b>scheduleType</b></em>' attribute.
     * @generated
     */
    public void setScheduleType( String aScheduleType )
    {
        this.scheduleType = aScheduleType;
    }

    /**
     * The cached value of the '{@link #getResource() <em><b>resource</b></em>}' attribute.
     * @see #getResource()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "RESOURCE_ID" )
    private Resource resource = null;

    /**
     * Returns a value of '<em><b>resource</b></em>' attribute.
     * @generated
     */
    public Resource getResource()
    {
        return this.resource;
    }

    /**
     * Sets a value of '<em><b>resource</b></em>' attribute.
     * @generated
     */
    public void setResource( Resource aResource )
    {
        this.resource = aResource;
    }

    /**
     * The cached value of the '{@link #getCalendar() <em><b>calendar</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * calendar entity is created in case the schedule doesn't contain any production step
     * <!-- end-model-doc -->
     * @see #getCalendar()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "CALENDAR_ID" )
    private FactoryCalendar calendar = null;

    /**
     * Returns a value of '<em><b>calendar</b></em>' attribute.
     * <!-- begin-model-doc -->
     * calendar entity is created in case the schedule doesn't contain any production step
     * <!-- end-model-doc -->
     * @generated
     */
    public FactoryCalendar getCalendar()
    {
        return this.calendar;
    }

    /**
     * Sets a value of '<em><b>calendar</b></em>' attribute.
     * <!-- begin-model-doc -->
     * calendar entity is created in case the schedule doesn't contain any production step
     * <!-- end-model-doc -->
     * @generated
     */
    public void setCalendar( FactoryCalendar aCalendar )
    {
        this.calendar = aCalendar;
    }

    /**
     * The cached value of the '{@link #getProductionSteps() <em><b>productionSteps</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * ordered list of scheduled production steps
     * <!-- end-model-doc -->
     * @see #getProductionSteps()
     * @generated
     */
    @OneToMany( mappedBy = "schedule" )
    @OrderColumn
    private List< ProductionStep > productionSteps = new ArrayList< ProductionStep >();

    /**
     * Returns a value of '<em><b>productionSteps</b></em>' attribute.
     * <!-- begin-model-doc -->
     * ordered list of scheduled production steps
     * <!-- end-model-doc -->
     * @generated
     */
    public List< ProductionStep > getProductionSteps()
    {
        return Collections.unmodifiableList( this.productionSteps );
    }

    /**
     * Sets a value of '<em><b>productionSteps</b></em>' attribute.
     * <!-- begin-model-doc -->
     * ordered list of scheduled production steps
     * <!-- end-model-doc -->
     * @generated
     */
    public void setProductionSteps( List< ProductionStep > aProductionSteps )
    {
        clearProductionSteps();
        for( ProductionStep value : aProductionSteps )
        {
            addToProductionSteps( value );
        }
    }

    /**
     * Obtain one productionStep instance at the specified index.
     *
     * @return a productionStep instance.
     * 
     * @generated
     */
    public ProductionStep getFromProductionSteps( int aIdx )
    {
        return getProductionSteps().get( aIdx );
    }

    /**
     * Adds to the <em>productionSteps</em> feature.
     *
     * @param aProductionStepsValue
     *           the value to add
     * @return true if the value is added to the collection (it was not yet present in the collection), false otherwise
     *
     * @generated
     */
    public boolean addToProductionSteps( ProductionStep aProductionStepsValue )
    {
        if( !productionSteps.contains( aProductionStepsValue ) )
        {
            boolean result = productionSteps.add( aProductionStepsValue );
            aProductionStepsValue.setSchedule( this );
            return result;
        }
        return false;
    }

    /**
     * Adds to the <em>productionSteps</em> feature at the given position.
     *
     * @param aProductionStepsValue
     *           the value to add
     * @param aIndex 
     *           the position at which the instance should be added
     *
     * @generated
     */
    public void addToProductionSteps( int aIndex, ProductionStep aProductionStepsValue )
    {
        productionSteps.add( aIndex, aProductionStepsValue );
        aProductionStepsValue.setSchedule( this );
    }

    /**
     * Removes from the <em>productionSteps</em> feature.
     *
     * @param aProductionStepsValue
     *           the value to remove
     * @return true if the value is removed from the collection (it existed in the collection before removing), false otherwise
     * 
     * @generated
     */
    public boolean removeFromProductionSteps( ProductionStep aProductionStepsValue )
    {
        if( productionSteps.contains( aProductionStepsValue ) )
        {
            boolean result = productionSteps.remove( aProductionStepsValue );
            aProductionStepsValue.setSchedule( null );
            return result;
        }
        return false;
    }

    /**
     * Clears the <em>productionSteps</em> feature.
     *
     * @generated
     */
    public void clearProductionSteps()
    {
        while( !productionSteps.isEmpty() )
        {
            removeFromProductionSteps( productionSteps.iterator().next() );
        }
    }

    /**
     * Number of associated productionStep instances in association productionSteps.
     * 
     * @return number of associated instances.
     * 
     * @generated
     */
    public int sizeOfProductionSteps()
    {
        return (getProductionSteps() == null) ? 0 : getProductionSteps().size();
    }

    /**
     * Check if some productionStep instance is contained in the association productionSteps.
     *
     * @param aProductionStepValue
     *           productionStep instance to check.
     * @return true if instance is member of the association.
     * 
     * @generated
     */
    public boolean containsInProductionSteps( ProductionStep aProductionStepValue )
    {
        return (getProductionSteps() != null) && (getProductionSteps().contains( aProductionStepValue ));
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
        aBuilder.append( "scheduleName = " );
        aBuilder.append( getScheduleName() );
        aBuilder.append( ", scheduleType = " );
        aBuilder.append( getScheduleType() );

        aBuilder.append( ", resource = " );
        if( getResource() != null )
        {
            aBuilder.append( getResource().getClass().getSimpleName() + "@" + getResource().getId() );
        }
        else
        {
            aBuilder.append( "null" );
        }

        aBuilder.append( ", calendar = " );
        if( getCalendar() != null )
        {
            aBuilder.append( getCalendar().getClass().getSimpleName() + "@" + getCalendar().getId() );
        }
        else
        {
            aBuilder.append( "null" );
        }

        aBuilder.append( ", productionSteps = " );
        if( getProductionSteps() != null )
        {
            aBuilder.append( "[" );
            Iterator< ? extends IdentifiableIf > iterator = getProductionSteps().iterator();
            while( iterator.hasNext() )
            {
                aBuilder.append( iterator.next().getId() );
                if( iterator.hasNext() )
                {
                    aBuilder.append( ", " );
                }
            }
            aBuilder.append( "]" );
        }
        else
        {
            aBuilder.append( "null" );
        }
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
