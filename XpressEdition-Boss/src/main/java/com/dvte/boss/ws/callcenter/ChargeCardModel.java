/**
 * ChargeCardModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dvte.boss.ws.callcenter;

public class ChargeCardModel  implements java.io.Serializable {
    private String cust_no;

    private String fillCardPwd;

    private String filltelephone;

    private String operatorCode;

    private String remark;

    public ChargeCardModel() {
    }

    public ChargeCardModel(
           String cust_no,
           String fillCardPwd,
           String filltelephone,
           String operatorCode,
           String remark) {
           this.cust_no = cust_no;
           this.fillCardPwd = fillCardPwd;
           this.filltelephone = filltelephone;
           this.operatorCode = operatorCode;
           this.remark = remark;
    }


    /**
     * Gets the customerNo value for this ChargeCardModel.
     * 
     * @return customerNo
     */
    public String getCust_no() {
        return cust_no;
    }


    /**
     * Sets the customerNo value for this ChargeCardModel.
     * 
     * @param cust_no
     */
    public void setCust_no(String cust_no) {
        this.cust_no = cust_no;
    }


    /**
     * Gets the fillCardPwd value for this ChargeCardModel.
     * 
     * @return fillCardPwd
     */
    public String getFillCardPwd() {
        return fillCardPwd;
    }


    /**
     * Sets the fillCardPwd value for this ChargeCardModel.
     * 
     * @param fillCardPwd
     */
    public void setFillCardPwd(String fillCardPwd) {
        this.fillCardPwd = fillCardPwd;
    }


    /**
     * Gets the filltelephone value for this ChargeCardModel.
     * 
     * @return filltelephone
     */
    public String getFilltelephone() {
        return filltelephone;
    }


    /**
     * Sets the filltelephone value for this ChargeCardModel.
     * 
     * @param filltelephone
     */
    public void setFilltelephone(String filltelephone) {
        this.filltelephone = filltelephone;
    }


    /**
     * Gets the operatorCode value for this ChargeCardModel.
     * 
     * @return operatorCode
     */
    public String getOperatorCode() {
        return operatorCode;
    }


    /**
     * Sets the operatorCode value for this ChargeCardModel.
     * 
     * @param operatorCode
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }


    /**
     * Gets the remark value for this ChargeCardModel.
     * 
     * @return remark
     */
    public String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this ChargeCardModel.
     * 
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ChargeCardModel)) return false;
        ChargeCardModel other = (ChargeCardModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cust_no==null && other.getCust_no()==null) || 
             (this.cust_no!=null &&
              this.cust_no.equals(other.getCust_no()))) &&
            ((this.fillCardPwd==null && other.getFillCardPwd()==null) || 
             (this.fillCardPwd!=null &&
              this.fillCardPwd.equals(other.getFillCardPwd()))) &&
            ((this.filltelephone==null && other.getFilltelephone()==null) || 
             (this.filltelephone!=null &&
              this.filltelephone.equals(other.getFilltelephone()))) &&
            ((this.operatorCode==null && other.getOperatorCode()==null) || 
             (this.operatorCode!=null &&
              this.operatorCode.equals(other.getOperatorCode()))) &&
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCust_no() != null) {
            _hashCode += getCust_no().hashCode();
        }
        if (getFillCardPwd() != null) {
            _hashCode += getFillCardPwd().hashCode();
        }
        if (getFilltelephone() != null) {
            _hashCode += getFilltelephone().hashCode();
        }
        if (getOperatorCode() != null) {
            _hashCode += getOperatorCode().hashCode();
        }
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChargeCardModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://callcenter.ws.boss.dvte.com/", "chargeCardModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fillCardPwd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fillCardPwd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filltelephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filltelephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operatorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
