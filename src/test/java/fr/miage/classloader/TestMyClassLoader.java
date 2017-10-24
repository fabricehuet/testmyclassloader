package fr.miage.classloader;


import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMyClassLoader {

	private static final String EXISTING_CLASSNAME = "fr.miage.custom.MyCustomInt";
	
	private static final String NON_EXISTING_CLASSNAME = "fr.miage.custom.NoARealClass";

	
	private static final String DIRECTORY ="src/test/resources/data";
	
	private static final String ZIPFILE_WITH_EXTENSION = "src/test/resources/data/truc.zip";
	private static final String ZIPFILE_WITHOUT_EXTENSION = "src/test/resources/data/truc.xxxzip";
	
	private static final String JARFILE_WITH_EXTENSION = "src/test/resources/data/truc.jar";
	private static final String JARFILE_WITHOUT_EXTENSION = "src/test/resources//data/truc.xxxjar";
	
	private ArrayList<File> al; 
	
	@Before
	public void setup() {
		al = new ArrayList<File>();
	}
	
	@After
	public void teardown() {
		al = new ArrayList<File>();
	}
	
	// ---------- Tests lecture depuis répertoire ------------	
	@Test
	public void testLoadingFromDirectory() {
		al.add(new File(DIRECTORY));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			Assert.assertNotNull(mcl.loadClass(EXISTING_CLASSNAME));		
		} catch (ClassNotFoundException e) {
			Assert.fail(e.toString());		
		}
	}
	
	@Test
	public void testNotLoadingFromDirectory() {
		al.add(new File(DIRECTORY));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			mcl.loadClass(NON_EXISTING_CLASSNAME);
		} catch (ClassNotFoundException e) {
			Assert.assertTrue(true);	
		}
	}
	
	// --------- Tests lecture depuis zip --------------
	@Test
	public void testLoadingFromZip() {
		al.add(new File(ZIPFILE_WITH_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			Assert.assertNotNull(mcl.loadClass(EXISTING_CLASSNAME));
		} catch (ClassNotFoundException e) {
			Assert.fail(e.toString());		
		}
	}
	
	@Test
	public void testNotLoadingFromZip() {
		al.add(new File(ZIPFILE_WITH_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			mcl.loadClass(NON_EXISTING_CLASSNAME);
		} catch (ClassNotFoundException e) {
			Assert.assertTrue(true);	
		}
	}
	
	@Test
	public void testLoadingFromZipWithoutExtension() {
		al.add(new File(ZIPFILE_WITHOUT_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			Assert.assertNotNull(mcl.loadClass(EXISTING_CLASSNAME));
		} catch (ClassNotFoundException e) {
			Assert.fail(e.toString());		
		}
	}
	
	@Test
	public void testNotLoadingFromZipWithoutExtension() {
		al.add(new File(ZIPFILE_WITHOUT_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			mcl.loadClass(NON_EXISTING_CLASSNAME);
		} catch (ClassNotFoundException e) {
			Assert.assertTrue(true);	
		}
	}
	
	// --------- Tests lecture depuis Jar --------------
	@Test
	public void testLoadingFromJar() {
		al.add(new File(JARFILE_WITH_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			Assert.assertNotNull(mcl.loadClass(EXISTING_CLASSNAME));
		} catch (ClassNotFoundException e) {
			Assert.fail(e.toString());		
		}
	}
	
	@Test
	public void testNotLoadingFromJar() {
		al.add(new File(JARFILE_WITH_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			mcl.loadClass(NON_EXISTING_CLASSNAME);
		} catch (ClassNotFoundException e) {
			Assert.assertTrue(true);	
		}
	}
	
	@Test
	public void testLoadingFromJarWithoutExtension() {
		al.add(new File(JARFILE_WITHOUT_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			Assert.assertNotNull(mcl.loadClass(EXISTING_CLASSNAME));
		} catch (ClassNotFoundException e) {
			Assert.fail(e.toString());		
		}
	}
	
	@Test
	public void testNotLoadingFromJarWithoutExtension() {
		al.add(new File(JARFILE_WITHOUT_EXTENSION));
		MyClassLoader mcl = new MyClassLoader(al);
		try {
			mcl.loadClass(NON_EXISTING_CLASSNAME);
		} catch (ClassNotFoundException e) {
			Assert.assertTrue(true);	
		}
	}
	
}
