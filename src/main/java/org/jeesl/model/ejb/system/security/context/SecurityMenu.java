package org.jeesl.model.ejb.system.security.context;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeesl.interfaces.qualifier.er.EjbErNode;
import org.jeesl.model.ejb.system.security.page.SecurityView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="SecurityMenu",uniqueConstraints=@UniqueConstraint(name="UK_SecurityMenu_context_view",columnNames={"view_id"}))
@EjbErNode(name="SecurityMenu")
public class SecurityMenu implements Serializable
{
	public static final long serialVersionUID=1;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	 public long getId() {return id;}
	 public void setId(long id) {this.id = id;}


	
	@ManyToOne
	private SecurityMenu parent;
	 public SecurityMenu getParent() {return parent;}
	 public void setParent(SecurityMenu parent) {this.parent = parent;}

	private int position;
	 public int getPosition() {return position;}
	 public void setPosition(int position) {this.position = position;}

	private Boolean visible;
	 public Boolean getVisible() {return visible;}
	 public void setVisible(Boolean visible) {this.visible = visible;}

	@NotNull @OneToOne
	private SecurityView view;
	 public SecurityView getView() {return view;}
	 public void setView(SecurityView view) {this.view = view;}



	@Override public boolean equals(Object object){return (object instanceof SecurityMenu) ? id == ((SecurityMenu) object).getId() : (object == this);}
	@Override public int hashCode() {return new HashCodeBuilder(17, 53).append(id).toHashCode();}

	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(id).append("]");
		return sb.toString();
	}
}