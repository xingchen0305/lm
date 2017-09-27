package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mengying on 2017/9/21.
 */
@Entity
@Table(name = "install_info")
public class Install_info {
    private String id;
    private String installNumber;
    private String goodsNumber;
    private String goodsName;
    private String location;
    private String switchNumber;
    private String decisionMakerNumber;
    private String decisionMakerName;
    private Date createTime;
    private Date lastUpdate;

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Column(name = "INSTALL_NUMBER")
    public String getInstallNumber() {
        return installNumber;
    }

    public void setInstallNumber(String installNumber) {
        this.installNumber = installNumber;
    }

    @Column(name = "GOODS_NUMBER")
    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    @Column(name = "GOODS_NAME")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "SWITCH_NUMBER")
    public String getSwitchNumber() {
        return switchNumber;
    }

    public void setSwitchNumber(String switchNumber) {
        this.switchNumber = switchNumber;
    }

    @Column(name = "DECISION_MAKER_NUMBER")
    public String getDecisionMakerNumber() {
        return decisionMakerNumber;
    }

    public void setDecisionMakerNumber(String decisionMakerNumber) {
        this.decisionMakerNumber = decisionMakerNumber;
    }

    @Column(name = "DECISION_MAKER_NAME")
    public String getDecisionMakerName() {
        return decisionMakerName;
    }

    public void setDecisionMakerName(String decisionMakerName) {
        this.decisionMakerName = decisionMakerName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "CREATE_TIME", updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
