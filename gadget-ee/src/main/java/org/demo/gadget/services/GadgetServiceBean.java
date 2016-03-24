package org.demo.gadget.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.demo.gadget.domain.Gadget;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Stateless
@Name("gadgetService")
public class GadgetServiceBean implements IGadgetService {
	
	@Logger
	private Log logger;
	
    @PersistenceContext
    private EntityManager em;
    
    @In(value="gadget", create=true)
    private Gadget activeGadget;

	public Gadget getActiveGadget() {
		return activeGadget;
	}

	public void setActiveGadget(Gadget gadget) {
		activeGadget = gadget;
	}
	
    /** Retrieve all gadgets from the catalog, ordered by description */
    @SuppressWarnings("unchecked")
	public List<Gadget> getAllGadgets() {
        List<Gadget> gadgets = new ArrayList<Gadget>();
        
        try {
            Query q = em.createQuery("select g from GadgetBean as g order by g.description");
            gadgets = (List<Gadget>)q.getResultList();
//            Iterator i = gList.iterator();
//            while (i.hasNext()) {
//                gadgets.add((GadgetBean)i.next());
//            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return gadgets;
    }

    /** Insert the gadget just created/edited into
     *  the catalog
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}