/**
 * CustomerTransVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class CustomerTransVO  implements java.io.Serializable {
    private String acct_type;

    private String change_time;

    private String change_type;

    private java.math.BigDecimal money;

    private java.math.BigDecimal old_acct_balance;

    public CustomerTransVO() {
    }

    public CustomerTransVO(
           String acct_type,
           String change_time,
           String change_type,
           java.math.BigDecimal money,
           java.math.BigDecimal old_acct_balance) {
           this.acct_type = acct_type;
           this.change_time = change_time;
           this.change_type = change_type;
           this.money = money;
           this.old_acct_balance = old_acct_balance;
    }


    /**
     * Gets the acct_type value for this CustomerTransVO.
     * 
     * @return acct_type
     */
    public String getAcct_type() {
        return acct_type;
    }


    /**
     * Sets the acct_type value for this CustomerTransVO.
     * 
     * @param acct_type
     */
    public void setAcct_type(String acct_type) {
        this.acct_type = acct_type;
    }


    /**
     * Gets the change_time value for this CustomerTransVO.
     * 
     * @return change_time
     */
    public String getChange_time() {
        return change_time;
    }


    /**
     * Sets the change_time value for this CustomerTransVO.
     * 
     * @param change_time
     */
    public void setChange_time(String change_time) {
        this.change_time = change_time;
    }


    /**
     * Gets the change_type value for this CustomerTransVO.
     * 
     * @return change_type
     */
    public String getChange_type() {
        return change_type;
    }


    /**
     * Sets the change_type value for this CustomerTransVO.
     * 
     * @param change_type
     */
    public void setChange_type(String change_type) {
        this.change_type = change_type;
    }


    /**
     * Gets the money value for this CustomerTransVO.
     * 
     * @return money
     */
    public java.math.BigDecimal getMoney() {
        return money;
    }


    /**
     * Sets the money value for this CustomerTransVO.
     * 
     * @param money
     */
    public void setMoney(java.math.BigDecimal money) {
        this.money = money;
    }


    /**
     * Gets the old_acct_balance value for this CustomerTransVO.
     * 
     * @return old_acct_balance
     */
    public java.math.BigDecimal getOld_acct_balance() {
        return old_acct_balance;
    }


    /**
     * Sets the old_acct_balance value for this CustomerTransVO.
     * 
     * @param old_acct_balance
     */
    public void setOld_acct_balance(java.math.BigDecimal old_acct_balance) {
        this.old_acct_balance = old_acct_balance;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerTransVO)) return false;
        CustomerTransVO other = (CustomerTransVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acct_type==null && other.getAcct_type()==null) || 
             (this.acct_type!=null &&
              this.acct_type.equals(other.getAcct_type()))) &&
            ((this.change_time==null && other.getChange_time()==null) || 
             (this.change_time!=null &&
              this.change_time.equals(other.getChange_time()))) &&
            ((this.change_type==null && other.getChange_type()==null) || 
             (this.change_type!=null &&
              this.change_type.equals(other.getChange_type()))) &&
            ((this.money==null && other.getMoney()==null) || 
             (this.money!=null &&
              this.money.equals(other.getMoney()))) &&
            ((this.old_acct_balance==null && other.getOld_acct_balance()==null) || 
             (this.old_acct_balance!=null &&
              this.old_acct_balance.equals(other.getOld_acct_balance())));
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
        if (getAcct_type() != null) {
            _hashCode += getAcct_type().hashCode();
        }
        if (getChange_time() != null) {
            _hashCode += getChange_time().hashCode();
        }
        if (getChange_type() != null) {
            _hashCode += getChange_type().hashCode();
        }
        if (getMoney() != null) {
            _hashCode += getMoney().hashCode();
        }
        if (getOld_acct_balance() != null) {
            _hashCode += getOld_acct_balance().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerTransVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "customerTransVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acct_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acct_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("change_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "change_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("change_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "change_type"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("old_acct_balance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "old_acct_balance"));
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
