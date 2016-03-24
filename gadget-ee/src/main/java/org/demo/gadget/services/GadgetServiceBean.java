package org.demo.gadget.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.demo.gadget.domain.Gadget;

@Stateless
@Named("gadgetService")
public class GadgetServiceBean implements IGadgetService, Serializable {

	private static final long serialVersionUID = -1L;
	
	@Inject
	private Logger logger;
	
	@Inject
	private EntityManager em;

	@Inject
	@Named("gadget")
	private Gadget activeGadget;

	public Gadget getActiveGadget() {
		return activeGadget;
	}

	public void setActiveGadget(Gadget gadget) {
		activeGadget = gadget;
	}

//	@PostConstruct
//	public void initNewSeatType() {
//		newSeatType = new SeatType();
//	}
	
	/** Retrieve all gadgets from the catalog, ordered by description */
	@SuppressWarnings("unchecked")
	public List<Gadget> getAllGadgets() {
		List<Gadget> gadgets = new ArrayList<Gadget>();

		try {
			Query q = em.createQuery("select g from Gadget as g order by g.description");
			gadgets = (List<Gadget>) q.getResultList();
			// Iterator i = gList.iterator();
			// while (i.hasNext()) {
			// gadgets.add((GadgetBean)i.next());
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gadgets;
	}

	/**
	 * Insert the gadget just created/edited into the catalog
	 */
	public String newGadget() {

		logger.info("Call newGadget()");
		newGadget(getActiveGadget());
		return "success";
	}

	/** Insert a new gadget into the catalog */
	public void newGadget(Gadget g) {
		try {
			em.persist(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}