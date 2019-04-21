/**
 * HsOfferVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class HsOfferVO  implements java.io.Serializable {
    private String begintime;

    private String endtime;

    private String offer_endtime;

    private String offer_id;

    private String offer_name;

    private String order_msg;

    private String order_type;

    private String subscriberid;

    public HsOfferVO() {
    }

    public HsOfferVO(
           String begintime,
           String endtime,
           String offer_endtime,
           String offer_id,
           String offer_name,
           String order_msg,
           String order_type,
           String subscriberid) {
           this.begintime = begintime;
           this.endtime = endtime;
           this.offer_endtime = offer_endtime;
           this.offer_id = offer_id;
           this.offer_name = offer_name;
           this.order_msg = order_msg;
           this.order_type = order_type;
           this.subscriberid = subscriberid;
    }


    /**
     * Gets the begintime value for this HsOfferVO.
     * 
     * @return begintime
     */
    public String getBegintime() {
        return begintime;
    }


    /**
     * Sets the begintime value for this HsOfferVO.
     * 
     * @param begintime
     */
    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }


    /**
     * Gets the endtime value for this HsOfferVO.
     * 
     * @return endtime
     */
    public String getEndtime() {
        return endtime;
    }


    /**
     * Sets the endtime value for this HsOfferVO.
     * 
     * @param endtime
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }


    /**
     * Gets the offer_endtime value for this HsOfferVO.
     * 
     * @return offer_endtime
     */
    public String getOffer_endtime() {
        return offer_endtime;
    }


    /**
     * Sets the offer_endtime value for this HsOfferVO.
     * 
     * @param offer_endtime
     */
    public void setOffer_endtime(String offer_endtime) {
        this.offer_endtime = offer_endtime;
    }


    /**
     * Gets the offer_id value for this HsOfferVO.
     * 
     * @return offer_id
     */
    public String getOffer_id() {
        return offer_id;
    }


    /**
     * Sets the offer_id value for this HsOfferVO.
     * 
     * @param offer_id
     */
    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }


    /**
     * Gets the offer_name value for this HsOfferVO.
     * 
     * @return offer_name
     */
    public String getOffer_name() {
        return offer_name;
    }


    /**
     * Sets the offer_name value for this HsOfferVO.
     * 
     * @param offer_name
     */
    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }


    /**
     * Gets the order_msg value for this HsOfferVO.
     * 
     * @return order_msg
     */
    public String getOrder_msg() {
        return order_msg;
    }


    /**
     * Sets the order_msg value for this HsOfferVO.
     * 
     * @param order_msg
     */
    public void setOrder_msg(String order_msg) {
        this.order_msg = order_msg;
    }


    /**
     * Gets the order_type value for this HsOfferVO.
     * 
     * @return order_type
     */
    public String getOrder_type() {
        return order_type;
    }


    /**
     * Sets the order_type value for this HsOfferVO.
     * 
     * @param order_type
     */
    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }


    /**
     * Gets the subscriberId value for this HsOfferVO.
     * 
     * @return subscriberId
     */
    public String getSubscriberid() {
        return subscriberid;
    }


    /**
     * Sets the subscriberId value for this HsOfferVO.
     * 
     * @param subscriberid
     */
    public void setSubscriberid(String subscriberid) {
        this.subscriberid = subscriberid;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof HsOfferVO)) return false;
        HsOfferVO other = (HsOfferVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.begintime==null && other.getBegintime()==null) || 
             (this.begintime!=null &&
              this.begintime.equals(other.getBegintime()))) &&
            ((this.endtime==null && other.getEndtime()==null) || 
             (this.endtime!=null &&
              this.endtime.equals(other.getEndtime()))) &&
            ((this.offer_endtime==null && other.getOffer_endtime()==null) || 
             (this.offer_endtime!=null &&
              this.offer_endtime.equals(other.getOffer_endtime()))) &&
            ((this.offer_id==null && other.getOffer_id()==null) || 
             (this.offer_id!=null &&
              this.offer_id.equals(other.getOffer_id()))) &&
            ((this.offer_name==null && other.getOffer_name()==null) || 
             (this.offer_name!=null &&
              this.offer_name.equals(other.getOffer_name()))) &&
            ((this.order_msg==null && other.getOrder_msg()==null) || 
             (this.order_msg!=null &&
              this.order_msg.equals(other.getOrder_msg()))) &&
            ((this.order_type==null && other.getOrder_type()==null) || 
             (this.order_type!=null &&
              this.order_type.equals(other.getOrder_type()))) &&
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
        if (getBegintime() != null) {
            _hashCode += getBegintime().hashCode();
        }
        if (getEndtime() != null) {
            _hashCode += getEndtime().hashCode();
        }
        if (getOffer_endtime() != null) {
            _hashCode += getOffer_endtime().hashCode();
        }
        if (getOffer_id() != null) {
            _hashCode += getOffer_id().hashCode();
        }
        if (getOffer_name() != null) {
            _hashCode += getOffer_name().hashCode();
        }
        if (getOrder_msg() != null) {
            _hashCode += getOrder_msg().hashCode();
        }
        if (getOrder_type() != null) {
            _hashCode += getOrder_type().hashCode();
        }
        if (getSubscriberid() != null) {
            _hashCode += getSubscriberid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HsOfferVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "hsOfferVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("begintime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "begintime"));
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
        elemField.setFieldName("offer_endtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offer_endtime"));
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
        elemField.setFieldName("offer_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offer_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_msg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "order_msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "order_type"));
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
