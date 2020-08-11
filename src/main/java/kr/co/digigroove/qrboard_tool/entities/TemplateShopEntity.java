package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
public class TemplateShopEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int templateShopIdx;
  private int templateIdx;
  private int businessIdx;
  private int contentIdx;
  private String templateShopName;
  private Date regDate;

  private List<ContentTextEntity> contentTextEntityList;
  private List<ContentImageEntity> contentImageEntityList;
  private List<ContentBackgroundEntity> contentBackgroundEntityList;

}
