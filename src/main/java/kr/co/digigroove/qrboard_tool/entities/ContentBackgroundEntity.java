package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
public class ContentBackgroundEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int contentIdx;
  private int contentBackgroundIdx;
  private String contentBackgroundColor;

}
