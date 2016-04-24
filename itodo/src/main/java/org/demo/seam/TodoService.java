package org.demo.seam;

import java.util.List;

import org.hibernate.Session;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.log.Log;

@Name("todoService")
@Scope(ScopeType.SESSION)
public class TodoService {
	
	@Logger
	private Log logger;
	
	@In
	private Session session;

//	@PersistenceContext(type = EXTENDED)
//	private EntityManager em;

	@DataModel
	private List<Todo> todos;

	@SuppressWarnings("unchecked")
	@Factory("todos")
	public void getAll() {
//		todos = em.createQuery(
//				"select todo from Todo todo order by todo.id desc")
//				.getResultList();
		todos = session.createQuery("select todo from Todo todo order by todo.id desc").list();
	}

	public String done() {
		logger.info("33333333333333Call done()");
		return "hellox";
	}
}
