package kr.co.digigroove.qrboard_tool.entities.result;

import java.io.Serializable;
import java.util.List;

public class AngularResultEntity<T> implements Serializable{

	private String result;      //로직 수행 결과
	private String message;     //전송 메세지
	private T entity;           //리턴 데이터
	private String url;         //리턴 도메인

	//variable easel instance
	private List<T> entityList; //리턴 데이터(리스트)

	public AngularResultEntity(){
		this.entity = null;
	}

	public AngularResultEntity(T entity){
		this.entity = entity;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}

}
