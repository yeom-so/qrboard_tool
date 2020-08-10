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
public class QrboardEntity extends PageEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  public QrboardEntity() {
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

  private int qrboardIdx;
  private int layoutIdx;
  private String layoutName;
  private int templateIdx;
  private int userIdx;
  private String userName;
  private String userTel;
  private String qrboardName;
  private String qrboardLocation;
  private String qrboardDetailLocation;
  private String qrboardAutoLocation;
  private String qrboardAuthNum;            // QR보드 인증번호
  private String qrboardPermitNum;          // QR보드 허가번호
  private String qrboardPrice;              // QR보드 광고단가
  private String qrboardPublicYn;           // QR보드 공용광고 게시 가능여부
  private String qrboardAuthYn;             // QR보드 인증여부
  private String qrboardApproveYn;          // QR보드 승인 필수여부 (Y: 승인시만 광고게시, N: 미승인시도 광고게시)
  private String qrboardApproveStime;       // QR보드 승인가능 시작시간 (HHMM)
  private String qrboardApproveEtime;       // QR보드 승인가능 종료시간 (HHMM)
  private String qrboardApproveOption;      // QR보드 승인 옵션 (1: 결제후 1시간이내 미승인시 자동게시, 2: 결제후 1시간이내 미승인시 자동취소)
  private Date regDate;
  private String useYn;

  // 인증결과
  private String result;
  private String subResult;

  // 광고여부
  private int qrboardAreaNum;     // 광고 영역 개수
  private int advertNum;          // 광고중 영역 개수

}
