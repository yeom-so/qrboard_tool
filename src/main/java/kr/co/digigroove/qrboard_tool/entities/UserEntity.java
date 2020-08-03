package kr.co.digigroove.qrboard_tool.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter @ToString
public class UserEntity implements Serializable {

  private static final long serialVersionUID = -6375567936022237503L;

  private int userIdx;
  private int userGrade;      // 사용자 등급 (1: 통합관리자, 2: 광고사업주, 3: 광고주)
  private int userType;       // 사용자 구분 (0: 무료회원, 1:유료회원)
  private int userState;      // 사용자 상태 (0: 대기, 1: 승인, 2: 탈퇴)
  private String userName;
  private String userTel;
  private String userEmail;
  private String userPw;
  private String userBigo;
  private Date regDate;

}
