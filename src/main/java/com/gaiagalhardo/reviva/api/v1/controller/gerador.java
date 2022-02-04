package com.gaiagalhardo.reviva.api.v1.controller;

import java.util.UUID;

public class gerador {

	public static void main(String args[]) {
		String teste = UUID.randomUUID().toString();
		
		System.out.println("R"+teste.replaceAll("[^a-zA-Z]","").toUpperCase().substring(0, 4));
	}
	
}
