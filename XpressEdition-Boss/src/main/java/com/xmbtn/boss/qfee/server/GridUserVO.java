/**
 * GridUserVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class GridUserVO  implements java.io.Serializable {
    private String business_type;

    private String company_name;

    private String grid_organisename;

    private String large_grid_name;

    private String region_name;

    private String stat_time;

    private String user_count;

    public GridUserVO() {
    }

    public GridUserVO(
           String business_type,
           String company_name,
           String grid_organisename,
           String large_grid_name,
           String region_name,
           String stat_time,
           String user_count) {
           this.business_type = business_type;
           this.company_name = company_name;
           this.grid_organisename = grid_organisename;
           this.large_grid_name = large_grid_name;
           this.region_name = region_name;
           this.stat_time = stat_time;
           this.user_count = user_count;
    }


    /**
     * Gets the business_type value for this GridUserVO.
     * 
     * @return business_type
     */
    public String getBusiness_type() {
        return business_type;
    }


    /**
     * Sets the business_type value for this GridUserVO.
     * 
     * @param business_type
     */
    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }


    /**
     * Gets the companyName value for this GridUserVO.
     * 
     * @return companyName
     */
    public String getCompany_name() {
        return company_name;
    }


    /**
     * Sets the companyName value for this GridUserVO.
     * 
     * @param company_name
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }


    /**
     * Gets the grid_organisename value for this GridUserVO.
     * 
     * @return grid_organisename
     */
    public String getGrid_organisename() {
        return grid_organisename;
    }


    /**
     * Sets the grid_organisename value for this GridUserVO.
     * 
     * @param grid_organisename
     */
    public void setGrid_organisename(String grid_organisename) {
        this.grid_organisename = grid_organisename;
    }


    /**
     * Gets the large_grid_name value for this GridUserVO.
     * 
     * @return large_grid_name
     */
    public String getLarge_grid_name() {
        return large_grid_name;
    }


    /**
     * Sets the large_grid_name value for this GridUserVO.
     * 
     * @param large_grid_name
     */
    public void setLarge_grid_name(String large_grid_name) {
        this.large_grid_name = large_grid_name;
    }


    /**
     * Gets the region_name value for this GridUserVO.
     * 
     * @return region_name
     */
    public String getRegion_name() {
        return region_name;
    }


    /**
     * Sets the region_name value for this GridUserVO.
     * 
     * @param region_name
     */
    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }


    /**
     * Gets the stat_time value for this GridUserVO.
     * 
     * @return stat_time
     */
    public String getStat_time() {
        return stat_time;
    }


    /**
     * Sets the stat_time value for this GridUserVO.
     * 
     * @param stat_time
     */
    public void setStat_time(String stat_time) {
        this.stat_time = stat_time;
    }


    /**
     * Gets the user_count value for this GridUserVO.
     * 
     * @return user_count
     */
    public String getUser_count() {
        return user_count;
    }


    /**
     * Sets the user_count value for this GridUserVO.
     * 
     * @param user_count
     */
    public void setUser_count(String user_count) {
        this.user_count = user_count;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GridUserVO)) return false;
        GridUserVO other = (GridUserVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.business_type==null && other.getBusiness_type()==null) || 
             (this.business_type!=null &&
              this.business_type.equals(other.getBusiness_type()))) &&
            ((this.company_name==null && other.getCompany_name()==null) || 
             (this.company_name!=null &&
              this.company_name.equals(other.getCompany_name()))) &&
            ((this.grid_organisename==null && other.getGrid_organisename()==null) || 
             (this.grid_organisename!=null &&
              this.grid_organisename.equals(other.getGrid_organisename()))) &&
            ((this.large_grid_name==null && other.getLarge_grid_name()==null) || 
             (this.large_grid_name!=null &&
              this.large_grid_name.equals(other.getLarge_grid_name()))) &&
            ((this.region_name==null && other.getRegion_name()==null) || 
             (this.region_name!=null &&
              this.region_name.equals(other.getRegion_name()))) &&
            ((this.stat_time==null && other.getStat_time()==null) || 
             (this.stat_time!=null &&
              this.stat_time.equals(other.getStat_time()))) &&
            ((this.user_count==null && other.getUser_count()==null) || 
             (this.user_count!=null &&
              this.user_count.equals(other.getUser_count())));
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
        if (getBusiness_type() != null) {
            _hashCode += getBusiness_type().hashCode();
        }
        if (getCompany_name() != null) {
            _hashCode += getCompany_name().hashCode();
        }
        if (getGrid_organisename() != null) {
            _hashCode += getGrid_organisename().hashCode();
        }
        if (getLarge_grid_name() != null) {
            _hashCode += getLarge_grid_name().hashCode();
        }
        if (getRegion_name() != null) {
            _hashCode += getRegion_name().hashCode();
        }
        if (getStat_time() != null) {
            _hashCode += getStat_time().hashCode();
        }
        if (getUser_count() != null) {
            _hashCode += getUser_count().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GridUserVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "gridUserVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("business_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "business_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grid_organisename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grid_organisename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("large_grid_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "large_grid_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("region_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "region_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stat_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stat_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_count");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_count"));
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
