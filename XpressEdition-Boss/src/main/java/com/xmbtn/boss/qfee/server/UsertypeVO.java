/**
 * UsertypeVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class UsertypeVO  implements java.io.Serializable {
    private String company_id;

    private String companyname;

    private String organiseid;

    private String organisename;

    private String usertype;

    public UsertypeVO() {
    }

    public UsertypeVO(
           String company_id,
           String companyname,
           String organiseid,
           String organisename,
           String usertype) {
           this.company_id = company_id;
           this.companyname = companyname;
           this.organiseid = organiseid;
           this.organisename = organisename;
           this.usertype = usertype;
    }


    /**
     * Gets the company_id value for this UsertypeVO.
     * 
     * @return company_id
     */
    public String getCompany_id() {
        return company_id;
    }


    /**
     * Sets the company_id value for this UsertypeVO.
     * 
     * @param company_id
     */
    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }


    /**
     * Gets the companyname value for this UsertypeVO.
     * 
     * @return companyname
     */
    public String getCompanyname() {
        return companyname;
    }


    /**
     * Sets the companyname value for this UsertypeVO.
     * 
     * @param companyname
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }


    /**
     * Gets the organiseid value for this UsertypeVO.
     * 
     * @return organiseid
     */
    public String getOrganiseid() {
        return organiseid;
    }


    /**
     * Sets the organiseid value for this UsertypeVO.
     * 
     * @param organiseid
     */
    public void setOrganiseid(String organiseid) {
        this.organiseid = organiseid;
    }


    /**
     * Gets the organisename value for this UsertypeVO.
     * 
     * @return organisename
     */
    public String getOrganisename() {
        return organisename;
    }


    /**
     * Sets the organisename value for this UsertypeVO.
     * 
     * @param organisename
     */
    public void setOrganisename(String organisename) {
        this.organisename = organisename;
    }


    /**
     * Gets the usertype value for this UsertypeVO.
     * 
     * @return usertype
     */
    public String getUsertype() {
        return usertype;
    }


    /**
     * Sets the usertype value for this UsertypeVO.
     * 
     * @param usertype
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UsertypeVO)) return false;
        UsertypeVO other = (UsertypeVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.company_id==null && other.getCompany_id()==null) || 
             (this.company_id!=null &&
              this.company_id.equals(other.getCompany_id()))) &&
            ((this.companyname==null && other.getCompanyname()==null) || 
             (this.companyname!=null &&
              this.companyname.equals(other.getCompanyname()))) &&
            ((this.organiseid==null && other.getOrganiseid()==null) || 
             (this.organiseid!=null &&
              this.organiseid.equals(other.getOrganiseid()))) &&
            ((this.organisename==null && other.getOrganisename()==null) || 
             (this.organisename!=null &&
              this.organisename.equals(other.getOrganisename()))) &&
            ((this.usertype==null && other.getUsertype()==null) || 
             (this.usertype!=null &&
              this.usertype.equals(other.getUsertype())));
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
        if (getCompany_id() != null) {
            _hashCode += getCompany_id().hashCode();
        }
        if (getCompanyname() != null) {
            _hashCode += getCompanyname().hashCode();
        }
        if (getOrganiseid() != null) {
            _hashCode += getOrganiseid().hashCode();
        }
        if (getOrganisename() != null) {
            _hashCode += getOrganisename().hashCode();
        }
        if (getUsertype() != null) {
            _hashCode += getUsertype().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UsertypeVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "usertypeVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "company_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organiseid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organiseid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organisename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organisename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usertype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usertype"));
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
