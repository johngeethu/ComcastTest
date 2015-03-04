package comcast;
import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;



public class MemeSorterAndScorerImpel {
	
public static void main(String[] args)  {
		
		String filename ="JSonFile/meme.json";
		MemeSorterAndScorerImpel mSort= new MemeSorterAndScorerImpel();
		Map<String, String> memeMap = null;
		try {
			memeMap = mSort.readMemeFromJSonFile(filename);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
			
			Map<String, Integer> lulzScoreMap = mSort.generateLulzScoreMap(memeMap);

			mSort.EnteringLulzScore(memeMap, lulzScoreMap, filename);

		
	}


	
	public Map<String, String> readMemeFromJSonFile(String fileName)throws IOException {
		System.out.print("File Name = " + fileName);

		ObjectMapper mapper = new ObjectMapper();
		Meme meme = null;
		try {
			meme = mapper.readValue(new File(fileName), Meme.class);
		} catch (IOException e) {
		}
		
		Map<String, String> memesMap = meme.getMemesMap();
		return memesMap;
	}
	
	private int getLulzScore(String name, String val) {

		int lulZScore = 0;
		Random rn =  new Random();
		lulZScore = rn.nextInt(10) + 1;;

		return lulZScore;
	}
	
	
	private Map<String, Integer> generateLulzScoreMap(Map<String, String> memeMap)
	{
		Map<String, Integer> lulzScoreMap = new HashMap<String, Integer>();
		Set<String> memeNames = memeMap.keySet();
		
		for (String memeName : memeNames) {
			int lulzScore = getLulzScore(memeName, memeMap.get(memeName));
			lulzScoreMap.put(memeName, lulzScore);
			
		}
		return lulzScoreMap;
	}

	/*
	 * Sorting the hashmap using the list
	 */
	private void sortList(Map<String, String> memeMap) {

		List<String> sortedKeys = new ArrayList<String>(memeMap.size());
		sortedKeys.addAll(memeMap.keySet());
		Collections.sort(sortedKeys);
}
	public boolean checkFileSize(String filePath) {
		File file =new File(filePath);
		 
		if(file.exists()){
			if ( file.length()>0){ 
				return true;
			}	else{
					return false;
				}
			}
		return false;
			
	}

	
	private void EnteringLulzScore(Map<String, String> memeMap,
		Map<String, Integer> lulzMap, String fileName) {

		MemeLulz memelulz = new MemeLulz();
		ObjectMapper mapper = new ObjectMapper();
		try {
			memelulz.setMemesMap(memeMap);
			memelulz.setLulMap(lulzMap);
			mapper.writeValue(new File(fileName), memelulz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	

}


