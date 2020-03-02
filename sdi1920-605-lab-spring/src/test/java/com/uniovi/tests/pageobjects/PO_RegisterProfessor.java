package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_RegisterProfessor extends PO_NavView{
	static public void fillForm(WebDriver driver, String dnip, String nombrep, String apellidosp, String catp) {
		WebElement dni = driver.findElement(By.name("dni"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnip);
		WebElement nombre = driver.findElement(By.name("nombre"));
		nombre.click();
		nombre.clear();
		nombre.sendKeys(nombrep);
		WebElement apellidos = driver.findElement(By.name("apellidos"));
		apellidos.click();
		apellidos.clear();
		apellidos.sendKeys(apellidosp);
		WebElement cat = driver.findElement(By.name("categoria"));
		cat.click();
		cat.clear();
		cat.sendKeys(catp);
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}
