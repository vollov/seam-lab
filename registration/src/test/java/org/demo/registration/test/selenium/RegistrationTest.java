package org.demo.registration.test.selenium;

//import org.jboss.seam.example.common.test.selenium.SeamSeleniumTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import static org.testng.AssertJUnit.assertTrue;
//import static org.testng.AssertJUnit.assertEquals;
//
///**
// * This class tests registration form functionality in registration example.
// * 
// * @author Jozef Hartinger
// * 
// */
//public class RegistrationTest extends SeamSeleniumTest
//{
//   protected static String REGISTRATION_URL = "/register.seam";
//   protected static String REGISTRATION_USERNAME = "registration:username";
//   protected static String REGISTRATION_NAME = "registration:name";
//   protected static String REGISTRATION_PASSWORD = "registration:password";
//   protected static String REGISTRATION_SUBMIT = "registration:register";
//   protected static String REGISTRATION_MESSAGE = "registration:messages";
//   protected static String REGISTRATION_MESSAGE_COUNT = "//ul[@id='registration:messages']/li";
//   protected static String REGISTERED_URL = "/registered.seam";
//
//   @Override
//   @BeforeMethod
//   public void setUp()
//   {
//      super.setUp();
//      browser.open(CONTEXT_PATH + REGISTRATION_URL);
//   }
//
//   @Test
//   public void simpleRegistrationTest()
//   {
//      String username = "johny";
//      String name = "John Doe";
//      String password = "secretPassword";
//      submitRegistrationForm(username, name, password);
//      assertTrue("After-registration page expected.", browser.getLocation().contains(REGISTERED_URL));
//      assertTrue("Welcome message should contain username.", browser.isTextPresent(username));
//      assertTrue("Welcome message should contain name.", browser.isTextPresent(name));
//   }
//
//   @Test(dependsOnMethods = { "simpleRegistrationTest" })
//   public void duplicateUsernameTest()
//   {
//      String username = "jane";
//      String name = "Jane Doe";
//      String password = "secretPassword";
//      submitRegistrationForm(username, name, password);
//      browser.goBackAndWait();
//      submitRegistrationForm(username, name, password);
//      assertTrue("Registration page expected.", browser.getLocation().contains(REGISTRATION_URL));
//      assertTrue("Error message did not appear.", browser.isElementPresent(REGISTRATION_MESSAGE));
//   }
//
//   @Test
//   public void emptyValuesTest()
//   {
//      submitRegistrationForm("", "", "");
//      assertTrue("Registration page expected.", browser.getLocation().contains(REGISTRATION_URL));
//      assertEquals("Unexpected number of error messages.", 3, browser.getXpathCount(REGISTRATION_MESSAGE_COUNT));
//   }
//
//   protected void submitRegistrationForm(String username, String name, String password)
//   {
//      browser.type(REGISTRATION_USERNAME, username);
//      browser.type(REGISTRATION_NAME, name);
//      browser.type(REGISTRATION_PASSWORD, password);
//      browser.clickAndWait(REGISTRATION_SUBMIT);
//   }
//
//}
