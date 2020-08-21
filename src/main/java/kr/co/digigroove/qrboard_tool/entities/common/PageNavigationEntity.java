package kr.co.digigroove.qrboard_tool.entities.common;

import kr.co.digigroove.commons.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PageNavigationEntity implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger( kr.co.digigroove.commons.entities.PageNavigationEntity.class );

	private static final long serialVersionUID = 1619208828421144385L;

	private static final int  DEFAULT_PAGE_LIST_SIZE       = 10;
	private static final int  DEFAULT_PAGE_GROUP_LIST_SIZE = 10;
	private static final long DEFAULT_CURRENT_PAGE         = 1;

	protected static final String DEFAULT_LABEL_FIRST_PAGE = "[First]";
	protected static final String DEFAULT_LABEL_LAST_PAGE  = "[Last]";
	protected static final String DEFAULT_LABEL_GROUP_PREV = "<";
	protected static final String DEFAULT_LABEL_GROUP_NEXT = ">";

	protected static final String DEFAULT_CLASS_CURRENT_PAGE = "on";
	protected static final String DEFAULT_CLASS_FIRST_PAGE   = "paging-first";
	protected static final String DEFAULT_CLASS_LAST_PAGE    = "paging-last";
	protected static final String DEFAULT_CLASS_GROUP_PREV   = "prev";
	protected static final String DEFAULT_CLASS_GROUP_NEXT   = "next";

	private String labelFirstPage;
	private String labelLastPage;
	private String labelGroupPrevious;
	private String labelGroupNext;

	private String classCurrentPage;
	private String classFirstPage;
	private String classLastPage;
	private String classGroupPrevious;
	private String classGroupNext;

	private long currentPage = DEFAULT_CURRENT_PAGE;
	private long pageTotalCount;
	private long dataSize;
	private long pageGroupStartPage;
	private long pageGroupEndPage;
	private int pageGroupSize = DEFAULT_PAGE_GROUP_LIST_SIZE;
	private int pageListSize  = DEFAULT_PAGE_LIST_SIZE;

	private long rowStartNumber;
	private long rowEndNumber;

	private Map< String, Object > pageParams;

	public PageNavigationEntity () {
		initDefaultLabels();
		initDefaultClasses();
	}

	public PageNavigationEntity ( final long currentPageParam, final int pageGroupSizeParam,
								  final int pageListSizeParam ) {
		this.dataSize = 0L;
		this.currentPage = currentPageParam < 1L ? 1 : currentPageParam;

		this.setPageSize( pageListSizeParam, pageGroupSizeParam );

		initDefaultLabels();
		initDefaultClasses();
	}

	public PageNavigationEntity ( final long currentPageParam ) {
		this.dataSize = 0L;
		this.currentPage = currentPageParam < 1 ? 1L : currentPageParam;

		this.setPageSize( DEFAULT_PAGE_LIST_SIZE, DEFAULT_PAGE_GROUP_LIST_SIZE );

		initDefaultLabels();
		initDefaultClasses();
	}

	protected void initDefaultLabels() {
		this.labelFirstPage = DEFAULT_LABEL_FIRST_PAGE;
		this.labelGroupNext = DEFAULT_LABEL_GROUP_NEXT;
		this.labelGroupPrevious = DEFAULT_LABEL_GROUP_PREV;
		this.labelLastPage = DEFAULT_LABEL_LAST_PAGE;
	}

	protected void initDefaultClasses() {
		this.classCurrentPage = DEFAULT_CLASS_CURRENT_PAGE;
		this.classFirstPage = DEFAULT_CLASS_FIRST_PAGE;
		this.classGroupNext = DEFAULT_CLASS_GROUP_NEXT;
		this.classGroupPrevious = DEFAULT_CLASS_GROUP_PREV;
		this.classLastPage = DEFAULT_CLASS_LAST_PAGE;
	}

	public String getLabelFirstPage () {

		return labelFirstPage;
	}

	public void setLabelFirstPage ( final String labelFirstPageParam ) {

		labelFirstPage = labelFirstPageParam;
	}

	public String getLabelLastPage () {

		return labelLastPage;
	}

	public void setLabelLastPage ( final String labelLastPageParam ) {

		labelLastPage = labelLastPageParam;
	}

	public String getLabelGroupPrevious () {

		return labelGroupPrevious;
	}

	public void setLabelGroupPrevious ( final String labelGroupPreviousParam ) {

		labelGroupPrevious = labelGroupPreviousParam;
	}

	public String getLabelGroupNext () {

		return labelGroupNext;
	}

	public void setLabelGroupNext ( final String labelGroupNextParam ) {

		labelGroupNext = labelGroupNextParam;
	}

	public String getClassCurrentPage() {
		return classCurrentPage;
	}

	public void setClassCurrentPage(String classCurrentPage) {
		this.classCurrentPage = classCurrentPage;
	}

	public String getClassFirstPage() {
		return classFirstPage;
	}

	public void setClassFirstPage(String classFirstPage) {
		this.classFirstPage = classFirstPage;
	}

	public String getClassLastPage() {
		return classLastPage;
	}

	public void setClassLastPage(String classLastPage) {
		this.classLastPage = classLastPage;
	}

	public String getClassGroupPrevious() {
		return classGroupPrevious;
	}

	public void setClassGroupPrevious(String classGroupPrevious) {
		this.classGroupPrevious = classGroupPrevious;
	}

	public String getClassGroupNext() {
		return classGroupNext;
	}

	public void setClassGroupNext(String classGroupNext) {
		this.classGroupNext = classGroupNext;
	}

	public final void setDataSize ( final long dataSizeParam ) {

		this.dataSize = dataSizeParam;
		this.setPageGroupRange();

		this.currentPage = this.currentPage > this.pageTotalCount ? this.pageTotalCount : this.currentPage;
	}

	public long getDataSize () {

		return dataSize;
	}

	public void setCurrentPage ( final long currentPageParam ) {

		this.currentPage = currentPageParam;

		this.rowStartNumber = ( this.currentPage - 1 ) * this.pageListSize;
		this.rowEndNumber = this.currentPage * this.pageListSize;
	}

	public long getCurrentPage () {

		return this.currentPage;
	}

	public final int getPageGroupSize() {
		return this.pageGroupSize;
	}

	public final int getPageListSize () {

		return this.pageListSize;
	}

	public final long getRowStartNumber () {

		return this.rowStartNumber;
	}

	public final long getRowEndNumber () {

		return this.rowEndNumber;
	}

	public final void setPageSize ( final int pageListSizeParam, final int pageGroupSizeParam ) {

		this.pageGroupSize = pageGroupSizeParam;
		this.pageListSize = pageListSizeParam;

		this.rowStartNumber = ( this.currentPage - 1 ) * this.pageListSize;
		this.rowEndNumber = this.currentPage * this.pageListSize;

		setPageGroupRange();
	}

	private void setPageGroupRange () {

		this.pageTotalCount = this.pageListSize < 1 ? this.dataSize : ( ( this.dataSize - 1 ) / this.pageListSize ) + 1;
//    this.currentPage = this.currentPage > this.pageTotalCount ? this.pageTotalCount : this.currentPage;
		this.pageGroupStartPage = ( this.currentPage - 1 ) / this.pageGroupSize * this.pageGroupSize + 1;
		this.pageGroupEndPage = this.pageGroupStartPage + this.pageGroupSize - 1;
		if ( this.pageGroupEndPage > this.pageTotalCount )
			this.pageGroupEndPage = this.pageTotalCount;
	}

	public final boolean isFirstPage () {

		return this.currentPage == 1 ? true : false;
	}

	public final boolean isLastPage () {

		return this.currentPage == this.pageTotalCount ? true : false;
	}

	public final boolean hasPreviousPage () {

		return this.currentPage - 1 > 0;
	}

	public final boolean hasNextPage () {

		return this.currentPage + 1 <= this.pageTotalCount;
	}

	public final boolean hasPreviousPageGroup () {

		return getPageGroupStartPage() - 1 > 0;
	}

	public final boolean hasNextPageGroup () {

		return ( getPageGroupEndPage() + 1 ) <= this.pageTotalCount;
	}

	public final long getPreviousPage () {

		return this.hasPreviousPage() ? this.currentPage - 1 : 1;
	}

	public final long getNextPage () {

		return this.hasNextPage() ? this.currentPage + 1 : this.pageTotalCount;
	}

	public final long getPageGroupStartPage () {

		return this.pageGroupStartPage;
	}

	public final long getPageGroupEndPage () {

		return this.pageGroupEndPage;
	}

	public final long getPageTotalCount () {

		return this.pageTotalCount;
	}

	public final long getPreviousGroupStartPage () {

		return this.hasPreviousPageGroup() ? this.getPageGroupStartPage() - ( this.pageGroupSize * this.pageListSize ) : 1;
	}

	public final long getPreviousGroupEndPage () {

		return this.hasPreviousPageGroup() ? this.getPageGroupStartPage() - 1 : this.pageTotalCount;
	}

	public final long getNextGroupStartPage () {

		return this.hasNextPageGroup() ? this.getPageGroupEndPage() + 1 : 1;
	}

	public final long getNextGroupEndPage () {

		long nextGroupEndPage = ( this.getPageGroupEndPage() + ( this.pageGroupSize * this.pageListSize ) );
		return this.hasNextPageGroup() ? nextGroupEndPage > this.pageTotalCount ? this.pageTotalCount : nextGroupEndPage
				: this.pageTotalCount;
	}

	public final Map< String, Object > getPageParams () {

		return this.pageParams == null ? new HashMap< String, Object >() : this.pageParams;
	}

	public final void setPageParams ( final Map< String, Object > mapParam ) {

		this.pageParams = mapParam;
	}

	public final String getPageParamString () {

		if ( this.pageParams == null || this.pageParams.isEmpty() )
			return "";

		StringBuilder mStringBuilder;
		Set< String > paramKeySet;
		Iterator< String > keySetIterator;

		mStringBuilder = new StringBuilder();
		paramKeySet = this.pageParams.keySet();
		keySetIterator = paramKeySet.iterator();

		String paramKeyName;
		while ( keySetIterator.hasNext() ) {
			mStringBuilder.append( '&' );

			paramKeyName = keySetIterator.next();
			mStringBuilder.append( paramKeyName );
			mStringBuilder.append( "=" + this.pageParams.get( paramKeyName ) );
		}

		return mStringBuilder.toString();
	}

	public final void setPageParamString ( final String stringParam ) {

		if ( StringUtils.isEmptyWithTrim( stringParam ) )
			this.pageParams = new HashMap< String, Object >();

		this.pageParams = new ConcurrentHashMap< String, Object >();
		String trimmedStringParam = StringUtils.trimWhitespace( stringParam );
		String[] paramList = StringUtils.tokenizeToStringArray( trimmedStringParam, "&" );
		String[] paramItemSplit;
		int paramCount = paramList.length;
		int paramItemSplitCount = 2;
		for ( int i = 0; i < paramCount; i++ ) {
			paramItemSplit = StringUtils.tokenizeToStringArray( paramList[i], "=" );
			if ( paramItemSplit.length == paramItemSplitCount ) {
				this.pageParams.put( StringUtils.trimWhitespace( paramItemSplit[0] ),
						StringUtils.trimWhitespace( paramItemSplit[1] ) );
			}
		}
	}

	public final < T > T getPageParamValue ( final String keyName ) {

		if ( this.pageParams == null || this.pageParams.isEmpty() )
			return null;

		if ( this.pageParams.containsKey( keyName ) )
			return (T) this.pageParams.get( keyName );

		return null;
	}
}
