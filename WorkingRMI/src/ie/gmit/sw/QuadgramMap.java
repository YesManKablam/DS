package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class QuadgramMap {

	private static Map<String, Integer> map = new HashMap<String, Integer>(); 
	
	public QuadgramMap(String filename) throws Exception {
		parse(filename);
	}
	
	public double getScore(String text){
		double score = 0.00f;
		
		for (int i = 0; i < text.length(); i+=4) {
			
			if (i + 4 > text.length()) break;
			
			String next = text.substring(i, i+4);
			
			if (map.get(next) != null){
				double frequency = (double)map.get(next);
				score += Math.log10(frequency);
			}
		}
		return score;
	}
	
	private void parse(String filename) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		
		int j;
		while((j = br.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z'){
				sb.append(next);
			}
			
			if(sb.length() == 4){
				String qGram = sb.toString().toUpperCase();
				sb = new StringBuffer();
				
				int frequency = 0;
				
				if(map.containsKey(qGram)){
					frequency = map.get(qGram);
				}
				
				frequency++;
				map.put(qGram, frequency);
				//System.out.println("done. Map Size: " + map.size() + " map entry: " + qGram);
			}
		}
		br.close();
		System.out.println(map);
	}
}
