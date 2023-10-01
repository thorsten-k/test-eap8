package org.jeesl.model.ejb.io.locale;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeesl.interfaces.model.system.locale.JeeslDescription;

@Entity
@Table(name="IoDescription")
public class IoDescription implements JeeslDescription
{
	public static final long serialVersionUID=1l;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Override public long getId() {return id;}
	@Override public void setId(long id) {this.id = id;}

	@NotNull
	private String lkey;
	@Override public String getLkey() {return lkey;}
	@Override public void setLkey(String lkey) {this.lkey = lkey;}

	@NotNull @Basic @Column(columnDefinition="text")
	private String lang;
	@Override public String getLang() {return lang;}
	@Override public void setLang(String name) {this.lang = name;}

	private Boolean styled;
	@Override public Boolean getStyled() {return styled;}
	@Override public void setStyled(Boolean styled) {this.styled = styled;}


	@Override public boolean equals(Object object) {return (object instanceof IoDescription) ? id == ((IoLang) object).getId() : (object == this);}
	@Override public int hashCode() {return new HashCodeBuilder(19,21).append(id).toHashCode();}

	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append(" ["+lkey+"]");
		sb.append(" "+lang);
		return sb.toString();
	}
}