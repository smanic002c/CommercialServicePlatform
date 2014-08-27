package com.sources.main;

import java.util.StringTokenizer;

public class StringTokenizerApp {

	public static void main(String[] args) {
		final String val = "Dhanasekar, Maheswari (Cognizant) <Maheswari.Dhanasekar@cognizant.com>; Donepudi, VijayaPoornima (Cognizant) <VijayaPoornima.Donepudi@cognizant.com>; G, Farhana (Cognizant) <Farhana.G@cognizant.com>; GABBIREDDY, VINODH REDDY (Cognizant) <VINODH.GABBIREDDY@cognizant.com>; K, Balamurugan (Cognizant) <Balamurugan-4.K-4@cognizant.com>; KALIRAJAN, URMILA K (Cognizant) <URMILAK.KALIRAJAN@cognizant.com>; MARAPPAN, ASHOK (Cognizant) <ASHOK.MARAPPAN@cognizant.com>; Mathur, Rishi (Cognizant) <Rishi.Mathur@cognizant.com>; Nathan M, Senthil (Cognizant) <Senthil.NathanM@cognizant.com>; R, Senthil Kumaran (Cognizant) <SenthilKumaran.R@cognizant.com>; R, Vijaya Chandran (Cognizant) <VijayaChandran.R@cognizant.com>; Selvaraj, Praveenraj (Cognizant) <Praveenraj.Selvaraj@cognizant.com>; SELWYN PRINCE, STEFFI GRACE (Cognizant) <STEFFIGRACE.SELWYNPRINCE@cognizant.com>; Sengole Raj, Sandhiya (Cognizant) <Sandhiya.SengoleRaj@cognizant.com>; SP, Senthil Nathan (Cognizant) <SenthilNathan.SP@cognizant.com>";
		StringTokenizer st = new StringTokenizer(val, ";");
		while(st.hasMoreElements()){
			System.out.println(st.nextElement()+"\n");
		}
	}

}
