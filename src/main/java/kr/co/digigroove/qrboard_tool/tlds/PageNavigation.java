package kr.co.digigroove.qrboard_tool.tlds;

import kr.co.digigroove.commons.utils.JsonUtils;
import kr.co.digigroove.qrboard_tool.entities.common.PageNavigationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.tags.form.AbstractHtmlElementTag;
import org.springframework.web.servlet.tags.form.TagWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.Map;

public class PageNavigation extends AbstractHtmlElementTag {

  private static final Logger LOGGER = LoggerFactory.getLogger( kr.co.digigroove.commons.tlds.PageNavigation.class );

  protected PageNavigationEntity pageNavigationEntity;

  protected String linkUrl;
  protected String linkScript;
  protected String pageParamName;
  protected boolean isAjaxList             = false;
  protected boolean showFirstLastIndicator = true;
  protected boolean showPageGroupIndicator = true;

  public PageNavigationEntity getPageNavigationEntity () {

    return this.pageNavigationEntity;
  }

  public void setPageNavigationEntity ( final PageNavigationEntity pageNavigationEntityParam ) {

    this.pageNavigationEntity = pageNavigationEntityParam;
  }

  public void setPageParamName ( final String pageParamNameParam ) {

    this.pageParamName = pageParamNameParam;
  }

  public void setShowFirstLastIndicator ( final boolean showFirstLastIndicatorParam ) {

    this.showFirstLastIndicator = showFirstLastIndicatorParam;
  }

  public void setShowPageGroupIndicator ( final boolean showPageGroupIndicatorParam ) {

    this.showPageGroupIndicator = showPageGroupIndicatorParam;
  }

  public String getLinkUrl () {

    return this.linkUrl;
  }

  public void setLinkUrl ( final String linkUrlParam ) {

    this.linkUrl = linkUrlParam;
    this.isAjaxList = false;
  }

  public String getLinkScript () {

    return this.linkScript;
  }

  public void setLinkScript ( final String linkScriptParam ) {

    this.linkScript = linkScriptParam;
    this.isAjaxList = true;
  }

  public boolean isAjaxList () {

    return this.isAjaxList;
  }

  public void setAjaxList ( final boolean isAjaxListParam ) {

    this.isAjaxList = isAjaxListParam;
  }

  protected String getNavigationUrlLink ( final long targetPage ) {

    if ( this.isAjaxList ) {
      StringBuilder ajaxParamString = new StringBuilder();
      ajaxParamString.append( "javascript:" );
      ajaxParamString.append( this.linkScript );
      ajaxParamString.append( "(" );
      Map< String, Object > paramMap = this.pageNavigationEntity.getPageParams();
      paramMap.put( this.pageParamName, targetPage );
      try {
        ajaxParamString.append( JsonUtils.objectToJsonString( paramMap ) );
      } catch ( IOException e ) {
        LOGGER.error( "JSON convert error", e );
      }
      ajaxParamString.append( ");" );
      return ajaxParamString.toString();
    } else {
      return this.linkUrl + "?" + this.pageParamName + "=" + targetPage + this.pageNavigationEntity
        .getPageParamString();
    }
  }

  @Override
  protected int writeTagContent ( final TagWriter tagWriterParam ) throws JspException {

    StringBuilder tagString = new StringBuilder();

    //***************************** MOBILE *****************************//
    if ( !this.pageNavigationEntity.isFirstPage() )
      tagString.append( "<a class='prev' href='"+ this.getNavigationUrlLink( this.pageNavigationEntity.getPreviousPage() ) +"'>&lt;</a>" );
    else if ( this.pageNavigationEntity.isFirstPage() )
      tagString.append( "<a class='prev' href='#'>&lt;</a>" );

    tagString.append( this.pageNavigationEntity.getCurrentPage() + "<span class='bold'>/" +  this.pageNavigationEntity.getPageTotalCount() + "</span>");

    if ( !this.pageNavigationEntity.isLastPage() )
      tagString.append( "<a class='next' href='"+ this.getNavigationUrlLink( this.pageNavigationEntity.getNextPage() ) +"'>&gt;</a>" );
    else if ( this.pageNavigationEntity.isLastPage() )
      tagString.append( "<a class='next' href='#'>&gt;</a>" );
    //***************************** MOBILE *****************************//

    JspWriter jspWriter = pageContext.getOut();
    try {
      jspWriter.write( tagString.toString() );
    } catch ( IOException e ) {
      LOGGER.error( "Error : Navigation tag writer", e );
    }

    return EVAL_PAGE;
  }
}
