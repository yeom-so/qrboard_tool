package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
public class ContentEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int contentIdx;
  private Date regDate;
  private List<ContentTextEntity> contentTextEntityList;
  private List<ContentImageEntity> cotentImageEntityList;
  private List<ContentBackgroundEntity> contentBackgroundEntityList;

}
