/**
 * CustomerCardVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class CustomerCardVO  implements java.io.Serializable {
    private String applyTypeName;

    private String cardno;

    private String purc_date;

    private String status;

    private String subscriberid;

    public CustomerCardVO() {
    }

    public CustomerCardVO(
           String applyTypeName,
           String cardno,
           String purc_date,
           String status,
           String subscriberid) {
           this.applyTypeName = applyTypeName;
           this.cardno = cardno;
           this.purc_date = purc_date;
           this.status = status;
           this.subscriberid = subscriberid;
    }


    /**
     * Gets the applyTypeName value for this CustomerCardVO.
     * 
     * @return applyTypeName
     */
    public String getApplyTypeName() {
        return applyTypeName;
    }


    /**
     * Sets the applyTypeName value for this CustomerCardVO.
     * 
     * @param applyTypeName
     */
    public void setApplyTypeName(String applyTypeName) {
        this.applyTypeName = applyTypeName;
    }


    /**
     * Gets the cardno value for this CustomerCardVO.
     * 
     * @return cardno
     */
    public String getCardno() {
        return cardno;
    }


    /**
     * Sets the cardno value for this CustomerCardVO.
     * 
     * @param cardno
     */
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }


    /**
     * Gets the purc_date value for this CustomerCardVO.
     * 
     * @return purc_date
     */
    public String getPurc_date() {
        return purc_date;
    }


    /**
     * Sets the purc_date value for this CustomerCardVO.
     * 
     * @param purc_date
     */
    public void setPurc_date(String purc_date) {
        this.purc_date = purc_date;
    }


    /**
     * Gets the status value for this CustomerCardVO.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CustomerCardVO.
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Gets the subscriberId value for this CustomerCardVO.
     * 
     * @return subscriberId
     */
    public String getSubscriberid() {
        return subscriberid;
    }


    /**
     * Sets the subscriberId value for this CustomerCardVO.
     * 
     * @param subscriberid
     */
    public void setSubscriberid(String subscriberid) {
        this.subscriberid = subscriberid;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerCardVO)) return false;
        CustomerCardVO other = (CustomerCardVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applyTypeName==null && other.getApplyTypeName()==null) || 
             (this.applyTypeName!=null &&
              this.applyTypeName.equals(other.getApplyTypeName()))) &&
            ((this.cardno==null && other.getCardno()==null) || 
             (this.cardno!=null &&
              this.cardno.equals(other.getCardno()))) &&
            ((this.purc_date==null && other.getPurc_date()==null) || 
             (this.purc_date!=null &&
              this.purc_date.equals(other.getPurc_date()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.subscriberid==null && other.getSubscriberid()==null) || 
             (this.subscriberid!=null &&
              this.subscriberid.equals(other.getSubscriberid())));
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
        if (getApplyTypeName() != null) {
            _hashCode += getApplyTypeName().hashCode();
        }
        if (getCardno() != null) {
            _hashCode += getCardno().hashCode();
        }
        if (getPurc_date() != null) {
            _hashCode += getPurc_date().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSubscriberid() != null) {
            _hashCode += getSubscriberid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerCardVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "customerCardVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applyTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applyTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purc_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "purc_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscriberId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subscriberId"));
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
