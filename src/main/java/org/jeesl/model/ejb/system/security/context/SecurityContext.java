package org.jeesl.model.ejb.system.security.context;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeesl.interfaces.qualifier.er.EjbErNode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="SecurityContext",uniqueConstraints=@UniqueConstraint(columnNames = {"code"}))
@EjbErNode(name="SecurityContext")
public class SecurityContext implements Serializable
{
	public static final long serialVersionUID=1;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	 public long getId() {return id;}
	 public void setId(long id) {this.id = id;}

	@NotNull
	private String code;
	 public String getCode() {return code;}
	 public void setCode(String code) {this.code = code;}

	private int position;
	 public int getPosition() {return position;}
	 public void setPosition(int position) {this.position = position;}


	private String serverName;
	 public String getServerName() {return serverName;}
	 public void setServerName(String serverName) {this.serverName = serverName;}

	private String pageTitle;
	 public String getPageTitle() {return pageTitle;}
	 public void setPageTitle(String pageTitle) {this.pageTitle = pageTitle;}

	private String pagePrefix;
	 public String getPagePrefix() {return pagePrefix;}
	 public void setPagePrefix(String pagePrefix) {this.pagePrefix = pagePrefix;}

	private String pageHeadline;
	 public String getPageHeadline() {return pageHeadline;}
	 public void setPageHeadline(String pageHeadline) {this.pageHeadline = pageHeadline;}

	private String pageCss;
	 public String getPageCss() {return pageCss;}
	 public void setPageCss(String pageCss) {this.pageCss = pageCss;}

	private String pageLogo;
	 public String getPageLogo() {return pageLogo;}
	 public void setPageLogo(String pageLogo) {this.pageLogo = pageLogo;}

	private String pageBackground;
	 public String getPageBackground() {return pageBackground;}
	 public void setPageBackground(String pageBackground) {this.pageBackground = pageBackground;}

	private String linkImpressum;
	 public String getLinkImpressum() {return linkImpressum;}
	 public void setLinkImpressum(String linkImpressum) {this.linkImpressum = linkImpressum;}

	private String emailAddress;
	 public String getEmailAddress() {return emailAddress;}
	 public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

	private String emailName;
	 public String getEmailName() {return emailName;}
	 public void setEmailName(String emailName) {this.emailName = emailName;}

	private Long contextId;
	 public Long getContextId() {return contextId;}
	 public void setContextId(Long contextId) {this.contextId = contextId;}


	@Override public boolean equals(Object object){return (object instanceof SecurityContext) ? id == ((SecurityContext) object).getId() : (object == this);}
	@Override public int hashCode() {return new HashCodeBuilder(17, 53).append(id).toHashCode();}
	
	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(id).append("]");
		sb.append(" code="+code);
		return sb.toString();
	}
}