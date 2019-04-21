/**
 * AccountDetailVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class AccountDetailVO  implements java.io.Serializable {
    private String accountno;

    private String cyccount;

    private String feecode;

    private String feename;

    private java.math.BigDecimal money;

    public AccountDetailVO() {
    }

    public AccountDetailVO(
           String accountno,
           String cyccount,
           String feecode,
           String feename,
           java.math.BigDecimal money) {
           this.accountno = accountno;
           this.cyccount = cyccount;
           this.feecode = feecode;
           this.feename = feename;
           this.money = money;
    }


    /**
     * Gets the accountno value for this AccountDetailVO.
     * 
     * @return accountno
     */
    public String getAccountno() {
        return accountno;
    }


    /**
     * Sets the accountno value for this AccountDetailVO.
     * 
     * @param accountno
     */
    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }


    /**
     * Gets the cyccount value for this AccountDetailVO.
     * 
     * @return cyccount
     */
    public String getCyccount() {
        return cyccount;
    }


    /**
     * Sets the cyccount value for this AccountDetailVO.
     * 
     * @param cyccount
     */
    public void setCyccount(String cyccount) {
        this.cyccount = cyccount;
    }


    /**
     * Gets the feecode value for this AccountDetailVO.
     * 
     * @return feecode
     */
    public String getFeecode() {
        return feecode;
    }


    /**
     * Sets the feecode value for this AccountDetailVO.
     * 
     * @param feecode
     */
    public void setFeecode(String feecode) {
        this.feecode = feecode;
    }


    /**
     * Gets the feename value for this AccountDetailVO.
     * 
     * @return feename
     */
    public String getFeename() {
        return feename;
    }


    /**
     * Sets the feename value for this AccountDetailVO.
     * 
     * @param feename
     */
    public void setFeename(String feename) {
        this.feename = feename;
    }


    /**
     * Gets the money value for this AccountDetailVO.
     * 
     * @return money
     */
    public java.math.BigDecimal getMoney() {
        return money;
    }


    /**
     * Sets the money value for this AccountDetailVO.
     * 
     * @param money
     */
    public void setMoney(java.math.BigDecimal money) {
        this.money = money;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AccountDetailVO)) return false;
        AccountDetailVO other = (AccountDetailVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountno==null && other.getAccountno()==null) || 
             (this.accountno!=null &&
              this.accountno.equals(other.getAccountno()))) &&
            ((this.cyccount==null && other.getCyccount()==null) || 
             (this.cyccount!=null &&
              this.cyccount.equals(other.getCyccount()))) &&
            ((this.feecode==null && other.getFeecode()==null) || 
             (this.feecode!=null &&
              this.feecode.equals(other.getFeecode()))) &&
            ((this.feename==null && other.getFeename()==null) || 
             (this.feename!=null &&
              this.feename.equals(other.getFeename()))) &&
            ((this.money==null && other.getMoney()==null) || 
             (this.money!=null &&
              this.money.equals(other.getMoney())));
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
        if (getAccountno() != null) {
            _hashCode += getAccountno().hashCode();
        }
        if (getCyccount() != null) {
            _hashCode += getCyccount().hashCode();
        }
        if (getFeecode() != null) {
            _hashCode += getFeecode().hashCode();
        }
        if (getFeename() != null) {
            _hashCode += getFeename().hashCode();
        }
        if (getMoney() != null) {
            _hashCode += getMoney().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountDetailVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "accountDetailVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cyccount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cyccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feecode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("money");
        elemField.setXmlName(new javax.xml.namespace.QName("", "money"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
