package de.kisner.test.eap.facade;

import java.io.Serializable;
import java.util.List;

public interface EapFacade extends Serializable
{	
	public enum IoSsiSystemCode {eap}
	
	<T extends Object> List<T> all(Class<T> type);
	<T extends Object> T find(Class<T> type, long id);
}