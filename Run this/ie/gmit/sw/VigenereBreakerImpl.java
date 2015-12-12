package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VigenereBreakerImpl extends UnicastRemoteObject implements VigenereBreaker{
	private static final long serialVersionUID = 1L;
	private KeyEnumerator breaker;
	private VigenereBreaker vb;
	private long jobNumber;
	private int maxKeyLength;
	private String cypherText;
	
	@SuppressWarnings("deprecation")
	public VigenereBreakerImpl() throws Exception {
		breaker = new KeyEnumerator();
		//UnicastRemoteObject.exportObject(this);
	}
		
	public VigenereBreakerImpl(long jobNum, int maxKeyLength, String cypherText) throws RemoteException {
		super();
		this.jobNumber = jobNum;
		this.maxKeyLength = maxKeyLength;
		this.cypherText = cypherText;
	}
		
	public String decrypt(String cypherText, int maxKeyLength) throws RemoteException {
		KeyEnumerator s = null;
		try {
			s = new KeyEnumerator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s.crackCypher(cypherText, maxKeyLength).toString();
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(vb.decrypt("QEGLDMAMKCNSNMNXLYFGREIDXEEXOBNTJCWJTRIIQYJUPPADN", 5));
		/*
		System.out.println("starting remote service");
		
		//LocateRegistry.createRegistry(1099);
		
		Naming.bind("cypher-service", new VigenereBreakerImpl());
		
		System.out.println("service started...");
		VigenereBreaker vb = new VigenereBreakerImpl();
		vb.decrypt("JNOISRBNBCJKURBQVNWCJARJWRBV", 5);*/
	}
	
	// Return decrypted text
	public String getDecryption(VigenereBreaker vb) throws RemoteException {
		this.vb = vb;
		System.out.println("CypherText: " + cypherText + " MaxKeyLength: " + maxKeyLength);
		return vb.decrypt(cypherText, maxKeyLength);
	}
	
}
