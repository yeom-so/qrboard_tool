package kr.co.digigroove.qrboard_tool.entities.common;

import kr.co.digigroove.commons.utils.StringUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PageEntity extends PageNavigationEntity {

	private static final long serialVersionUID = 3286446354188420056L;

//	private static final String DEFAULT_LABEL_FIRST_PAGE = "<img src=\"/resources/img/icon-first.gif\"/>";
//	private static final String DEFAULT_LABEL_LAST_PAGE  = "<img src=\"/resources/img/icon-last.gif\"/>";
	private static final String DEFAULT_LABEL_GROUP_PREV = "<img src=\"/resources/img/icon-prev.gif\"/>";
	private static final String DEFAULT_LABEL_GROUP_NEXT = "<img src=\"/resources/img/icon-next.gif\"/>";

	private String searchKey;
	private String searchValue;
	private String startDate;
	private String endDate;

	public PageEntity(final long currentPageParam, final int pageGroupSizeParam, final int pageListSizeParam) {
    super( currentPageParam, pageGroupSizeParam, pageListSizeParam );

    setLabelsInit();
  }

  public PageEntity(final long currentPageParam) {
    super( currentPageParam );
    setLabelsInit();
  }

  private void setLabelsInit() {
    super.setLabelFirstPage(DEFAULT_LABEL_FIRST_PAGE);
    super.setLabelLastPage(DEFAULT_LABEL_LAST_PAGE);
    super.setLabelGroupPrevious(DEFAULT_LABEL_GROUP_PREV);
    super.setLabelGroupNext(DEFAULT_LABEL_GROUP_NEXT);
  }

	public void setPageParams() {
		Map<String, Object> paramsMap = new ConcurrentHashMap<String, Object>();
		if (!StringUtils.isEmpty(searchKey))   paramsMap.put("searchKey", searchKey);
		if (!StringUtils.isEmpty(this.getSearchValue())) paramsMap.put("searchValue", this.getSearchValue());
		if (!StringUtils.isEmpty(startDate))   paramsMap.put("startDate", startDate);
		if (!StringUtils.isEmpty(endDate))     paramsMap.put("endDate", endDate);
		super.setPageParams(paramsMap);
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
