package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
public class QrboardAreaEntity extends QrboardEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int qrboardAreaIdx;
  private int qrboardIdx;
  private int qrboardAreaSeq;
  private String qrboardAreaCodeImagePath;
  private Date lastAdvertSdate;             // 마지막 광고 시작일
  private Date lastAdvertEdate;             // 마지막 광고 종료일
  private AdvertEntity advertEntity;        // 현재 광고

  private int contentIdx;
  private List<ContentTextEntity> contentTextEntityList;
  private List<ContentImageEntity> contentImageEntityList;
  private List<ContentBackgroundEntity> contentBackgroundEntityList;

  private String layoutName;
  private String userEmail;
  private String userTel;
  private Date advertSdate;
  private Date advertEdate;

}
