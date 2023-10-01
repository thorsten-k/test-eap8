package org.jeesl.model.ejb.system.security.access;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeesl.interfaces.model.system.security.access.JeeslSecurityRole;
import org.jeesl.interfaces.qualifier.er.EjbErNode;
import org.jeesl.model.ejb.io.locale.IoDescription;
import org.jeesl.model.ejb.io.locale.IoLang;
import org.jeesl.model.ejb.system.security.SecurityCategory;
import org.jeesl.model.ejb.system.security.page.SecurityView;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="SecurityRole",uniqueConstraints=@UniqueConstraint(columnNames={"code"}))
@EjbErNode(name="SecurityRole")
public class SecurityRole implements Serializable
{
	public static final long serialVersionUID=1;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}

	
	@NotNull @ManyToOne
	private SecurityCategory category;
	 public SecurityCategory getCategory() {return category;}
	 public void setCategory(SecurityCategory category) {this.category = category;}

	@NotNull
	private String code;
	 public String getCode() {return code;}
	 public void setCode(String code) {this.code = code;}

	private boolean visible;
	 public boolean isVisible() {return visible;}
	 public void setVisible(boolean visible) {this.visible = visible;}

	private Boolean documentation;
	 public Boolean getDocumentation() {return documentation;}
	 public void setDocumentation(Boolean documentation) {this.documentation = documentation;}

	private int position;
	 public int getPosition() {return position;}
	 public void setPosition(int position) {this.position = position;}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@MapKey(name="lkey")
	@JoinTable(name="SecurityRoleJtLang",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="lang_id")})
	private Map<String,IoLang> name;
	 public Map<String,IoLang> getName() {return name;}
	 public void setName(Map<String,IoLang> name) {this.name = name;}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@MapKey(name="lkey")
	@JoinTable(name="SecurityRoleJtDescription",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="description_id")})
	private Map<String,IoDescription> description;
	 public Map<String,IoDescription> getDescription() {return description;}
	 public void setDescription(Map<String,IoDescription> description) {this.description = description;}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="SecurityRoleJtView",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="view_id")})
	private List<SecurityView> views;
	 public List<SecurityView> getViews() {if(Objects.isNull(views)) {views = new ArrayList<>();} return views;}
	 public void setViews(List<SecurityView> views) {this.views = views;}


	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="SecurityRoleJtUsecase",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="usecase_id")})
	private List<SecurityUsecase> usecases;
	 public List<SecurityUsecase> getUsecases() {if(Objects.isNull(usecases)) {usecases = new ArrayList<>();} return usecases;}
	 public void setUsecases(List<SecurityUsecase> usecases) {this.usecases = usecases;}


	@Override public boolean equals(Object object){return (object instanceof SecurityRole) ? id == ((SecurityRole) object).getId() : (object == this);}
	@Override public int hashCode() {return new HashCodeBuilder(17,53).append(id).toHashCode();}

	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(id).append("]");
		sb.append(" ").append(code);
		return sb.toString();
	}
}