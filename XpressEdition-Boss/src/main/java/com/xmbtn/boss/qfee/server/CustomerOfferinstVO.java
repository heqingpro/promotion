/**
 * CustomerOfferinstVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class CustomerOfferinstVO  implements java.io.Serializable {
    private String begindate;

    private String enddate;

    private String offer_name;

    private String orderedtime;

    private String prod_price;

    private String status;

    public CustomerOfferinstVO() {
    }

    public CustomerOfferinstVO(
           String begindate,
           String enddate,
           String offer_name,
           String orderedtime,
           String prod_price,
           String status) {
           this.begindate = begindate;
           this.enddate = enddate;
           this.offer_name = offer_name;
           this.orderedtime = orderedtime;
           this.prod_price = prod_price;
           this.status = status;
    }


    /**
     * Gets the begindate value for this CustomerOfferinstVO.
     * 
     * @return begindate
     */
    public String getBegindate() {
        return begindate;
    }


    /**
     * Sets the begindate value for this CustomerOfferinstVO.
     * 
     * @param begindate
     */
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }


    /**
     * Gets the enddate value for this CustomerOfferinstVO.
     * 
     * @return enddate
     */
    public String getEnddate() {
        return enddate;
    }


    /**
     * Sets the enddate value for this CustomerOfferinstVO.
     * 
     * @param enddate
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }


    /**
     * Gets the offer_name value for this CustomerOfferinstVO.
     * 
     * @return offer_name
     */
    public String getOffer_name() {
        return offer_name;
    }


    /**
     * Sets the offer_name value for this CustomerOfferinstVO.
     * 
     * @param offer_name
     */
    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }


    /**
     * Gets the orderedtime value for this CustomerOfferinstVO.
     * 
     * @return orderedtime
     */
    public String getOrderedtime() {
        return orderedtime;
    }


    /**
     * Sets the orderedtime value for this CustomerOfferinstVO.
     * 
     * @param orderedtime
     */
    public void setOrderedtime(String orderedtime) {
        this.orderedtime = orderedtime;
    }


    /**
     * Gets the prod_price value for this CustomerOfferinstVO.
     * 
     * @return prod_price
     */
    public String getProd_price() {
        return prod_price;
    }


    /**
     * Sets the prod_price value for this CustomerOfferinstVO.
     * 
     * @param prod_price
     */
    public void setProd_price(String prod_price) {
        this.prod_price = prod_price;
    }


    /**
     * Gets the status value for this CustomerOfferinstVO.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CustomerOfferinstVO.
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerOfferinstVO)) return false;
        CustomerOfferinstVO other = (CustomerOfferinstVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.begindate==null && other.getBegindate()==null) || 
             (this.begindate!=null &&
              this.begindate.equals(other.getBegindate()))) &&
            ((this.enddate==null && other.getEnddate()==null) || 
             (this.enddate!=null &&
              this.enddate.equals(other.getEnddate()))) &&
            ((this.offer_name==null && other.getOffer_name()==null) || 
             (this.offer_name!=null &&
              this.offer_name.equals(other.getOffer_name()))) &&
            ((this.orderedtime==null && other.getOrderedtime()==null) || 
             (this.orderedtime!=null &&
              this.orderedtime.equals(other.getOrderedtime()))) &&
            ((this.prod_price==null && other.getProd_price()==null) || 
             (this.prod_price!=null &&
              this.prod_price.equals(other.getProd_price()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getBegindate() != null) {
            _hashCode += getBegindate().hashCode();
        }
        if (getEnddate() != null) {
            _hashCode += getEnddate().hashCode();
        }
        if (getOffer_name() != null) {
            _hashCode += getOffer_name().hashCode();
        }
        if (getOrderedtime() != null) {
            _hashCode += getOrderedtime().hashCode();
        }
        if (getProd_price() != null) {
            _hashCode += getProd_price().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerOfferinstVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "customerOfferinstVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("begindate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "begindate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offer_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offer_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderedtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderedtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prod_price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prod_price"));
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
