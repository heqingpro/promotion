/**
 * CustomerFfpdDetailVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class CustomerFfpdDetailVO  implements java.io.Serializable {
    private String cardno;

    private java.math.BigDecimal discount;

    private String feename;

    private java.math.BigDecimal money;

    private java.math.BigDecimal price;

    public CustomerFfpdDetailVO() {
    }

    public CustomerFfpdDetailVO(
           String cardno,
           java.math.BigDecimal discount,
           String feename,
           java.math.BigDecimal money,
           java.math.BigDecimal price) {
           this.cardno = cardno;
           this.discount = discount;
           this.feename = feename;
           this.money = money;
           this.price = price;
    }


    /**
     * Gets the cardno value for this CustomerFfpdDetailVO.
     * 
     * @return cardno
     */
    public String getCardno() {
        return cardno;
    }


    /**
     * Sets the cardno value for this CustomerFfpdDetailVO.
     * 
     * @param cardno
     */
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }


    /**
     * Gets the discount value for this CustomerFfpdDetailVO.
     * 
     * @return discount
     */
    public java.math.BigDecimal getDiscount() {
        return discount;
    }


    /**
     * Sets the discount value for this CustomerFfpdDetailVO.
     * 
     * @param discount
     */
    public void setDiscount(java.math.BigDecimal discount) {
        this.discount = discount;
    }


    /**
     * Gets the feename value for this CustomerFfpdDetailVO.
     * 
     * @return feename
     */
    public String getFeename() {
        return feename;
    }


    /**
     * Sets the feename value for this CustomerFfpdDetailVO.
     * 
     * @param feename
     */
    public void setFeename(String feename) {
        this.feename = feename;
    }


    /**
     * Gets the money value for this CustomerFfpdDetailVO.
     * 
     * @return money
     */
    public java.math.BigDecimal getMoney() {
        return money;
    }


    /**
     * Sets the money value for this CustomerFfpdDetailVO.
     * 
     * @param money
     */
    public void setMoney(java.math.BigDecimal money) {
        this.money = money;
    }


    /**
     * Gets the price value for this CustomerFfpdDetailVO.
     * 
     * @return price
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }


    /**
     * Sets the price value for this CustomerFfpdDetailVO.
     * 
     * @param price
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerFfpdDetailVO)) return false;
        CustomerFfpdDetailVO other = (CustomerFfpdDetailVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cardno==null && other.getCardno()==null) || 
             (this.cardno!=null &&
              this.cardno.equals(other.getCardno()))) &&
            ((this.discount==null && other.getDiscount()==null) || 
             (this.discount!=null &&
              this.discount.equals(other.getDiscount()))) &&
            ((this.feename==null && other.getFeename()==null) || 
             (this.feename!=null &&
              this.feename.equals(other.getFeename()))) &&
            ((this.money==null && other.getMoney()==null) || 
             (this.money!=null &&
              this.money.equals(other.getMoney()))) &&
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice())));
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
        if (getCardno() != null) {
            _hashCode += getCardno().hashCode();
        }
        if (getDiscount() != null) {
            _hashCode += getDiscount().hashCode();
        }
        if (getFeename() != null) {
            _hashCode += getFeename().hashCode();
        }
        if (getMoney() != null) {
            _hashCode += getMoney().hashCode();
        }
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerFfpdDetailVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "customerFfpdDetailVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
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
