/**
 * AccountVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class AccountVO  implements java.io.Serializable {
    private com.xmbtn.boss.qfee.server.AccountDetailVO[] detaillist;

    private String feetype;

    private java.math.BigDecimal money;

    public AccountVO() {
    }

    public AccountVO(
           com.xmbtn.boss.qfee.server.AccountDetailVO[] detaillist,
           String feetype,
           java.math.BigDecimal money) {
           this.detaillist = detaillist;
           this.feetype = feetype;
           this.money = money;
    }


    /**
     * Gets the detaillist value for this AccountVO.
     * 
     * @return detaillist
     */
    public com.xmbtn.boss.qfee.server.AccountDetailVO[] getDetaillist() {
        return detaillist;
    }


    /**
     * Sets the detaillist value for this AccountVO.
     * 
     * @param detaillist
     */
    public void setDetaillist(com.xmbtn.boss.qfee.server.AccountDetailVO[] detaillist) {
        this.detaillist = detaillist;
    }

    public com.xmbtn.boss.qfee.server.AccountDetailVO getDetaillist(int i) {
        return this.detaillist[i];
    }

    public void setDetaillist(int i, com.xmbtn.boss.qfee.server.AccountDetailVO _value) {
        this.detaillist[i] = _value;
    }


    /**
     * Gets the feetype value for this AccountVO.
     * 
     * @return feetype
     */
    public String getFeetype() {
        return feetype;
    }


    /**
     * Sets the feetype value for this AccountVO.
     * 
     * @param feetype
     */
    public void setFeetype(String feetype) {
        this.feetype = feetype;
    }


    /**
     * Gets the money value for this AccountVO.
     * 
     * @return money
     */
    public java.math.BigDecimal getMoney() {
        return money;
    }


    /**
     * Sets the money value for this AccountVO.
     * 
     * @param money
     */
    public void setMoney(java.math.BigDecimal money) {
        this.money = money;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AccountVO)) return false;
        AccountVO other = (AccountVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.detaillist==null && other.getDetaillist()==null) || 
             (this.detaillist!=null &&
              java.util.Arrays.equals(this.detaillist, other.getDetaillist()))) &&
            ((this.feetype==null && other.getFeetype()==null) || 
             (this.feetype!=null &&
              this.feetype.equals(other.getFeetype()))) &&
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
        if (getDetaillist() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDetaillist());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getDetaillist(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFeetype() != null) {
            _hashCode += getFeetype().hashCode();
        }
        if (getMoney() != null) {
            _hashCode += getMoney().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "accountVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detaillist");
        elemField.setXmlName(new javax.xml.namespace.QName("", "detaillist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "accountDetailVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feetype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feetype"));
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
