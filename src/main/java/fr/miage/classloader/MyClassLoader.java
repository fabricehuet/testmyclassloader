package fr.miage.classloader;

import java.io.File;
import java.security.SecureClassLoader;
import java.util.ArrayList;

public class MyClassLoader extends SecureClassLoader {
	private ArrayList<File> path = null;

	public MyClassLoader(ArrayList<File> p) {
		this.path = p;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = loadClassData(name);
		return super.defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name) throws ClassNotFoundException {
		// TODO A COMPLETER
		return null;
	}


}
