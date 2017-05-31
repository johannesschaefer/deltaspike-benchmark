//******************************************************************
//                                                                 
//  ProductionOrder.java                                               
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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * A representation of the model object '<em><b>ProductionOrder</b></em>'.
 * @generated
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table( name = "PRODUCTIONORDER" )
@DiscriminatorColumn( name = "DISCRIMINATOR" )
@DiscriminatorValue( "PRODUCTIONORDER" )
public class ProductionOrder implements Serializable, IdentifiableIf< String >
{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * Creates a new instance of an entity ProductionOrder.
     *
     */
    public ProductionOrder()
    {
        this.id = java.util.UUID.randomUUID().toString();
    }

    /**
     * @returns an identifier of ProductionOrder entity.
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
     * The cached value of the '{@link #getOrderName() <em><b>orderName</b></em>}' attribute.
     * @see #getOrderName()
     * @generated
     */
    @Column( nullable = false, length = 50 )
    @Size( max = 50 )
    private String orderName = "";

    /**
     * Returns a value of '<em><b>orderName</b></em>' attribute.
     * @generated
     */
    public String getOrderName()
    {
        return this.orderName;
    }

    /**
     * Sets a value of '<em><b>orderName</b></em>' attribute.
     * @generated
     */
    public void setOrderName( String aOrderName )
    {
        this.orderName = aOrderName;
    }

    /**
     * The cached value of the '{@link #getDemandQtyMin() <em><b>demandQtyMin</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Minimum weight requested for this production order
     * <!-- end-model-doc -->
     * @see #getDemandQtyMin()
     * @generated
     */
    @Column( nullable = false )
    @DecimalMin( "0" )
    private int demandQtyMin = 0;

    /**
     * Returns a value of '<em><b>demandQtyMin</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Minimum weight requested for this production order
     * <!-- end-model-doc -->
     * @generated
     */
    public int getDemandQtyMin()
    {
        return this.demandQtyMin;
    }

    /**
     * Sets a value of '<em><b>demandQtyMin</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Minimum weight requested for this production order
     * <!-- end-model-doc -->
     * @generated
     */
    public void setDemandQtyMin( int aDemandQtyMin )
    {
        this.demandQtyMin = aDemandQtyMin;
    }

    /**
     * The cached value of the '{@link #getProducedQty() <em><b>producedQty</b></em>}' attribute.
     * <!-- begin-model-doc -->
     * Assigned weight for this production order
     * <!-- end-model-doc -->
     * @see #getProducedQty()
     * @generated
     */
    @DecimalMin( "0" )
    private Integer producedQty = Integer.valueOf( "0" );

    /**
     * Returns a value of '<em><b>producedQty</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Assigned weight for this production order
     * <!-- end-model-doc -->
     * @generated
     */
    public Integer getProducedQty()
    {
        return this.producedQty;
    }

    /**
     * Sets a value of '<em><b>producedQty</b></em>' attribute.
     * <!-- begin-model-doc -->
     * Assigned weight for this production order
     * <!-- end-model-doc -->
     * @generated
     */
    public void setProducedQty( Integer aProducedQty )
    {
        this.producedQty = aProducedQty;
    }

    /**
     * The cached value of the '{@link #getDueDate() <em><b>dueDate</b></em>}' attribute.
     * @see #getDueDate()
     * @generated
     */
    @Column( nullable = false )
    @Temporal( javax.persistence.TemporalType.DATE )
    private Date dueDate = null;

    /**
     * Returns a value of '<em><b>dueDate</b></em>' attribute.
     * @generated
     */
    public Date getDueDate()
    {
        return this.dueDate;
    }

    /**
     * Sets a value of '<em><b>dueDate</b></em>' attribute.
     * @generated
     */
    public void setDueDate( Date aDueDate )
    {
        this.dueDate = aDueDate;
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
        aBuilder.append( "orderName = " );
        aBuilder.append( getOrderName() );
        aBuilder.append( ", demandQtyMin = " );
        aBuilder.append( getDemandQtyMin() );

        aBuilder.append( ", producedQty = " );
        aBuilder.append( getProducedQty() );

        aBuilder.append( ", dueDate = " );
        aBuilder.append( getDueDate() );
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
