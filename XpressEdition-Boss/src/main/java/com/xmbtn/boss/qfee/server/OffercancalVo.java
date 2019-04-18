/**
 * OffercancalVo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class OffercancalVo  implements java.io.Serializable {
    private String cust_no;

    private String endtime;

    private String offer_id;

    private String operatorCode;

    private String stbcode;

    public OffercancalVo() {
    }

    public OffercancalVo(
           String cust_no,
           String endtime,
           String offer_id,
           String operatorCode,
           String stbcode) {
           this.cust_no = cust_no;
           this.endtime = endtime;
           this.offer_id = offer_id;
           this.operatorCode = operatorCode;
           this.stbcode = stbcode;
    }


    /**
     * Gets the customerNo value for this OffercancalVo.
     * 
     * @return customerNo
     */
    public String getCust_no() {
        return cust_no;
    }


    /**
     * Sets the customerNo value for this OffercancalVo.
     * 
     * @param cust_no
     */
    public void setCust_no(String cust_no) {
        this.cust_no = cust_no;
    }


    /**
     * Gets the endtime value for this OffercancalVo.
     * 
     * @return endtime
     */
    public String getEndtime() {
        return endtime;
    }


    /**
     * Sets the endtime value for this OffercancalVo.
     * 
     * @param endtime
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }


    /**
     * Gets the offer_id value for this OffercancalVo.
     * 
     * @return offer_id
     */
    public String getOffer_id() {
        return offer_id;
    }


    /**
     * Sets the offer_id value for this OffercancalVo.
     * 
     * @param offer_id
     */
    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }


    /**
     * Gets the operatorCode value for this OffercancalVo.
     * 
     * @return operatorCode
     */
    public String getOperatorCode() {
        return operatorCode;
    }


    /**
     * Sets the operatorCode value for this OffercancalVo.
     * 
     * @param operatorCode
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }


    /**
     * Gets the stbCode value for this OffercancalVo.
     * 
     * @return stbCode
     */
    public String getStbcode() {
        return stbcode;
    }


    /**
     * Sets the stbCode value for this OffercancalVo.
     * 
     * @param stbcode
     */
    public void setStbcode(String stbcode) {
        this.stbcode = stbcode;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof OffercancalVo)) return false;
        OffercancalVo other = (OffercancalVo) obj;
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
            ((this.endtime==null && other.getEndtime()==null) || 
             (this.endtime!=null &&
              this.endtime.equals(other.getEndtime()))) &&
            ((this.offer_id==null && other.getOffer_id()==null) || 
             (this.offer_id!=null &&
              this.offer_id.equals(other.getOffer_id()))) &&
            ((this.operatorCode==null && other.getOperatorCode()==null) || 
             (this.operatorCode!=null &&
              this.operatorCode.equals(other.getOperatorCode()))) &&
            ((this.stbcode==null && other.getStbcode()==null) || 
             (this.stbcode!=null &&
              this.stbcode.equals(other.getStbcode())));
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
        if (getEndtime() != null) {
            _hashCode += getEndtime().hashCode();
        }
        if (getOffer_id() != null) {
            _hashCode += getOffer_id().hashCode();
        }
        if (getOperatorCode() != null) {
            _hashCode += getOperatorCode().hashCode();
        }
        if (getStbcode() != null) {
            _hashCode += getStbcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OffercancalVo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "offercancalVo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNo"));
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
        elemField.setFieldName("offer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offer_id"));
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
        elemField.setFieldName("stbCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stbCode"));
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
