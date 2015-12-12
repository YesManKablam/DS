package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TestRunner {
	
	/*public static void main(String[] args) throws Exception {
		
		System.out.println("starting remote service");
		
		LocateRegistry.createRegistry(1098);
		//Check out-queue for finished job
		VigenereBreaker vb = new VigenereBreakerImpl(2, 5, "QEGLDMAMKCNSNMNXLYFGREIDXEEXOBNTJCWJTRIIQYJUPPADN");
		
		VigenereService vs = new VigenereServiceImpl(vb);
		
		String inMessage;
		
		MessageClient a = new MessageClient();	
		
		Naming.bind("cypher-service", vs);
		
		System.out.println("service started...");
		System.out.println(a.getMsg());
	}*/
	
	public static void main(String[] args) throws Exception{
		System.out.println("starting remote service");
		
		LocateRegistry.createRegistry(1099);
		
		Naming.bind("cypher-service", new VigenereBreakerImpl());
		
		System.out.println("service started...");
	}

}
