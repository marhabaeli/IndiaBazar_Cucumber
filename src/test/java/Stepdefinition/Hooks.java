package Stepdefinition;

import java.io.IOException;

import Base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends TestBase{
@Before("@OpenBrowser")
public void beforeHook() throws IOException {
	System.out.println("---it is opening browser---");
	setUp();
}

@After("@CloseBrowser")
public void afterHook() {
	tearDown();
}
}
