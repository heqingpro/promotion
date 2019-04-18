/**
 * HsCheckCancelVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class HsCheckCancelVO  implements java.io.Serializable {
    private String cancel_code;

    private String cancel_msg;

    private String effectivetime;

    private String endtime;

    private String offerids;

    public HsCheckCancelVO() {
    }

    public HsCheckCancelVO(
           String cancel_code,
           String cancel_msg,
           String effectivetime,
           String endtime,
           String offerids) {
           this.cancel_code = cancel_code;
           this.cancel_msg = cancel_msg;
           this.effectivetime = effectivetime;
           this.endtime = endtime;
           this.offerids = offerids;
    }


    /**
     * Gets the cancel_code value for this HsCheckCancelVO.
     * 
     * @return cancel_code
     */
    public String getCancel_code() {
        return cancel_code;
    }


    /**
     * Sets the cancel_code value for this HsCheckCancelVO.
     * 
     * @param cancel_code
     */
    public void setCancel_code(String cancel_code) {
        this.cancel_code = cancel_code;
    }


    /**
     * Gets the cancel_msg value for this HsCheckCancelVO.
     * 
     * @return cancel_msg
     */
    public String getCancel_msg() {
        return cancel_msg;
    }


    /**
     * Sets the cancel_msg value for this HsCheckCancelVO.
     * 
     * @param cancel_msg
     */
    public void setCancel_msg(String cancel_msg) {
        this.cancel_msg = cancel_msg;
    }


    /**
     * Gets the effectivetime value for this HsCheckCancelVO.
     * 
     * @return effectivetime
     */
    public String getEffectivetime() {
        return effectivetime;
    }


    /**
     * Sets the effectivetime value for this HsCheckCancelVO.
     * 
     * @param effectivetime
     */
    public void setEffectivetime(String effectivetime) {
        this.effectivetime = effectivetime;
    }


    /**
     * Gets the endtime value for this HsCheckCancelVO.
     * 
     * @return endtime
     */
    public String getEndtime() {
        return endtime;
    }


    /**
     * Sets the endtime value for this HsCheckCancelVO.
     * 
     * @param endtime
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }


    /**
     * Gets the offerids value for this HsCheckCancelVO.
     * 
     * @return offerids
     */
    public String getOfferids() {
        return offerids;
    }


    /**
     * Sets the offerids value for this HsCheckCancelVO.
     * 
     * @param offerids
     */
    public void setOfferids(String offerids) {
        this.offerids = offerids;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof HsCheckCancelVO)) return false;
        HsCheckCancelVO other = (HsCheckCancelVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cancel_code==null && other.getCancel_code()==null) || 
             (this.cancel_code!=null &&
              this.cancel_code.equals(other.getCancel_code()))) &&
            ((this.cancel_msg==null && other.getCancel_msg()==null) || 
             (this.cancel_msg!=null &&
              this.cancel_msg.equals(other.getCancel_msg()))) &&
            ((this.effectivetime==null && other.getEffectivetime()==null) || 
             (this.effectivetime!=null &&
              this.effectivetime.equals(other.getEffectivetime()))) &&
            ((this.endtime==null && other.getEndtime()==null) || 
             (this.endtime!=null &&
              this.endtime.equals(other.getEndtime()))) &&
            ((this.offerids==null && other.getOfferids()==null) || 
             (this.offerids!=null &&
              this.offerids.equals(other.getOfferids())));
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
        if (getCancel_code() != null) {
            _hashCode += getCancel_code().hashCode();
        }
        if (getCancel_msg() != null) {
            _hashCode += getCancel_msg().hashCode();
        }
        if (getEffectivetime() != null) {
            _hashCode += getEffectivetime().hashCode();
        }
        if (getEndtime() != null) {
            _hashCode += getEndtime().hashCode();
        }
        if (getOfferids() != null) {
            _hashCode += getOfferids().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HsCheckCancelVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "hsCheckCancelVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancel_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancel_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancel_msg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancel_msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectivetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectivetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offerids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offerids"));
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
