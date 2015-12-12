/*package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VigenereServiceImpl extends UnicastRemoteObject implements VigenereService{
	private static final long serialVersionUID = 1L;
	private VigenereBreaker vb;

	public VigenereServiceImpl(VigenereBreaker vb) throws RemoteException {
		super();
		this.vb = vb;
	}

	public VigenereBreaker getVigenere() throws RemoteException {
		return vb;
	}

}/*