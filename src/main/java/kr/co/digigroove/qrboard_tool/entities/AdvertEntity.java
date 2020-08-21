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
public class AdvertEntity extends PageEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  public AdvertEntity() {
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
  private int searchAdvertType = -1;

  private List<AdvertEntity> advertPageEntityList;
  private int advertIdx;
  private int qrboardIdx;
  private String qrboardName;
  private int qrboardAreaIdx;
  private int qrboardAreaSeq;
  private String qrboardApproveStime;
  private String qrboardApproveEtime;
  private String layoutName;
  private int contentIdx;
  private int templateIdx;
  private String templateName;
  private int templateShopIdx;
  private String templateShopName;
  private int publicAdvertIdx;
  private int userIdx;
  private String userEmail;
  private String userTel;
  private String advertType;
  private String advertName;
  private String advertUserName;
  private String advertUserCi;
  private String advertUserTel;
  private Date advertSdate;
  private Date advertEdate;
  private int advertPrice;
  private int advertProfit;
  private String advertPayYn;
  private int advertState;
  private String advertStateBigo;
  private Date regDate;
  private String useYn;
  private int paymentPrice;
  private String paymentStatus;
  private Date paymentRegDate;
  private Date paymentCancelDate;
  private PaymentEntity paymentEntity;

  private List<ContentTextEntity> contentTextEntityList;
  private List<ContentImageEntity> contentImageEntityList;
  private List<ContentBackgroundEntity> contentBackgroundEntityList;

}
