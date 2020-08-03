package kr.co.digigroove.qrboard_tool.entities.result;

import kr.co.digigroove.qrboard_tool.entities.UserEntity;

public class UserResultEntity extends ResultEntity {
	private static final long serialVersionUID = 7074105257721990083L;
	private String name;
	private String id;
	private UserEntity loginInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserEntity getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(UserEntity loginInfo) {
		this.loginInfo = loginInfo;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
