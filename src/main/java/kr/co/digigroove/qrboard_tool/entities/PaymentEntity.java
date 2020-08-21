package kr.co.digigroove.qrboard_tool.entities;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.common.PageEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter @Setter @ToString
public class PaymentEntity extends PageEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  public PaymentEntity() {
    super(1L, Default.Page.UNIT, Default.Page.SIZE);
  }

  public void setPageParams() {
    Map paramsMap = new ConcurrentHashMap<String, Object>();
    if (StringUtils.isNotEmpty(getStartDate())) 	paramsMap.put("startDate", getStartDate());
    if (StringUtils.isNotEmpty(getEndDate()))   	paramsMap.put("endDate", getEndDate());
    if (StringUtils.isNotEmpty(getSearchKey()))   paramsMap.put("searchKey", getSearchKey());
    if (StringUtils.isNotEmpty(getSearchValue())) paramsMap.put("searchValue", getSearchValue());
    super.setPageParams(paramsMap);
  }

  // 검색조건
  private int searchAdvertState = -1;  // 광고상태 검색

  private List<PaymentEntity> paymentPageEntityList;
  private int paymentIdx;
  private int advertIdx;
  private int userIdx;
  private String impUid;
  private String merchantUid;
  private int paymentPrice;
  private String paymentTid;
  private String paymentMethod;
  private String paymentApplNum;
  private String paymentCardNum;
  private String paymentCardName;
  private String paymentResultCode;
  private String paymentResultMsg;
  private String paymentOs;
  private String paymentStatus;
  private Date cancelDate;
  private Date regDate;

  private String advertName;
  private String qrboardName;
  private int qrboardAreaSeq;
  private String userEmail;
  private String userTel;
  private String layoutName;
  private String templateName;
  private String templateShopName;
  private int advertState;
  private Date advertSdate;
  private Date advertEdate;

}
