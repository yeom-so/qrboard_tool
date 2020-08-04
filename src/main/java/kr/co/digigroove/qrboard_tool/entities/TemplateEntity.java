package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter @ToString
public class TemplateEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int templateIdx;
  private int layoutIdx;
  private String templateName;
  private String templateCode;
  private String templateDirection;
  private int templateText;
  private int templateImage;
  private int templateBackground;
  private String templateImagePath;
  private String useYn;
  private Date regDate;

}
