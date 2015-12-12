/*package ie.gmit.sw;

import java.rmi.Naming;

public class TestClient {
	
	
	public static void main(String[] args) throws Exception {
		String out;
		// Looks up registry for VigenereService. Returns object with parameters
		VigenereService vs = (VigenereService) Naming.lookup("rmi://localhost:1099/cypher-service");
		
		// Instantiates VigenereBreaker 
		VigenereBreaker vb = vs.getVigenere();
		
		out = vb.getDecryption(vb);
		//System.out.println(out);
	}
}*/
