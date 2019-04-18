/**
 * OnlineorderVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class OnlineorderVO  implements java.io.Serializable {
    private String begintime;

    private String code;

    private String endtime;

    private String flag;

    private String path;

    private String pname;

    private String prod_code;

    private String prod_id;

    private String prod_price;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    public OnlineorderVO() {
    }

    public OnlineorderVO(
           String begintime,
           String code,
           String endtime,
           String flag,
           String path,
           String pname,
           String prod_code,
           String prod_id,
           String prod_price,
           String remark1,
           String remark2,
           String remark3,
           String remark4) {
           this.begintime = begintime;
           this.code = code;
           this.endtime = endtime;
           this.flag = flag;
           this.path = path;
           this.pname = pname;
           this.prod_code = prod_code;
           this.prod_id = prod_id;
           this.prod_price = prod_price;
           this.remark1 = remark1;
           this.remark2 = remark2;
           this.remark3 = remark3;
           this.remark4 = remark4;
    }


    /**
     * Gets the begintime value for this OnlineorderVO.
     * 
     * @return begintime
     */
    public String getBegintime() {
        return begintime;
    }


    /**
     * Sets the begintime value for this OnlineorderVO.
     * 
     * @param begintime
     */
    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }


    /**
     * Gets the code value for this OnlineorderVO.
     * 
     * @return code
     */
    public String getCode() {
        return code;
    }


    /**
     * Sets the code value for this OnlineorderVO.
     * 
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }


    /**
     * Gets the endtime value for this OnlineorderVO.
     * 
     * @return endtime
     */
    public String getEndtime() {
        return endtime;
    }


    /**
     * Sets the endtime value for this OnlineorderVO.
     * 
     * @param endtime
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }


    /**
     * Gets the flag value for this OnlineorderVO.
     * 
     * @return flag
     */
    public String getFlag() {
        return flag;
    }


    /**
     * Sets the flag value for this OnlineorderVO.
     * 
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }


    /**
     * Gets the path value for this OnlineorderVO.
     * 
     * @return path
     */
    public String getPath() {
        return path;
    }


    /**
     * Sets the path value for this OnlineorderVO.
     * 
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }


    /**
     * Gets the pname value for this OnlineorderVO.
     * 
     * @return pname
     */
    public String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this OnlineorderVO.
     * 
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }


    /**
     * Gets the prod_code value for this OnlineorderVO.
     * 
     * @return prod_code
     */
    public String getProd_code() {
        return prod_code;
    }


    /**
     * Sets the prod_code value for this OnlineorderVO.
     * 
     * @param prod_code
     */
    public void setProd_code(String prod_code) {
        this.prod_code = prod_code;
    }


    /**
     * Gets the prod_id value for this OnlineorderVO.
     * 
     * @return prod_id
     */
    public String getProd_id() {
        return prod_id;
    }


    /**
     * Sets the prod_id value for this OnlineorderVO.
     * 
     * @param prod_id
     */
    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }


    /**
     * Gets the prod_price value for this OnlineorderVO.
     * 
     * @return prod_price
     */
    public String getProd_price() {
        return prod_price;
    }


    /**
     * Sets the prod_price value for this OnlineorderVO.
     * 
     * @param prod_price
     */
    public void setProd_price(String prod_price) {
        this.prod_price = prod_price;
    }


    /**
     * Gets the remark1 value for this OnlineorderVO.
     * 
     * @return remark1
     */
    public String getRemark1() {
        return remark1;
    }


    /**
     * Sets the remark1 value for this OnlineorderVO.
     * 
     * @param remark1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }


    /**
     * Gets the remark2 value for this OnlineorderVO.
     * 
     * @return remark2
     */
    public String getRemark2() {
        return remark2;
    }


    /**
     * Sets the remark2 value for this OnlineorderVO.
     * 
     * @param remark2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }


    /**
     * Gets the remark3 value for this OnlineorderVO.
     * 
     * @return remark3
     */
    public String getRemark3() {
        return remark3;
    }


    /**
     * Sets the remark3 value for this OnlineorderVO.
     * 
     * @param remark3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }


    /**
     * Gets the remark4 value for this OnlineorderVO.
     * 
     * @return remark4
     */
    public String getRemark4() {
        return remark4;
    }


    /**
     * Sets the remark4 value for this OnlineorderVO.
     * 
     * @param remark4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof OnlineorderVO)) return false;
        OnlineorderVO other = (OnlineorderVO) obj;
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
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.endtime==null && other.getEndtime()==null) || 
             (this.endtime!=null &&
              this.endtime.equals(other.getEndtime()))) &&
            ((this.flag==null && other.getFlag()==null) || 
             (this.flag!=null &&
              this.flag.equals(other.getFlag()))) &&
            ((this.path==null && other.getPath()==null) || 
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            ((this.pname==null && other.getPname()==null) || 
             (this.pname!=null &&
              this.pname.equals(other.getPname()))) &&
            ((this.prod_code==null && other.getProd_code()==null) || 
             (this.prod_code!=null &&
              this.prod_code.equals(other.getProd_code()))) &&
            ((this.prod_id==null && other.getProd_id()==null) || 
             (this.prod_id!=null &&
              this.prod_id.equals(other.getProd_id()))) &&
            ((this.prod_price==null && other.getProd_price()==null) || 
             (this.prod_price!=null &&
              this.prod_price.equals(other.getProd_price()))) &&
            ((this.remark1==null && other.getRemark1()==null) || 
             (this.remark1!=null &&
              this.remark1.equals(other.getRemark1()))) &&
            ((this.remark2==null && other.getRemark2()==null) || 
             (this.remark2!=null &&
              this.remark2.equals(other.getRemark2()))) &&
            ((this.remark3==null && other.getRemark3()==null) || 
             (this.remark3!=null &&
              this.remark3.equals(other.getRemark3()))) &&
            ((this.remark4==null && other.getRemark4()==null) || 
             (this.remark4!=null &&
              this.remark4.equals(other.getRemark4())));
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
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getEndtime() != null) {
            _hashCode += getEndtime().hashCode();
        }
        if (getFlag() != null) {
            _hashCode += getFlag().hashCode();
        }
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        if (getPname() != null) {
            _hashCode += getPname().hashCode();
        }
        if (getProd_code() != null) {
            _hashCode += getProd_code().hashCode();
        }
        if (getProd_id() != null) {
            _hashCode += getProd_id().hashCode();
        }
        if (getProd_price() != null) {
            _hashCode += getProd_price().hashCode();
        }
        if (getRemark1() != null) {
            _hashCode += getRemark1().hashCode();
        }
        if (getRemark2() != null) {
            _hashCode += getRemark2().hashCode();
        }
        if (getRemark3() != null) {
            _hashCode += getRemark3().hashCode();
        }
        if (getRemark4() != null) {
            _hashCode += getRemark4().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OnlineorderVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "onlineorderVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("begintime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "begintime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
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
        elemField.setFieldName("flag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("", "path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prod_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prod_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prod_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prod_id"));
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
        elemField.setFieldName("remark1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark4"));
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
