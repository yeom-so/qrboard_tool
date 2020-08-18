package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
public class PublicAdvertEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int publicAdvertIdx;
  private int contentIdx;
  private int templateIdx;
  private String publicAdvertName;
  private int publicAdvertProfit;
  private Date publicAdvertSdate;
  private Date publicAdvertEdate;
  private Date regDate;

  private List<ContentTextEntity> contentTextEntityList;
  private List<ContentImageEntity> contentImageEntityList;
  private List<ContentBackgroundEntity> contentBackgroundEntityList;

}
