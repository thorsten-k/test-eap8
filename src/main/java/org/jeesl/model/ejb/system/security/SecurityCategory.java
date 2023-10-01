package org.jeesl.model.ejb.system.security;

import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeesl.interfaces.model.system.security.util.JeeslSecurityCategory;
import org.jeesl.interfaces.qualifier.er.EjbErNode;
import org.jeesl.model.ejb.io.locale.IoDescription;
import org.jeesl.model.ejb.io.locale.IoLang;

@Entity
@Table(name="SecurityCategory",uniqueConstraints=@UniqueConstraint(columnNames={"type","code"}))
@EjbErNode(name="SecurityCategory")
public class SecurityCategory implements JeeslSecurityCategory<IoLang,IoDescription>
{
	public static final long serialVersionUID=2;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Override public long getId() {return id;}
	@Override public void setId(long id) {this.id = id;}

	@NotNull
	private String code;
	@Override public String getCode() {return code;}
	@Override public void setCode(String code) {this.code = code;}

	@NotNull
	private String type;
	@Override public String getType() {return type;}
	@Override public void setType(String type) {this.type = type;}

	private boolean visible;
	@Override public boolean isVisible() {return visible;}
	@Override public void setVisible(boolean visible) {this.visible = visible;}

	private Boolean documentation;
	@Override public Boolean getDocumentation() {return documentation;}
	@Override public void setDocumentation(Boolean documentation) {this.documentation = documentation;}

	private int position;
	@Override public int getPosition() {return position;}
	@Override public void setPosition(int position) {this.position = position;}

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@MapKey(name="lkey")
	@JoinTable(name="SecurityCategoryJtLang",joinColumns={@JoinColumn(name="category_id")},inverseJoinColumns={@JoinColumn(name="lang_id")})
	private Map<String,IoLang> name;
	@Override public Map<String,IoLang> getName() {return name;}
	@Override public void setName(Map<String,IoLang> name) {this.name = name;}

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@MapKey(name="lkey")
	@JoinTable(name="SecurityCategoryJtDescription",joinColumns={@JoinColumn(name="category_id")},inverseJoinColumns={@JoinColumn(name="description_id")})
	private Map<String,IoDescription> description;
	@Override public Map<String,IoDescription> getDescription() {return description;}
	@Override public void setDescription(Map<String,IoDescription> description) {this.description = description;}


	@Override public boolean equals(Object object) {return (object instanceof SecurityCategory) ? id == ((SecurityCategory) object).getId() : (object == this);}
	@Override public int hashCode() {return new HashCodeBuilder(23,43).append(id).toHashCode();}

	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("id="+id);
		return sb.toString();
	}
}