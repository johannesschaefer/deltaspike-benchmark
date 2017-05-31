//******************************************************************
//                                                                 
//  Material.java                                               
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
 * A representation of the model object '<em><b>Material</b></em>'.
 * @generated
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table( name = "MATERIAL" )
@DiscriminatorColumn( name = "DISCRIMINATOR" )
@DiscriminatorValue( "MATERIAL" )
public class Material implements Serializable, IdentifiableIf< String >
{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * Creates a new instance of an entity Material.
     *
     */
    public Material()
    {
        this.id = java.util.UUID.randomUUID().toString();
    }

    /**
     * @returns an identifier of Material entity.
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
     * The cached value of the '{@link #getMaterialName() <em><b>materialName</b></em>}' attribute.
     * @see #getMaterialName()
     * @generated
     */
    @Column( name = "", nullable = false, length = 50 )
    @Size( max = 50 )
    private String materialName = "";

    /**
     * Returns a value of '<em><b>materialName</b></em>' attribute.
     * @generated
     */
    public String getMaterialName()
    {
        return this.materialName;
    }

    /**
     * Sets a value of '<em><b>materialName</b></em>' attribute.
     * @generated
     */
    public void setMaterialName( String aMaterialName )
    {
        this.materialName = aMaterialName;
    }

    /**
     * The cached value of the '{@link #getWidth() <em><b>width</b></em>}' attribute.
     * @see #getWidth()
     * @generated
     */
    @Column( nullable = false )
    @DecimalMin( "0" )
    private int width = 0;

    /**
     * Returns a value of '<em><b>width</b></em>' attribute.
     * @generated
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Sets a value of '<em><b>width</b></em>' attribute.
     * @generated
     */
    public void setWidth( int aWidth )
    {
        this.width = aWidth;
    }

    /**
     * The cached value of the '{@link #getThickness() <em><b>thickness</b></em>}' attribute.
     * @see #getThickness()
     * @generated
     */
    @Column( nullable = false )
    @DecimalMin( "0" )
    private double thickness = 0.0;

    /**
     * Returns a value of '<em><b>thickness</b></em>' attribute.
     * @generated
     */
    public double getThickness()
    {
        return this.thickness;
    }

    /**
     * Sets a value of '<em><b>thickness</b></em>' attribute.
     * @generated
     */
    public void setThickness( double aThickness )
    {
        this.thickness = aThickness;
    }

    /**
     * The cached value of the '{@link #getGrade() <em><b>grade</b></em>}' attribute.
     * @see #getGrade()
     * @generated
     */
    @Column( name = "", nullable = false, length = 10 )
    @Size( max = 10 )
    private String grade = "";

    /**
     * Returns a value of '<em><b>grade</b></em>' attribute.
     * @generated
     */
    public String getGrade()
    {
        return this.grade;
    }

    /**
     * Sets a value of '<em><b>grade</b></em>' attribute.
     * @generated
     */
    public void setGrade( String aGrade )
    {
        this.grade = aGrade;
    }

    /**
     * The cached value of the '{@link #getStatus() <em><b>status</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Status stores whether the piece is in storage or consumed 
     * 0: Consumed
     * 1: In Storage
     *
     * <!-- end-model-doc -->
     * @see #getStatus()
     * @generated
     */
    @Basic
    @Enumerated( javax.persistence.EnumType.STRING )
    private Status status = null;

    /**
     * Returns a value of '<em><b>status</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Status stores whether the piece is in storage or consumed 
     * 0: Consumed
     * 1: In Storage
     *
     * <!-- end-model-doc -->
     * @generated
     */
    public Status getStatus()
    {
        return this.status;
    }

    /**
     * Sets a value of '<em><b>status</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Status stores whether the piece is in storage or consumed 
     * 0: Consumed
     * 1: In Storage
     *
     * <!-- end-model-doc -->
     * @generated
     */
    public void setStatus( Status aStatus )
    {
        this.status = aStatus;
    }

    /**
     * The cached value of the '{@link #getAssignedProductionOrder() <em><b>assignedProductionOrder</b></em>}'
     * attribute.
     * 
     * @see #getAssignedProductionOrder()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "ASSIGNEDPRODUCTIONORDER_ID" )
    private ProductionOrder assignedProductionOrder = null;

    /**
     * Returns a value of '<em><b>assignedProductionOrder</b></em>' attribute.
     * 
     * @generated
     */
    public ProductionOrder getAssignedProductionOrder()
    {
        return this.assignedProductionOrder;
    }

    /**
     * Sets a value of '<em><b>assignedProductionOrder</b></em>' attribute.
     * 
     * @generated
     */
    public void setAssignedProductionOrder( ProductionOrder aAssignedProductionOrder )
    {
        this.assignedProductionOrder = aAssignedProductionOrder;
    }

    /**
     * The cached value of the '{@link #getLastProductionStep() <em><b>lastProductionStep</b></em>}'
     * attribute. <!-- begin-model-doc --> Last production step which was processed for this material. This
     * should never get changed once the piece is made. <!-- end-model-doc -->
     * 
     * @see #getLastProductionStep()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "LASTPRODUCTIONSTEP_ID" )
    private ProductionStep lastProductionStep = null;

    /**
     * Returns a value of '<em><b>lastProductionStep</b></em>' attribute. <!-- begin-model-doc --> Last
     * production step which was processed for this material. This should never get changed once the piece is
     * made. <!-- end-model-doc -->
     * 
     * @generated
     */
    public ProductionStep getLastProductionStep()
    {
        return this.lastProductionStep;
    }

    /**
     * Sets a value of '<em><b>lastProductionStep</b></em>' attribute. <!-- begin-model-doc --> Last
     * production step which was processed for this material. This should never get changed once the piece is
     * made. <!-- end-model-doc -->
     * 
     * @generated
     */
    public void setLastProductionStep( ProductionStep aLastProductionStep )
    {
        this.lastProductionStep = aLastProductionStep;
    }

    /**
     * The cached value of the '{@link #getNextProductionStep() <em><b>nextProductionStep</b></em>}'
     * attribute. <!-- begin-model-doc --> Next planned production step for this material. This will get
     * changed if the piece is re-allocated <!-- end-model-doc -->
     * 
     * @see #getNextProductionStep()
     * @generated
     */
    @ManyToOne( fetch = FetchType.LAZY )
    @LazyToOne( value = LazyToOneOption.NO_PROXY )
    @Fetch( value = FetchMode.SELECT )
    @JoinColumn( name = "NEXTPRODUCTIONSTEP_ID" )
    private ProductionStep nextProductionStep = null;

    /**
     * Returns a value of '<em><b>nextProductionStep</b></em>' attribute. <!-- begin-model-doc --> Next
     * planned production step for this material. This will get changed if the piece is re-allocated <!--
     * end-model-doc -->
     * 
     * @generated
     */
    public ProductionStep getNextProductionStep()
    {
        return this.nextProductionStep;
    }

    /**
     * Sets a value of '<em><b>nextProductionStep</b></em>' attribute. <!-- begin-model-doc --> Next planned
     * production step for this material. This will get changed if the piece is re-allocated <!--
     * end-model-doc -->
     * 
     * @generated
     */
    public void setNextProductionStep( ProductionStep aNextProductionStep )
    {
        this.nextProductionStep = aNextProductionStep;
    }

    /**
     * Dumps class name, field names and values.
     * 
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
        aBuilder.append( "materialName = " );
        aBuilder.append( getMaterialName() );
        aBuilder.append( ", width = " );
        aBuilder.append( getWidth() );

        aBuilder.append( ", thickness = " );
        aBuilder.append( getThickness() );

        aBuilder.append( ", grade = " );
        aBuilder.append( getGrade() );

        aBuilder.append( ", status = " );
        aBuilder.append( getStatus() );

        aBuilder.append( ", assignedProductionOrder = " );
        if( getAssignedProductionOrder() != null )
        {
            aBuilder.append( getAssignedProductionOrder().getClass().getSimpleName() + "@"
                + getAssignedProductionOrder().getId() );
        }
        else
        {
            aBuilder.append( "null" );
        }

        aBuilder.append( ", lastProductionStep = " );
        if( getLastProductionStep() != null )
        {
            aBuilder.append(
                getLastProductionStep().getClass().getSimpleName() + "@" + getLastProductionStep().getId() );
        }
        else
        {
            aBuilder.append( "null" );
        }

        aBuilder.append( ", nextProductionStep = " );
        if( getNextProductionStep() != null )
        {
            aBuilder.append(
                getNextProductionStep().getClass().getSimpleName() + "@" + getNextProductionStep().getId() );
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
