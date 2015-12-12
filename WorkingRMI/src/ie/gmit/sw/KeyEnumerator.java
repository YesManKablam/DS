package ie.gmit.sw;

public class KeyEnumerator {
	
	private QuadgramMap map = null;
	private double bestScore;
	private String bestKey;
	
	public KeyEnumerator() throws Exception {
		map = new QuadgramMap("./wap.txt");
	}
	
	private char[] getNextKey(char[] key){
		for (int i = key.length - 1; i >=0; i--){
			if (key[i] =='Z'){
				if (i == 0) return null;
				key[i] = 'A';
			}else{
				key[i]++;
				break;
			}
		}
		return key;
	}

	
	public String crackCypher(String cypherText, int maxKeyLength){
		char[] key = null;
		
		int counter = 0;
		for (int j = 3; j <= maxKeyLength; j++){
			key = new char[j];
			for (int k = 0; k < key.length; k++) key[k] = 'A';
			
			do{
				counter++;
				//System.out.println("key:" + new String(key));
				String result = new Vigenere(new String(key)).doCypher(cypherText, false);
				//System.out.println("result: " + result);
				double score = map.getScore(result);
				if(score > bestScore){
					bestKey = new String(key);
					bestScore = score;
					System.out.println(bestKey);
				}
								
			}while ((key = getNextKey(key)) != null);
		}
		System.out.println("Enumerated " + counter + " keys.");
		String yahoo = new Vigenere(bestKey).doCypher(cypherText, false);
		
		System.out.println(yahoo);
		System.out.println(bestKey);
		
		return yahoo;
	}
	
	public static void main(String[] args) throws Exception {
		new KeyEnumerator().crackCypher("QACAWJHVHPQACAWJHJWIQEAURTINCNKEMBJULTICPRZAAQACAWJHVNXPGVJJBTRAATARANORJMIQENCGNEILXTEIIVPAXLDBETOJAETEHQACA", 5);
	}
}