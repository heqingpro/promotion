/**
 * ResourcesinfoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class ResourcesinfoVO  implements java.io.Serializable {
    private String resources_id;

    private String resources_name;

    public ResourcesinfoVO() {
    }

    public ResourcesinfoVO(
           String resources_id,
           String resources_name) {
           this.resources_id = resources_id;
           this.resources_name = resources_name;
    }


    /**
     * Gets the resources_id value for this ResourcesinfoVO.
     * 
     * @return resources_id
     */
    public String getResources_id() {
        return resources_id;
    }


    /**
     * Sets the resources_id value for this ResourcesinfoVO.
     * 
     * @param resources_id
     */
    public void setResources_id(String resources_id) {
        this.resources_id = resources_id;
    }


    /**
     * Gets the resources_name value for this ResourcesinfoVO.
     * 
     * @return resources_name
     */
    public String getResources_name() {
        return resources_name;
    }


    /**
     * Sets the resources_name value for this ResourcesinfoVO.
     * 
     * @param resources_name
     */
    public void setResources_name(String resources_name) {
        this.resources_name = resources_name;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ResourcesinfoVO)) return false;
        ResourcesinfoVO other = (ResourcesinfoVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resources_id==null && other.getResources_id()==null) || 
             (this.resources_id!=null &&
              this.resources_id.equals(other.getResources_id()))) &&
            ((this.resources_name==null && other.getResources_name()==null) || 
             (this.resources_name!=null &&
              this.resources_name.equals(other.getResources_name())));
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
        if (getResources_id() != null) {
            _hashCode += getResources_id().hashCode();
        }
        if (getResources_name() != null) {
            _hashCode += getResources_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResourcesinfoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "resourcesinfoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resources_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resources_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resources_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resources_name"));
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
