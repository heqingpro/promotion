/**
 * IFeeQueryNewDAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public interface IFeeQueryNewDAO extends java.rmi.Remote {
    public HsOfferVO checkHsOffer(String arg0, String arg1, String arg2, String arg3, String arg4) throws java.rmi.RemoteException;
    public GridUserVO[] queryGridUserStat(String arg0) throws java.rmi.RemoteException;
    public String queryStbType(String arg0) throws java.rmi.RemoteException;
    public String checkBill(String arg0) throws java.rmi.RemoteException;
    public com.xmbtn.boss.qfee.server.CustomerOfferinstVO[] queryOfferinstByUser(String arg0, String arg1) throws java.rmi.RemoteException;
    public HdEffectiveVO queryeffectiveOffer(String arg0) throws java.rmi.RemoteException;
    public String cancelOfferByVo(OffercancalVo arg0) throws java.rmi.RemoteException;
    public String checkIsMidAutumnAc(String arg0) throws java.rmi.RemoteException;
    public com.xmbtn.boss.qfee.server.CustomerFeeDetailVO queryFeeDetail(String arg0, String arg1) throws java.rmi.RemoteException;
    public OnlineorderVO[] getOnlineorder(String arg0, String arg1) throws java.rmi.RemoteException;
    public String queryPayOfferResult(String arg0) throws java.rmi.RemoteException;
    public CustomerInfoVO queryCustomerInfo(String arg0) throws java.rmi.RemoteException;
    public ResultCode openSubscriber(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public HsOfferVO checkOrderProdToCust(String arg0, String arg1, String arg2, String arg3, String arg4) throws java.rmi.RemoteException;
    public String queryHdMidautumnAcResult(String arg0) throws java.rmi.RemoteException;
    public AccountVO[] queryAccount(String arg0) throws java.rmi.RemoteException;
    public CustomerBillVO[] queryFee(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public HsCheckCancelVO hscheckCancel(String arg0, String arg1) throws java.rmi.RemoteException;
    public String purchaseOfferlog(PurchaseLogVO arg0) throws java.rmi.RemoteException;
    public HsOfferVO checkHsOfferToCust(String arg0, String arg1, String arg2, String arg3) throws java.rmi.RemoteException;
    public HdEffectiveVO[] checkIsBuylw(String arg0, String arg1) throws java.rmi.RemoteException;
    public CustomerCardVO[] queryCustomerCard(String arg0) throws java.rmi.RemoteException;
    public LatestVO[] queryLatestOffer() throws java.rmi.RemoteException;
    public String checkIsOpen(String arg0) throws java.rmi.RemoteException;
    public String modifyCustomerPwd(com.dvte.boss.ws.callcenter.ModifyCustomerPasswordModel arg0) throws java.rmi.RemoteException;
    public com.xmbtn.boss.qfee.server.CustomerFfpdDetailVO[] queryFfpdDetail(String arg0, String arg1) throws java.rmi.RemoteException;
    public UsertypeVO queryUsertype(String arg0) throws java.rmi.RemoteException;
    public HdEffectiveVO[] checkIsBuyhs(String arg0, String arg1) throws java.rmi.RemoteException;
    public String queryHDProdClass(String arg0) throws java.rmi.RemoteException;
    public HdEffectiveVO[] queryHDEffectives(String arg0) throws java.rmi.RemoteException;
    public String addHdMidautumnAclist(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public CustomerTransVO[] queryCustomerTransByUser(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String checkIsMarketing(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String queryPayResult(String arg0) throws java.rmi.RemoteException;
    public String getEnddateByProdid(String arg0, String arg1) throws java.rmi.RemoteException;
    public com.dvte.boss.ws.callcenter.PurchaseReturn buyOffer(com.dvte.boss.ws.callcenter.OfferOrderModel[] arg0, String[] arg1, String arg2, String arg3, String arg4, String arg5) throws java.rmi.RemoteException;
    public com.dvte.boss.ws.callcenter.FillCardResult rechargFillCard(com.dvte.boss.ws.callcenter.ChargeCardModel arg0) throws java.rmi.RemoteException;
    public CustomerInfoVO queryCustomerInfoByStbid(String arg0) throws java.rmi.RemoteException;
    public CustomerInfoVO checkAccount(String arg0, String arg1) throws java.rmi.RemoteException;
    public HsOfferVO checkOrderProd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws java.rmi.RemoteException;
    public com.xmbtn.boss.qfee.server.ResourcesinfoVO[] getResourcesinfoVO(String arg0) throws java.rmi.RemoteException;
    public String checkOperator(String arg0, String arg1) throws java.rmi.RemoteException;
}
