package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter @ToString
public class LayoutEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int layoutIdx;
  private String layoutName;
  private String layoutCode;
  private String layoutDirection;
  private String layoutX;
  private String layoutY;
  private String layoutImagePath;
  private String useYn;
  private Date regDate;

}
