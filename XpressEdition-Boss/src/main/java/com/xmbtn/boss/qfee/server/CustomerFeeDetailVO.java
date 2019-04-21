/**
 * CustomerFeeDetailVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class CustomerFeeDetailVO  implements java.io.Serializable {
    private String begindate;

    private String enddate;

    private String ffpdFee;

    private String hdFee;

    private String kdFee;

    private String mainCount;

    private String mainFee;

    private String sswhFee;

    private String stbFee;

    private String unmainCount;

    private String unmainFee;

    private String wyFee;

    public CustomerFeeDetailVO() {
    }

    public CustomerFeeDetailVO(
           String begindate,
           String enddate,
           String ffpdFee,
           String hdFee,
           String kdFee,
           String mainCount,
           String mainFee,
           String sswhFee,
           String stbFee,
           String unmainCount,
           String unmainFee,
           String wyFee) {
           this.begindate = begindate;
           this.enddate = enddate;
           this.ffpdFee = ffpdFee;
           this.hdFee = hdFee;
           this.kdFee = kdFee;
           this.mainCount = mainCount;
           this.mainFee = mainFee;
           this.sswhFee = sswhFee;
           this.stbFee = stbFee;
           this.unmainCount = unmainCount;
           this.unmainFee = unmainFee;
           this.wyFee = wyFee;
    }


    /**
     * Gets the begindate value for this CustomerFeeDetailVO.
     * 
     * @return begindate
     */
    public String getBegindate() {
        return begindate;
    }


    /**
     * Sets the begindate value for this CustomerFeeDetailVO.
     * 
     * @param begindate
     */
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }


    /**
     * Gets the enddate value for this CustomerFeeDetailVO.
     * 
     * @return enddate
     */
    public String getEnddate() {
        return enddate;
    }


    /**
     * Sets the enddate value for this CustomerFeeDetailVO.
     * 
     * @param enddate
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }


    /**
     * Gets the ffpdFee value for this CustomerFeeDetailVO.
     * 
     * @return ffpdFee
     */
    public String getFfpdFee() {
        return ffpdFee;
    }


    /**
     * Sets the ffpdFee value for this CustomerFeeDetailVO.
     * 
     * @param ffpdFee
     */
    public void setFfpdFee(String ffpdFee) {
        this.ffpdFee = ffpdFee;
    }


    /**
     * Gets the hdFee value for this CustomerFeeDetailVO.
     * 
     * @return hdFee
     */
    public String getHdFee() {
        return hdFee;
    }


    /**
     * Sets the hdFee value for this CustomerFeeDetailVO.
     * 
     * @param hdFee
     */
    public void setHdFee(String hdFee) {
        this.hdFee = hdFee;
    }


    /**
     * Gets the kdFee value for this CustomerFeeDetailVO.
     * 
     * @return kdFee
     */
    public String getKdFee() {
        return kdFee;
    }


    /**
     * Sets the kdFee value for this CustomerFeeDetailVO.
     * 
     * @param kdFee
     */
    public void setKdFee(String kdFee) {
        this.kdFee = kdFee;
    }


    /**
     * Gets the mainCount value for this CustomerFeeDetailVO.
     * 
     * @return mainCount
     */
    public String getMainCount() {
        return mainCount;
    }


    /**
     * Sets the mainCount value for this CustomerFeeDetailVO.
     * 
     * @param mainCount
     */
    public void setMainCount(String mainCount) {
        this.mainCount = mainCount;
    }


    /**
     * Gets the mainFee value for this CustomerFeeDetailVO.
     * 
     * @return mainFee
     */
    public String getMainFee() {
        return mainFee;
    }


    /**
     * Sets the mainFee value for this CustomerFeeDetailVO.
     * 
     * @param mainFee
     */
    public void setMainFee(String mainFee) {
        this.mainFee = mainFee;
    }


    /**
     * Gets the sswhFee value for this CustomerFeeDetailVO.
     * 
     * @return sswhFee
     */
    public String getSswhFee() {
        return sswhFee;
    }


    /**
     * Sets the sswhFee value for this CustomerFeeDetailVO.
     * 
     * @param sswhFee
     */
    public void setSswhFee(String sswhFee) {
        this.sswhFee = sswhFee;
    }


    /**
     * Gets the stbFee value for this CustomerFeeDetailVO.
     * 
     * @return stbFee
     */
    public String getStbFee() {
        return stbFee;
    }


    /**
     * Sets the stbFee value for this CustomerFeeDetailVO.
     * 
     * @param stbFee
     */
    public void setStbFee(String stbFee) {
        this.stbFee = stbFee;
    }


    /**
     * Gets the unmainCount value for this CustomerFeeDetailVO.
     * 
     * @return unmainCount
     */
    public String getUnmainCount() {
        return unmainCount;
    }


    /**
     * Sets the unmainCount value for this CustomerFeeDetailVO.
     * 
     * @param unmainCount
     */
    public void setUnmainCount(String unmainCount) {
        this.unmainCount = unmainCount;
    }


    /**
     * Gets the unmainFee value for this CustomerFeeDetailVO.
     * 
     * @return unmainFee
     */
    public String getUnmainFee() {
        return unmainFee;
    }


    /**
     * Sets the unmainFee value for this CustomerFeeDetailVO.
     * 
     * @param unmainFee
     */
    public void setUnmainFee(String unmainFee) {
        this.unmainFee = unmainFee;
    }


    /**
     * Gets the wyFee value for this CustomerFeeDetailVO.
     * 
     * @return wyFee
     */
    public String getWyFee() {
        return wyFee;
    }


    /**
     * Sets the wyFee value for this CustomerFeeDetailVO.
     * 
     * @param wyFee
     */
    public void setWyFee(String wyFee) {
        this.wyFee = wyFee;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerFeeDetailVO)) return false;
        CustomerFeeDetailVO other = (CustomerFeeDetailVO) obj;
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
            ((this.ffpdFee==null && other.getFfpdFee()==null) || 
             (this.ffpdFee!=null &&
              this.ffpdFee.equals(other.getFfpdFee()))) &&
            ((this.hdFee==null && other.getHdFee()==null) || 
             (this.hdFee!=null &&
              this.hdFee.equals(other.getHdFee()))) &&
            ((this.kdFee==null && other.getKdFee()==null) || 
             (this.kdFee!=null &&
              this.kdFee.equals(other.getKdFee()))) &&
            ((this.mainCount==null && other.getMainCount()==null) || 
             (this.mainCount!=null &&
              this.mainCount.equals(other.getMainCount()))) &&
            ((this.mainFee==null && other.getMainFee()==null) || 
             (this.mainFee!=null &&
              this.mainFee.equals(other.getMainFee()))) &&
            ((this.sswhFee==null && other.getSswhFee()==null) || 
             (this.sswhFee!=null &&
              this.sswhFee.equals(other.getSswhFee()))) &&
            ((this.stbFee==null && other.getStbFee()==null) || 
             (this.stbFee!=null &&
              this.stbFee.equals(other.getStbFee()))) &&
            ((this.unmainCount==null && other.getUnmainCount()==null) || 
             (this.unmainCount!=null &&
              this.unmainCount.equals(other.getUnmainCount()))) &&
            ((this.unmainFee==null && other.getUnmainFee()==null) || 
             (this.unmainFee!=null &&
              this.unmainFee.equals(other.getUnmainFee()))) &&
            ((this.wyFee==null && other.getWyFee()==null) || 
             (this.wyFee!=null &&
              this.wyFee.equals(other.getWyFee())));
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
        if (getFfpdFee() != null) {
            _hashCode += getFfpdFee().hashCode();
        }
        if (getHdFee() != null) {
            _hashCode += getHdFee().hashCode();
        }
        if (getKdFee() != null) {
            _hashCode += getKdFee().hashCode();
        }
        if (getMainCount() != null) {
            _hashCode += getMainCount().hashCode();
        }
        if (getMainFee() != null) {
            _hashCode += getMainFee().hashCode();
        }
        if (getSswhFee() != null) {
            _hashCode += getSswhFee().hashCode();
        }
        if (getStbFee() != null) {
            _hashCode += getStbFee().hashCode();
        }
        if (getUnmainCount() != null) {
            _hashCode += getUnmainCount().hashCode();
        }
        if (getUnmainFee() != null) {
            _hashCode += getUnmainFee().hashCode();
        }
        if (getWyFee() != null) {
            _hashCode += getWyFee().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerFeeDetailVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "customerFeeDetailVO"));
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
        elemField.setFieldName("ffpdFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ffpdFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hdFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hdFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kdFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "kdFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mainCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mainFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sswhFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sswhFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stbFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stbFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unmainCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unmainCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unmainFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unmainFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wyFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wyFee"));
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
