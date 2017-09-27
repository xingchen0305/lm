package com.bupt.domain;

import com.bupt.common.base.BaseUuidEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by CJ on 2017/9/21.
 */
@Entity
@Table(name = "check_info")
public class CheckInfo extends BaseUuidEntity{
/*    NUMBER	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    AUDITOR_NUMBER	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    AUDITOR_NAME	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    TYPE	int	11	0	-1	0	0	0	0		0					0	0
    RESULT	varchar	64	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    REMARKS	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0*/
    private String number;
    private String auditorName;
    private String auditorNumber;
    private Integer type;
    private String result;
    private String remarks;
    public CheckInfo(){}
    public CheckInfo(CheckInfo checkInfo){
        this.id=checkInfo.getId();
        this.auditorName=checkInfo.getAuditorName();
        this.auditorNumber=checkInfo.getAuditorNumber();
        this.remarks=checkInfo.getRemarks();
        this.number=checkInfo.getNumber();
        this.result=checkInfo.getResult();
        this.type=checkInfo.getType();
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAuditorNumber() {
        return auditorNumber;
    }

    public void setAuditorNumber(String auditorNumber) {
        this.auditorNumber = auditorNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
