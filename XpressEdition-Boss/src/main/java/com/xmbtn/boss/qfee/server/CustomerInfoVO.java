/**
 * CustomerInfoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class CustomerInfoVO  implements java.io.Serializable {
    private String address;

    private String buss_type;

    private String cert_name;

    private String cert_no;

    private String company_name;

    private String cust_name;

    private String cust_no;

    private String homephone;

    private String mobile;

    private String money;

    private String password;

    private String status;

    private String stbcode;

    private String subscriberid;

    public CustomerInfoVO() {
    }

    public CustomerInfoVO(
           String address,
           String buss_type,
           String cert_name,
           String cert_no,
           String company_name,
           String cust_name,
           String cust_no,
           String homephone,
           String mobile,
           String money,
           String password,
           String status,
           String stbcode,
           String subscriberid) {
           this.address = address;
           this.buss_type = buss_type;
           this.cert_name = cert_name;
           this.cert_no = cert_no;
           this.company_name = company_name;
           this.cust_name = cust_name;
           this.cust_no = cust_no;
           this.homephone = homephone;
           this.mobile = mobile;
           this.money = money;
           this.password = password;
           this.status = status;
           this.stbcode = stbcode;
           this.subscriberid = subscriberid;
    }


    /**
     * Gets the address value for this CustomerInfoVO.
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this CustomerInfoVO.
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Gets the buss_type value for this CustomerInfoVO.
     * 
     * @return buss_type
     */
    public String getBuss_type() {
        return buss_type;
    }


    /**
     * Sets the buss_type value for this CustomerInfoVO.
     * 
     * @param buss_type
     */
    public void setBuss_type(String buss_type) {
        this.buss_type = buss_type;
    }


    /**
     * Gets the cert_name value for this CustomerInfoVO.
     * 
     * @return cert_name
     */
    public String getCert_name() {
        return cert_name;
    }


    /**
     * Sets the cert_name value for this CustomerInfoVO.
     * 
     * @param cert_name
     */
    public void setCert_name(String cert_name) {
        this.cert_name = cert_name;
    }


    /**
     * Gets the cert_no value for this CustomerInfoVO.
     * 
     * @return cert_no
     */
    public String getCert_no() {
        return cert_no;
    }


    /**
     * Sets the cert_no value for this CustomerInfoVO.
     * 
     * @param cert_no
     */
    public void setCert_no(String cert_no) {
        this.cert_no = cert_no;
    }


    /**
     * Gets the companyName value for this CustomerInfoVO.
     * 
     * @return companyName
     */
    public String getCompany_name() {
        return company_name;
    }


    /**
     * Sets the companyName value for this CustomerInfoVO.
     * 
     * @param company_name
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }


    /**
     * Gets the cust_name value for this CustomerInfoVO.
     * 
     * @return cust_name
     */
    public String getCust_name() {
        return cust_name;
    }


    /**
     * Sets the cust_name value for this CustomerInfoVO.
     * 
     * @param cust_name
     */
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }


    /**
     * Gets the customerNo value for this CustomerInfoVO.
     * 
     * @return customerNo
     */
    public String getCust_no() {
        return cust_no;
    }


    /**
     * Sets the customerNo value for this CustomerInfoVO.
     * 
     * @param cust_no
     */
    public void setCust_no(String cust_no) {
        this.cust_no = cust_no;
    }


    /**
     * Gets the homephone value for this CustomerInfoVO.
     * 
     * @return homephone
     */
    public String getHomephone() {
        return homephone;
    }


    /**
     * Sets the homephone value for this CustomerInfoVO.
     * 
     * @param homephone
     */
    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }


    /**
     * Gets the mobile value for this CustomerInfoVO.
     * 
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this CustomerInfoVO.
     * 
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the money value for this CustomerInfoVO.
     * 
     * @return money
     */
    public String getMoney() {
        return money;
    }


    /**
     * Sets the money value for this CustomerInfoVO.
     * 
     * @param money
     */
    public void setMoney(String money) {
        this.money = money;
    }


    /**
     * Gets the password value for this CustomerInfoVO.
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this CustomerInfoVO.
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Gets the status value for this CustomerInfoVO.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CustomerInfoVO.
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Gets the stbCode value for this CustomerInfoVO.
     * 
     * @return stbCode
     */
    public String getStbcode() {
        return stbcode;
    }


    /**
     * Sets the stbCode value for this CustomerInfoVO.
     * 
     * @param stbcode
     */
    public void setStbcode(String stbcode) {
        this.stbcode = stbcode;
    }


    /**
     * Gets the subscriberId value for this CustomerInfoVO.
     * 
     * @return subscriberId
     */
    public String getSubscriberid() {
        return subscriberid;
    }


    /**
     * Sets the subscriberId value for this CustomerInfoVO.
     * 
     * @param subscriberid
     */
    public void setSubscriberid(String subscriberid) {
        this.subscriberid = subscriberid;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerInfoVO)) return false;
        CustomerInfoVO other = (CustomerInfoVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.buss_type==null && other.getBuss_type()==null) || 
             (this.buss_type!=null &&
              this.buss_type.equals(other.getBuss_type()))) &&
            ((this.cert_name==null && other.getCert_name()==null) || 
             (this.cert_name!=null &&
              this.cert_name.equals(other.getCert_name()))) &&
            ((this.cert_no==null && other.getCert_no()==null) || 
             (this.cert_no!=null &&
              this.cert_no.equals(other.getCert_no()))) &&
            ((this.company_name==null && other.getCompany_name()==null) || 
             (this.company_name!=null &&
              this.company_name.equals(other.getCompany_name()))) &&
            ((this.cust_name==null && other.getCust_name()==null) || 
             (this.cust_name!=null &&
              this.cust_name.equals(other.getCust_name()))) &&
            ((this.cust_no==null && other.getCust_no()==null) || 
             (this.cust_no!=null &&
              this.cust_no.equals(other.getCust_no()))) &&
            ((this.homephone==null && other.getHomephone()==null) || 
             (this.homephone!=null &&
              this.homephone.equals(other.getHomephone()))) &&
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.money==null && other.getMoney()==null) || 
             (this.money!=null &&
              this.money.equals(other.getMoney()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.stbcode==null && other.getStbcode()==null) || 
             (this.stbcode!=null &&
              this.stbcode.equals(other.getStbcode()))) &&
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getBuss_type() != null) {
            _hashCode += getBuss_type().hashCode();
        }
        if (getCert_name() != null) {
            _hashCode += getCert_name().hashCode();
        }
        if (getCert_no() != null) {
            _hashCode += getCert_no().hashCode();
        }
        if (getCompany_name() != null) {
            _hashCode += getCompany_name().hashCode();
        }
        if (getCust_name() != null) {
            _hashCode += getCust_name().hashCode();
        }
        if (getCust_no() != null) {
            _hashCode += getCust_no().hashCode();
        }
        if (getHomephone() != null) {
            _hashCode += getHomephone().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getMoney() != null) {
            _hashCode += getMoney().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStbcode() != null) {
            _hashCode += getStbcode().hashCode();
        }
        if (getSubscriberid() != null) {
            _hashCode += getSubscriberid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerInfoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "customerInfoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buss_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "buss_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cert_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cert_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cert_no");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cert_no"));
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
        elemField.setFieldName("cust_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cust_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "homephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobile"));
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
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
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
        elemField.setFieldName("stbCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stbCode"));
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
