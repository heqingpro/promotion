package com.xmbtn.boss.qfee.server;

public class IFeeQueryNewDAOProxy implements IFeeQueryNewDAO {
  private String _endpoint = null;
  private IFeeQueryNewDAO iFeeQueryNewDAO = null;
  
  public IFeeQueryNewDAOProxy() {
    _initIFeeQueryNewDAOProxy();
  }
  
  public IFeeQueryNewDAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initIFeeQueryNewDAOProxy();
  }
  
  private void _initIFeeQueryNewDAOProxy() {
    try {
      iFeeQueryNewDAO = (new com.xmbtn.boss.qfee.server.FeeQuerynewdaoLocator()).getFeeQueryNewDAOImplPort();
      if (iFeeQueryNewDAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iFeeQueryNewDAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iFeeQueryNewDAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iFeeQueryNewDAO != null)
      ((javax.xml.rpc.Stub)iFeeQueryNewDAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public IFeeQueryNewDAO getIFeeQueryNewDAO() {
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO;
  }
  
  public HsOfferVO checkHsOffer(String arg0, String arg1, String arg2, String arg3, String arg4) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkHsOffer(arg0, arg1, arg2, arg3, arg4);
  }
  
  public GridUserVO[] queryGridUserStat(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryGridUserStat(arg0);
  }
  
  public String queryStbType(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryStbType(arg0);
  }
  
  public String checkBill(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkBill(arg0);
  }
  
  public CustomerOfferinstVO[] queryOfferinstByUser(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryOfferinstByUser(arg0, arg1);
  }
  
  public HdEffectiveVO queryeffectiveOffer(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryeffectiveOffer(arg0);
  }
  
  public String cancelOfferByVo(OffercancalVo arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.cancelOfferByVo(arg0);
  }
  
  public String checkIsMidAutumnAc(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkIsMidAutumnAc(arg0);
  }
  
  public CustomerFeeDetailVO queryFeeDetail(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryFeeDetail(arg0, arg1);
  }
  
  public OnlineorderVO[] getOnlineorder(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.getOnlineorder(arg0, arg1);
  }
  
  public String queryPayOfferResult(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryPayOfferResult(arg0);
  }
  
  public CustomerInfoVO queryCustomerInfo(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryCustomerInfo(arg0);
  }
  
  public ResultCode openSubscriber(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.openSubscriber(arg0, arg1, arg2);
  }
  
  public HsOfferVO checkOrderProdToCust(String arg0, String arg1, String arg2, String arg3, String arg4) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkOrderProdToCust(arg0, arg1, arg2, arg3, arg4);
  }
  
  public String queryHdMidautumnAcResult(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryHdMidautumnAcResult(arg0);
  }
  
  public AccountVO[] queryAccount(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryAccount(arg0);
  }
  
  public CustomerBillVO[] queryFee(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryFee(arg0, arg1, arg2);
  }
  
  public HsCheckCancelVO hscheckCancel(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.hscheckCancel(arg0, arg1);
  }
  
  public String purchaseOfferlog(PurchaseLogVO arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.purchaseOfferlog(arg0);
  }
  
  public HsOfferVO checkHsOfferToCust(String arg0, String arg1, String arg2, String arg3) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkHsOfferToCust(arg0, arg1, arg2, arg3);
  }
  
  public HdEffectiveVO[] checkIsBuylw(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkIsBuylw(arg0, arg1);
  }
  
  public CustomerCardVO[] queryCustomerCard(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryCustomerCard(arg0);
  }
  
  public LatestVO[] queryLatestOffer() throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryLatestOffer();
  }
  
  public String checkIsOpen(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkIsOpen(arg0);
  }
  
  public String modifyCustomerPwd(com.dvte.boss.ws.callcenter.ModifyCustomerPasswordModel arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.modifyCustomerPwd(arg0);
  }
  
  public CustomerFfpdDetailVO[] queryFfpdDetail(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryFfpdDetail(arg0, arg1);
  }
  
  public UsertypeVO queryUsertype(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryUsertype(arg0);
  }
  
  public HdEffectiveVO[] checkIsBuyhs(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkIsBuyhs(arg0, arg1);
  }
  
  public String queryHDProdClass(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryHDProdClass(arg0);
  }
  
  public HdEffectiveVO[] queryHDEffectives(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryHDEffectives(arg0);
  }
  
  public String addHdMidautumnAclist(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.addHdMidautumnAclist(arg0, arg1, arg2);
  }
  
  public CustomerTransVO[] queryCustomerTransByUser(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryCustomerTransByUser(arg0, arg1, arg2);
  }
  
  public String checkIsMarketing(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkIsMarketing(arg0, arg1, arg2);
  }
  
  public String queryPayResult(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryPayResult(arg0);
  }
  
  public String getEnddateByProdid(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.getEnddateByProdid(arg0, arg1);
  }
  
  public com.dvte.boss.ws.callcenter.PurchaseReturn buyOffer(com.dvte.boss.ws.callcenter.OfferOrderModel[] arg0, String[] arg1, String arg2, String arg3, String arg4, String arg5) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.buyOffer(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public com.dvte.boss.ws.callcenter.FillCardResult rechargFillCard(com.dvte.boss.ws.callcenter.ChargeCardModel arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.rechargFillCard(arg0);
  }
  
  public CustomerInfoVO queryCustomerInfoByStbid(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.queryCustomerInfoByStbid(arg0);
  }
  
  public CustomerInfoVO checkAccount(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkAccount(arg0, arg1);
  }
  
  public HsOfferVO checkOrderProd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkOrderProd(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public ResourcesinfoVO[] getResourcesinfoVO(String arg0) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.getResourcesinfoVO(arg0);
  }
  
  public String checkOperator(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iFeeQueryNewDAO == null)
      _initIFeeQueryNewDAOProxy();
    return iFeeQueryNewDAO.checkOperator(arg0, arg1);
  }
  
  
}