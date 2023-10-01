package org.jeesl.model.ejb.system.security.page;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeesl.interfaces.qualifier.er.EjbErNode;
import org.jeesl.model.ejb.io.locale.IoDescription;
import org.jeesl.model.ejb.io.locale.IoLang;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="SecurityArea",uniqueConstraints=@UniqueConstraint(columnNames={"view_id","code"}))
@EjbErNode(name="Area")
public class SecurityArea implements Serializable
{
	public static final long serialVersionUID=1;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	 public long getId() {return id;}
	 public void setId(long id) {this.id = id;}

	
	@NotNull @ManyToOne
	private SecurityView view;
	 public SecurityView getView() {return view;}
	 public void setView(SecurityView view) {this.view = view;}

	@NotNull
	private String code;
	 public String getCode() {return code;}
	 public void setCode(String code) {this.code = code;}

	private int position;
	 public int getPosition() {return position;}
	 public void setPosition(int position) {this.position = position;}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@MapKey(name="lkey")
	@JoinTable(name="SecurityAreaJtLang",joinColumns={@JoinColumn(name="area_id")},inverseJoinColumns={@JoinColumn(name="lang_id")})
	private Map<String,IoLang> name;
	 public Map<String,IoLang> getName() {return name;}
	 public void setName(Map<String,IoLang> name) {this.name = name;}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@MapKey(name="lkey")
	@JoinTable(name="SecurityAreaJtDescription",joinColumns={@JoinColumn(name="area_id")},inverseJoinColumns={@JoinColumn(name="description_id")})
	private Map<String,IoDescription> description;
	 public Map<String,IoDescription> getDescription() {return description;}
	 public void setDescription(Map<String,IoDescription> description) {this.description = description;}

	private boolean restricted;
	 public boolean isRestricted() {return restricted;}
	 public void setRestricted(boolean restricted) {this.restricted = restricted;}

	private Boolean visible;
	 public Boolean getVisible() {return visible;}
	 public void setVisible(Boolean visible) {this.visible=visible;}


	@Override public boolean equals(Object object){return (object instanceof SecurityArea) ? id == ((SecurityArea) object).getId() : (object == this);}
	@Override public int hashCode() {return new HashCodeBuilder(17, 53).append(id).toHashCode();}

	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(id).append("]");
		return sb.toString();
	}
}