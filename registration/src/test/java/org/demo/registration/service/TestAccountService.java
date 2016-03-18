package org.demo.registration.service;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.demo.registration.domain.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestAccountService {
    private static final Logger LOGGER = Logger.getLogger(TestAccountService.class.getName());

    @Inject
    private AccountService service;

    @Deployment
    public static JavaArchive createTestableDeployment() {
        final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "example.jar")
                .addClasses(User.class, AccountService.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                // Enable CDI
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));

        LOGGER.info(jar.toString(Formatters.VERBOSE));

        return jar;
    }

    @Test
    public void addUser() {
        final User user = new User("ike", "pwd1","dustin");
        service.setUser(user);
        String result = service.register();
        
        System.out.println("result=" + result);
        //assertNotNull("User id should not be null!",user.getId());
    }
}
