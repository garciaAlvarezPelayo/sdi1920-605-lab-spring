package com.uniovi.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterProfessor;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplementariosTests {

	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\uo264761\\Downloads\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() throws Exception {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	@Test
	public void PRC01() {
		PO_PrivateView.log(driver, "99999988F", "123456");
		PO_PrivateView.clickElement(driver, "free", "//a[contains(@href, '/teacher/add')]", 0);
		PO_RegisterProfessor.fillForm(driver, "12121212H", "Alberto", "Manuel Fernandez", "Informática");
		PO_View.checkElement(driver, "text", "12121212H");
	}

	@Test
	public void PRC02() {
		PO_PrivateView.log(driver, "99999988F", "123456");
		PO_PrivateView.clickElement(driver, "free", "//a[contains(@href, '/teacher/add')]", 0);
		PO_RegisterProfessor.fillForm(driver, "12121212J", "Alb", "Manuel Fernandez", "inf");
		PO_View.checkElement(driver, "h2", "Agregar Profesor");
	}

	@Test
	public void PRC03() {
		PO_PrivateView.log(driver, "99999990A", "123456");
		By boton = By.id("professors-menu");
		try{
			driver.findElement(boton); 
		}catch(NoSuchElementException e){
			//Significa que no existe la opción para un alumno de gestionar profesores
		}
	}
	
	@Test
	public void PRC04() {
		PO_PrivateView.log(driver, "99999993D", "123456");
		By boton = By.id("professors-menu");
		try{
			driver.findElement(boton); 
		}catch(NoSuchElementException e){
			//Significa que no existe la opción para un profesor de gestionar profesores
		}
	}

}
