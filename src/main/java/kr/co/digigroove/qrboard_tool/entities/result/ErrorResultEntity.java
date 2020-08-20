package kr.co.digigroove.qrboard_tool.entities.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ErrorResultEntity extends ResultEntity {
	private static final long serialVersionUID = 5467847837982225023L;

	private String redirect;
	private int isAdmin;
}
