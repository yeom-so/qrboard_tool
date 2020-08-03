package kr.co.digigroove.qrboard_tool.entities.result;

import kr.co.digigroove.qrboard_tool.constant.Default;

import java.io.Serializable;

public class ResultEntity implements Serializable {

	private static final long serialVersionUID = -7085419614315973729L;

	private String message;
	private String url;
	private String code = Default.Result.FAIL;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
