package org.demo.gadget.services;

import java.util.List;

import javax.ejb.Local;

import org.demo.gadget.domain.Gadget;

@Local
public interface IGadgetService {
	public String newGadget();
    public void newGadget(Gadget gadget);
    public List<Gadget> getAllGadgets();
}
