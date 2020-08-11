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

  private int advertIdx;
  private int qrboardIdx;
  private int qrboardAreaIdx;
  private int contentIdx;
  private int templateShopIdx;
  private int userIdx;
  private String advertType;
  private String advertName;
  private String advertUserCi;
  private String advertUserTel;
  private Date advertSdate;
  private Date advertEdate;
  private int advertPrice;
  private int advertProfit;
  private String advertPayYn;
  private int advertState;
  private Date regDate;
  private String useYn;

  private List<ContentTextEntity> contentTextEntityList;
  private List<ContentImageEntity> contentImageEntityList;
  private List<ContentBackgroundEntity> contentBackgroundEntityList;

}
