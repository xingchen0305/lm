package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Stadpole on 2017/9/21.
 */
@Entity
@Table(name="purchase_info")
public class Purchase {
    private String id;
    private Date createTime;
    private Date lastUpdate;
    private String  purchaseNumber;
    private String name;
    private Double power;
    private BigDecimal price;
    private String type;
    private String purchaseManagerNumbert;  //下发采购单人员编号
    private String purchaseManagerName;  //下发采购单人员姓名
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)//指定映射数据库中的日期事件类型
    @CreationTimestamp
    @Column(name= "CREATE_TIME", updatable = false )
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    @Basic
    @Column(name = "PURCHASE_NUMBER")
    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }
    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "POWER")
    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }
    @Basic
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Basic
    @Column(name = "PURCHASE_M_NUMBER")
    public String getPurchaseManagerNumbert() {
        return purchaseManagerNumbert;
    }

    public void setPurchaseManagerNumbert(String purchaseManagerNumbert) {
        this.purchaseManagerNumbert = purchaseManagerNumbert;
    }
    @Basic
    @Column(name = "PURCHASE_M_NAME")
    public String getPurchaseManagerName() {
        return purchaseManagerName;
    }

    public void setPurchaseManagerName(String purchaseManagerName) {
        this.purchaseManagerName = purchaseManagerName;
    }
}
