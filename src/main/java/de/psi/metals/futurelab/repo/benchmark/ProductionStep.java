//******************************************************************
//                                                                 
//  ProductionStep.java                                               
//  Copyright 2017 PSI AG. All rights reserved.              
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
//                                                                 
// ******************************************************************

package de.psi.metals.futurelab.repo.benchmark;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

/**
 * A representation of the model object '<em><b>ProductionStep</b></em>'.
 * <!-- begin-model-doc -->
 * Production Step is going to be unique per material
 * <!-- end-model-doc -->
 * @generated
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table( name = "PRODUCTIONSTEP" )
@DiscriminatorColumn( name = "DISCRIMINATOR" )
@DiscriminatorValue( "PRODUCTIONSTEP" )
public class ProductionStep implements Serializable, IdentifiableIf< String >
{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * Creates a new instance of an entity ProductionStep.
     *
     */
    public ProductionStep()
    {
        this.id = java.util.UUID.randomUUID().toString();
    }

    /**
     * @returns an identifier of ProductionStep entity.
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
     * The cached value of the '{@link #getProductionStepNumber() <em><b>productionStepNumber</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Production Step Number is unique in the database
     * <!-- end-model-doc -->
     * @see #getProductionStepNumber()
     * @generated
     */
    @Column( nullable = false )
    @DecimalMin( "0" )
    private int productionStepNumber = 0;

    /**
     * Returns a value of '<em><b>productionStepNumber</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Production Step Number is unique in the database
     * <!-- end-model-doc -->
     * @generated
     */
    public int getProductionStepNumber()
    {
        return this.productionStepNumber;
    }

    /**
     * Sets a value of '<em><b>productionStepNumber</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Production Step Number is unique in the database
     * <!-- end-model-doc -->
     * @generated
     */
    public void setProductionStepNumber( int aProductionStepNumber )
    {
        this.productionStepNumber = aProductionStepNumber;
    }

    /**
     * The cached value of the '{@link #getProcessTime() <em><b>processTime</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Time needed to process this production step at the given resource
     * <!-- end-model-doc -->
     * @see #getProcessTime()
     * @generated
     */
    @DecimalMin( "0" )
    private Integer processTime = Integer.valueOf( "0" );

    /**
     * Returns a value of '<em><b>processTime</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Time needed to process this production step at the given resource
     * <!-- end-model-doc -->
     * @generated
     */
    public Integer getProcessTime()
    {
        return this.processTime;
    }

    /**
     * Sets a value of '<em><b>processTime</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Time needed to process this production step at the given resource
     * <!-- end-model-doc -->
     * @generated
     */
    public void setProcessTime( Integer aProcessTime )
    {
        this.processTime = aProcessTime;
    }

    /**
     * The cached value of the '{@link #getProductionOrder() <em><b>productionOrder</b></em>}' attribute.
     * @see #getProductionOrder()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "PRODUCTIONORDER_ID" )
    private ProductionOrder productionOrder = null;

    /**
     * Returns a value of '<em><b>productionOrder</b></em>' attribute.
     * @generated
     */
    public ProductionOrder getProductionOrder()
    {
        return this.productionOrder;
    }

    /**
     * Sets a value of '<em><b>productionOrder</b></em>' attribute.
     * @generated
     */
    public void setProductionOrder( ProductionOrder aProductionOrder )
    {
        this.productionOrder = aProductionOrder;
    }

    /**
     * The cached value of the '{@link #getProductionOrderStepPosition() <em><b>productionOrderStepPosition</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Production Order Step Position is unique in the order
     * <!-- end-model-doc -->
     * @see #getProductionOrderStepPosition()
     * @generated
     */
    private Integer productionOrderStepPosition = null;

    /**
     * Returns a value of '<em><b>productionOrderStepPosition</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Production Order Step Position is unique in the order
     * <!-- end-model-doc -->
     * @generated
     */
    public Integer getProductionOrderStepPosition()
    {
        return this.productionOrderStepPosition;
    }

    /**
     * Sets a value of '<em><b>productionOrderStepPosition</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Production Order Step Position is unique in the order
     * <!-- end-model-doc -->
     * @generated
     */
    public void setProductionOrderStepPosition( Integer aProductionOrderStepPosition )
    {
        this.productionOrderStepPosition = aProductionOrderStepPosition;
    }

    /**
     * The cached value of the '{@link #getStatus() <em><b>status</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Status stores whether the step is planned or consumed 
     * 0: Consumed
     * 1: Planned
     *
     * <!-- end-model-doc -->
     * @see #getStatus()
     * @generated
     */
    @Basic
    @Enumerated( javax.persistence.EnumType.STRING )
    private StepStatus status = null;

    /**
     * Returns a value of '<em><b>status</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Status stores whether the step is planned or consumed 
     * 0: Consumed
     * 1: Planned
     *
     * <!-- end-model-doc -->
     * @generated
     */
    public StepStatus getStatus()
    {
        return this.status;
    }

    /**
     * Sets a value of '<em><b>status</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Status stores whether the step is planned or consumed 
     * 0: Consumed
     * 1: Planned
     *
     * <!-- end-model-doc -->
     * @generated
     */
    public void setStatus( StepStatus aStatus )
    {
        this.status = aStatus;
    }

    /**
     * The cached value of the '{@link #getIsTemplate() <em><b>isTemplate</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * isTemplate details whether the PS is the template PS attached to the order,
     * or a PS attached to a piece to be executed on a resource
     * <!-- end-model-doc -->
     * @see #getIsTemplate()
     * @generated
     */
    @Column( nullable = false )
    private boolean isTemplate = false;

    /**
     * Returns a value of '<em><b>isTemplate</b></em>' attribute.
     * <!-- begin-model-doc -->
     * isTemplate details whether the PS is the template PS attached to the order,
     * or a PS attached to a piece to be executed on a resource
     * <!-- end-model-doc -->
     * @generated
     */
    public boolean getIsTemplate()
    {
        return this.isTemplate;
    }

    /**
     * Sets a value of '<em><b>isTemplate</b></em>' attribute.
     * <!-- begin-model-doc -->
     * isTemplate details whether the PS is the template PS attached to the order,
     * or a PS attached to a piece to be executed on a resource
     * <!-- end-model-doc -->
     * @generated
     */
    public void setIsTemplate( boolean aIsTemplate )
    {
        this.isTemplate = aIsTemplate;
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
     * The cached value of the '{@link #getSchedule() <em><b>schedule</b></em>}' attribute.
     * @see #getSchedule()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "SCHEDULE_ID" )
    private Schedule schedule = null;

    /**
     * Returns a value of '<em><b>schedule</b></em>' attribute.
     * @generated
     */
    public Schedule getSchedule()
    {
        return this.schedule;
    }

    /**
     * Sets a value of '<em><b>schedule</b></em>' attribute.
     * @generated
     */
    public void setSchedule( Schedule aSchedule )
    {
        if( this.schedule != aSchedule )
        {
            if( this.schedule != null )
            {
                this.schedule.removeFromProductionSteps( this );
            }
            this.schedule = aSchedule;
            if( this.schedule != null )
            {
                this.schedule.addToProductionSteps( this );
            }
        }
    }

    /**
     * The cached value of the '{@link #getCalendar() <em><b>calendar</b></em>}' attribute.
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
     * @generated
     */
    public FactoryCalendar getCalendar()
    {
        return this.calendar;
    }

    /**
     * Sets a value of '<em><b>calendar</b></em>' attribute.
     * @generated
     */
    public void setCalendar( FactoryCalendar aCalendar )
    {
        this.calendar = aCalendar;
    }

    /**
     * The cached value of the '{@link #getViolation() <em><b>violation</b></em>}' attribute.
     * @see #getViolation()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "VIOLATION_ID" )
    private RuleViolation violation = null;

    /**
     * Returns a value of '<em><b>violation</b></em>' attribute.
     * @generated
     */
    public RuleViolation getViolation()
    {
        return this.violation;
    }

    /**
     * Sets a value of '<em><b>violation</b></em>' attribute.
     * @generated
     */
    public void setViolation( RuleViolation aViolation )
    {
        this.violation = aViolation;
    }

    /**
     * The cached value of the '{@link #getNextProductionStepNumber() <em><b>nextProductionStepNumber</b></em>}' attribute.
     * @see #getNextProductionStepNumber()
     * @generated
     */
    @DecimalMin( "0" )
    private Integer nextProductionStepNumber = Integer.valueOf( "0" );

    /**
     * Returns a value of '<em><b>nextProductionStepNumber</b></em>' attribute.
     * @generated
     */
    public Integer getNextProductionStepNumber()
    {
        return this.nextProductionStepNumber;
    }

    /**
     * Sets a value of '<em><b>nextProductionStepNumber</b></em>' attribute.
     * @generated
     */
    public void setNextProductionStepNumber( Integer aNextProductionStepNumber )
    {
        this.nextProductionStepNumber = aNextProductionStepNumber;
    }

    /**
     * The cached value of the '{@link #getLastProductionStepNumber() <em><b>lastProductionStepNumber</b></em>}' attribute.
     * @see #getLastProductionStepNumber()
     * @generated
     */
    @DecimalMin( "0" )
    private Integer lastProductionStepNumber = Integer.valueOf( "0" );

    /**
     * Returns a value of '<em><b>lastProductionStepNumber</b></em>' attribute.
     * @generated
     */
    public Integer getLastProductionStepNumber()
    {
        return this.lastProductionStepNumber;
    }

    /**
     * Sets a value of '<em><b>lastProductionStepNumber</b></em>' attribute.
     * @generated
     */
    public void setLastProductionStepNumber( Integer aLastProductionStepNumber )
    {
        this.lastProductionStepNumber = aLastProductionStepNumber;
    }

    /**
     * The cached value of the '{@link #getSchedulePosition() <em><b>schedulePosition</b></em>}' attribute.
     * @see #getSchedulePosition()
     * @generated
     */
    private Integer schedulePosition = null;

    /**
     * Returns a value of '<em><b>schedulePosition</b></em>' attribute.
     * @generated
     */
    public Integer getSchedulePosition()
    {
        return this.schedulePosition;
    }

    /**
     * Sets a value of '<em><b>schedulePosition</b></em>' attribute.
     * @generated
     */
    public void setSchedulePosition( Integer aSchedulePosition )
    {
        this.schedulePosition = aSchedulePosition;
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
        aBuilder.append( "productionStepNumber = " );
        aBuilder.append( getProductionStepNumber() );
        aBuilder.append( ", processTime = " );
        aBuilder.append( getProcessTime() );

        aBuilder.append( ", productionOrder = " );
        if( getProductionOrder() != null )
        {
            aBuilder.append( getProductionOrder().getClass().getSimpleName() + "@"
                + getProductionOrder().getId() );
        }
        else
        {
            aBuilder.append( "null" );
        }

        aBuilder.append( ", productionOrderStepPosition = " );
        aBuilder.append( getProductionOrderStepPosition() );

        aBuilder.append( ", status = " );
        aBuilder.append( getStatus() );

        aBuilder.append( ", isTemplate = " );
        aBuilder.append( getIsTemplate() );

        aBuilder.append( ", resource = " );
        if( getResource() != null )
        {
            aBuilder.append( getResource().getClass().getSimpleName() + "@" + getResource().getId() );
        }
        else
        {
            aBuilder.append( "null" );
        }

        aBuilder.append( ", schedule = " );
        if( getSchedule() != null )
        {
            aBuilder.append( getSchedule().getClass().getSimpleName() + "@" + getSchedule().getId() );
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

        aBuilder.append( ", violation = " );
        if( getViolation() != null )
        {
            aBuilder.append( getViolation().getClass().getSimpleName() + "@" + getViolation().getId() );
        }
        else
        {
            aBuilder.append( "null" );
        }

        aBuilder.append( ", nextProductionStepNumber = " );
        aBuilder.append( getNextProductionStepNumber() );

        aBuilder.append( ", lastProductionStepNumber = " );
        aBuilder.append( getLastProductionStepNumber() );

        aBuilder.append( ", schedulePosition = " );
        aBuilder.append( getSchedulePosition() );
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
