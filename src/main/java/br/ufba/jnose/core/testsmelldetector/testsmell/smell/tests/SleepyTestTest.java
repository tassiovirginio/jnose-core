package br.ufba.jnose.core.testsmelldetector.testsmell.smell.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import br.ufba.jnose.core.testsmelldetector.testsmell.SmellyElement;
import br.ufba.jnose.core.testsmelldetector.testsmell.smell.SleepyTest;

public class SleepyTestTest {

	public SleepyTest sleepyTest;
	FileInputStream fileInputStream;
	CompilationUnit compilationUnit;
	SmellyElement smellyElementList;
	
	@Before
	public void setUp() throws Exception {
		sleepyTest = new SleepyTest();
		fileInputStream = new FileInputStream(new File("src/main/java/br/ufba/jnose/core/testsmelldetector/testsmell/smell/tests/Aux.java"));
	}	
	
	@Test
	public void should_get_smells() {
		try{ 
			//System.out.print(System.getProperty("user.dir"));
			CompilationUnit compilationUnit = JavaParser.parse(fileInputStream);
			sleepyTest.runAnalysis(compilationUnit,new CompilationUnit(),"Aux","");
			ArrayList<SmellyElement> testes = sleepyTest.list();
			
			for(SmellyElement t: testes) {
				System.out.println(t.getHasSmell());
				System.out.println(t.getElementName());
				System.out.println(t.getRange());
				System.out.println("");
			}
			//assertFalse(emptytest.list().isEmpty());
			//assertTrue(testes.size() == 1);
			//assertEquals(testes.get(0).getElementName(),"should_be_sleep_test");
		}
		catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
