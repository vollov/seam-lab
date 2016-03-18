package org.demo.registration.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.demo.registration.domain.User;

@RequestScoped
@ManagedBean(name = "accountService", eager = true)
@Stateless
public class AccountService {

	@Inject
	private User user;

	@PersistenceContext
	private EntityManager em;

	private static Log log;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * register a new user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String register() {
		List<User> existing = em.createQuery("select u.username from User u where u.username=#{user.username}")
				.getResultList();

		log.info("Registered new user #{user.username}");
		
		if (existing.size() == 0) {
			em.persist(user);
		}
		
		return "ok";
//		if (existing.size() == 0) {
//			em.persist(user);
//			log.info("Registered new user #{user.username}");
//			return "/registered.xhtml";
//		} else {
//			//FacesMessages.instance().add("User #{user.username} already exists");
//			return null;
//		}
	}

}
