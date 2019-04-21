/**
 * CustomerBillVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class CustomerBillVO  implements java.io.Serializable {
    private String acct_balance;

    private String cyccount;

    private String discount;

    private String flag;

    private String money;

    private String paymentmoney;

    public CustomerBillVO() {
    }

    public CustomerBillVO(
           String acct_balance,
           String cyccount,
           String discount,
           String flag,
           String money,
           String paymentmoney) {
           this.acct_balance = acct_balance;
           this.cyccount = cyccount;
           this.discount = discount;
           this.flag = flag;
           this.money = money;
           this.paymentmoney = paymentmoney;
    }


    /**
     * Gets the acct_balance value for this CustomerBillVO.
     * 
     * @return acct_balance
     */
    public String getAcct_balance() {
        return acct_balance;
    }


    /**
     * Sets the acct_balance value for this CustomerBillVO.
     * 
     * @param acct_balance
     */
    public void setAcct_balance(String acct_balance) {
        this.acct_balance = acct_balance;
    }


    /**
     * Gets the cyccount value for this CustomerBillVO.
     * 
     * @return cyccount
     */
    public String getCyccount() {
        return cyccount;
    }


    /**
     * Sets the cyccount value for this CustomerBillVO.
     * 
     * @param cyccount
     */
    public void setCyccount(String cyccount) {
        this.cyccount = cyccount;
    }


    /**
     * Gets the discount value for this CustomerBillVO.
     * 
     * @return discount
     */
    public String getDiscount() {
        return discount;
    }


    /**
     * Sets the discount value for this CustomerBillVO.
     * 
     * @param discount
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }


    /**
     * Gets the flag value for this CustomerBillVO.
     * 
     * @return flag
     */
    public String getFlag() {
        return flag;
    }


    /**
     * Sets the flag value for this CustomerBillVO.
     * 
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }


    /**
     * Gets the money value for this CustomerBillVO.
     * 
     * @return money
     */
    public String getMoney() {
        return money;
    }


    /**
     * Sets the money value for this CustomerBillVO.
     * 
     * @param money
     */
    public void setMoney(String money) {
        this.money = money;
    }


    /**
     * Gets the paymentmoney value for this CustomerBillVO.
     * 
     * @return paymentmoney
     */
    public String getPaymentmoney() {
        return paymentmoney;
    }


    /**
     * Sets the paymentmoney value for this CustomerBillVO.
     * 
     * @param paymentmoney
     */
    public void setPaymentmoney(String paymentmoney) {
        this.paymentmoney = paymentmoney;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerBillVO)) return false;
        CustomerBillVO other = (CustomerBillVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acct_balance==null && other.getAcct_balance()==null) || 
             (this.acct_balance!=null &&
              this.acct_balance.equals(other.getAcct_balance()))) &&
            ((this.cyccount==null && other.getCyccount()==null) || 
             (this.cyccount!=null &&
              this.cyccount.equals(other.getCyccount()))) &&
            ((this.discount==null && other.getDiscount()==null) || 
             (this.discount!=null &&
              this.discount.equals(other.getDiscount()))) &&
            ((this.flag==null && other.getFlag()==null) || 
             (this.flag!=null &&
              this.flag.equals(other.getFlag()))) &&
            ((this.money==null && other.getMoney()==null) || 
             (this.money!=null &&
              this.money.equals(other.getMoney()))) &&
            ((this.paymentmoney==null && other.getPaymentmoney()==null) || 
             (this.paymentmoney!=null &&
              this.paymentmoney.equals(other.getPaymentmoney())));
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
        if (getAcct_balance() != null) {
            _hashCode += getAcct_balance().hashCode();
        }
        if (getCyccount() != null) {
            _hashCode += getCyccount().hashCode();
        }
        if (getDiscount() != null) {
            _hashCode += getDiscount().hashCode();
        }
        if (getFlag() != null) {
            _hashCode += getFlag().hashCode();
        }
        if (getMoney() != null) {
            _hashCode += getMoney().hashCode();
        }
        if (getPaymentmoney() != null) {
            _hashCode += getPaymentmoney().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerBillVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "customerBillVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acct_balance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acct_balance"));
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
        elemField.setFieldName("discount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("money");
        elemField.setXmlName(new javax.xml.namespace.QName("", "money"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentmoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentmoney"));
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
