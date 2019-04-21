/**
 * HdEffectiveVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class HdEffectiveVO  implements java.io.Serializable {
    private String begindate;

    private String enddate;

    private String offer_id;

    private String offer_name;

    private String pack_type;

    private String subscriberid;

    public HdEffectiveVO() {
    }

    public HdEffectiveVO(
           String begindate,
           String enddate,
           String offer_id,
           String offer_name,
           String pack_type,
           String subscriberid) {
           this.begindate = begindate;
           this.enddate = enddate;
           this.offer_id = offer_id;
           this.offer_name = offer_name;
           this.pack_type = pack_type;
           this.subscriberid = subscriberid;
    }


    /**
     * Gets the begindate value for this HdEffectiveVO.
     * 
     * @return begindate
     */
    public String getBegindate() {
        return begindate;
    }


    /**
     * Sets the begindate value for this HdEffectiveVO.
     * 
     * @param begindate
     */
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }


    /**
     * Gets the enddate value for this HdEffectiveVO.
     * 
     * @return enddate
     */
    public String getEnddate() {
        return enddate;
    }


    /**
     * Sets the enddate value for this HdEffectiveVO.
     * 
     * @param enddate
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }


    /**
     * Gets the offer_id value for this HdEffectiveVO.
     * 
     * @return offer_id
     */
    public String getOffer_id() {
        return offer_id;
    }


    /**
     * Sets the offer_id value for this HdEffectiveVO.
     * 
     * @param offer_id
     */
    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }


    /**
     * Gets the offer_name value for this HdEffectiveVO.
     * 
     * @return offer_name
     */
    public String getOffer_name() {
        return offer_name;
    }


    /**
     * Sets the offer_name value for this HdEffectiveVO.
     * 
     * @param offer_name
     */
    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }


    /**
     * Gets the pack_type value for this HdEffectiveVO.
     * 
     * @return pack_type
     */
    public String getPack_type() {
        return pack_type;
    }


    /**
     * Sets the pack_type value for this HdEffectiveVO.
     * 
     * @param pack_type
     */
    public void setPack_type(String pack_type) {
        this.pack_type = pack_type;
    }


    /**
     * Gets the subscriberId value for this HdEffectiveVO.
     * 
     * @return subscriberId
     */
    public String getSubscriberid() {
        return subscriberid;
    }


    /**
     * Sets the subscriberId value for this HdEffectiveVO.
     * 
     * @param subscriberid
     */
    public void setSubscriberid(String subscriberid) {
        this.subscriberid = subscriberid;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof HdEffectiveVO)) return false;
        HdEffectiveVO other = (HdEffectiveVO) obj;
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
            ((this.offer_id==null && other.getOffer_id()==null) || 
             (this.offer_id!=null &&
              this.offer_id.equals(other.getOffer_id()))) &&
            ((this.offer_name==null && other.getOffer_name()==null) || 
             (this.offer_name!=null &&
              this.offer_name.equals(other.getOffer_name()))) &&
            ((this.pack_type==null && other.getPack_type()==null) || 
             (this.pack_type!=null &&
              this.pack_type.equals(other.getPack_type()))) &&
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
        if (getBegindate() != null) {
            _hashCode += getBegindate().hashCode();
        }
        if (getEnddate() != null) {
            _hashCode += getEnddate().hashCode();
        }
        if (getOffer_id() != null) {
            _hashCode += getOffer_id().hashCode();
        }
        if (getOffer_name() != null) {
            _hashCode += getOffer_name().hashCode();
        }
        if (getPack_type() != null) {
            _hashCode += getPack_type().hashCode();
        }
        if (getSubscriberid() != null) {
            _hashCode += getSubscriberid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HdEffectiveVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "hdEffectiveVO"));
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
        elemField.setFieldName("pack_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pack_type"));
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
