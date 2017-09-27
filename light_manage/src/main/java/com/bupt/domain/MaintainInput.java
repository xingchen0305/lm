package com.bupt.domain;

import com.bupt.common.base.BaseUuidEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by CJ on 2017/9/21.
 */
@Entity
@Table(name = "maintain_input")
public class MaintainInput extends BaseUuidEntity{
   /* MAINTAIN_NUMBER	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    MAINTAINER_NUMBER	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    MAINTAINER_NAME	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    INPUT_NUMBER	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    INPUT_NAME	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    REMARKS	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0*/
    private String inputNumber;
    private String inputName;
    private String maintainerName;
    private String maintainerNumber;
    private String maintainNumber;
    private String remarks;

    public MaintainInput(){}
    public MaintainInput(MaintainInput maintainInput){
        this.id=maintainInput.getId();
        this.inputName=maintainInput.getInputName();
        this.inputNumber=maintainInput.getInputNumber();
        this.maintainerName=maintainInput.getMaintainerName();
        this.maintainerNumber=maintainInput.getMaintainerNumber();
        this.maintainNumber=maintainInput.getMaintainNumber();
        this.remarks=maintainInput.getRemarks();

    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getMaintainerName() {
        return maintainerName;
    }

    public void setMaintainerName(String maintainerName) {
        this.maintainerName = maintainerName;
    }

    public String getMaintainerNumber() {
        return maintainerNumber;
    }

    public void setMaintainerNumber(String maintainerNumber) {
        this.maintainerNumber = maintainerNumber;
    }

    public String getMaintainNumber() {
        return maintainNumber;
    }

    public void setMaintainNumber(String maintainNumber) {
        this.maintainNumber = maintainNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
