package org.jboss.seam;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.ScopeType;
import java.util.List;
import java.util.ArrayList;

@Name("hedgehogService")
@Scope(ScopeType.SESSION)
public class HedgehogService {

	@DataModel
	private List<Hedgehog> hedgehogs;

	public HedgehogService() {
		hedgehogs = new ArrayList<Hedgehog>();
		hedgehogs.add(new Hedgehog("Holger"));
		hedgehogs.add(new Hedgehog("Pete"));
		hedgehogs.add(new Hedgehog("Sebastian"));
	}

	public String getHello() {
		return "Your hedgehogService says hello";
	}
}