package com.formation.stock.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.aspectj.apache.bcel.classfile.Field;

import com.formation.stock.entities.Produit;

public class Test {
	 
	public synchronized void m() {
		System.out.println("hello");
	}

	public static synchronized void m2() {
		System.out.println("hello");
	}

	public static void main(String[] args) {
		try {
			PrintWriter writer = new PrintWriter(new File("test.txt"));
			DriverManager.getConnection("");
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File f = new File("c://");
		Test t = new Test();
		System.out.println("*******");
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("***t1****");
				t.m();
				t.m2();
			}
		});

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("***t2****");
				t.m();
				t.m2();
			}
		});

		thread.start();
		thread1.start();
	}

}
