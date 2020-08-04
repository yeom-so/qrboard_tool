package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter @ToString
public class PermitNumEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int permitNumIdx;
  private int userIdx;
  private int qrboardIdx;
  private String permitNum;
  private Date regDate;
  private Date authDate;
  private Date unauthDate;
  private String useYn;

}
