/**
 * ModifyCustomerPasswordModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dvte.boss.ws.callcenter;

public class ModifyCustomerPasswordModel  implements java.io.Serializable {
    private String channel;

    private String cust_no;

    private String operatorCode;

    private String password;

    private String remark;

    public ModifyCustomerPasswordModel() {
    }

    public ModifyCustomerPasswordModel(
           String channel,
           String cust_no,
           String operatorCode,
           String password,
           String remark) {
           this.channel = channel;
           this.cust_no = cust_no;
           this.operatorCode = operatorCode;
           this.password = password;
           this.remark = remark;
    }


    /**
     * Gets the channel value for this ModifyCustomerPasswordModel.
     * 
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this ModifyCustomerPasswordModel.
     * 
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }


    /**
     * Gets the customerNo value for this ModifyCustomerPasswordModel.
     * 
     * @return customerNo
     */
    public String getCust_no() {
        return cust_no;
    }


    /**
     * Sets the customerNo value for this ModifyCustomerPasswordModel.
     * 
     * @param cust_no
     */
    public void setCust_no(String cust_no) {
        this.cust_no = cust_no;
    }


    /**
     * Gets the operatorCode value for this ModifyCustomerPasswordModel.
     * 
     * @return operatorCode
     */
    public String getOperatorCode() {
        return operatorCode;
    }


    /**
     * Sets the operatorCode value for this ModifyCustomerPasswordModel.
     * 
     * @param operatorCode
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }


    /**
     * Gets the password value for this ModifyCustomerPasswordModel.
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ModifyCustomerPasswordModel.
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Gets the remark value for this ModifyCustomerPasswordModel.
     * 
     * @return remark
     */
    public String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this ModifyCustomerPasswordModel.
     * 
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ModifyCustomerPasswordModel)) return false;
        ModifyCustomerPasswordModel other = (ModifyCustomerPasswordModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.channel==null && other.getChannel()==null) || 
             (this.channel!=null &&
              this.channel.equals(other.getChannel()))) &&
            ((this.cust_no==null && other.getCust_no()==null) || 
             (this.cust_no!=null &&
              this.cust_no.equals(other.getCust_no()))) &&
            ((this.operatorCode==null && other.getOperatorCode()==null) || 
             (this.operatorCode!=null &&
              this.operatorCode.equals(other.getOperatorCode()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark())));
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
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        if (getCust_no() != null) {
            _hashCode += getCust_no().hashCode();
        }
        if (getOperatorCode() != null) {
            _hashCode += getOperatorCode().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModifyCustomerPasswordModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://callcenter.ws.boss.dvte.com/", "modifyCustomerPasswordModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
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
        elemField.setFieldName("operatorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operatorCode"));
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
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark"));
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
