package com.climatetree.places;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.climatetree.places.controller.PlacesControllerTest;
import com.climatetree.places.dao.NameRepositoryTest;
import com.climatetree.places.service.NameServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ PlacesMicroserviceServerApplicationTests.class, PlacesControllerTest.class, NameServiceTest.class,
		NameRepositoryTest.class })
public class PlacesTestSuite {

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Master setup");

	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Master tearDown");
	}
}
