package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import comcast.MemeSorterAndScorerImpel;

public class MemeSortAndAcoreImpelTest {
	
	MemeSorterAndScorerImpel mSort= new MemeSorterAndScorerImpel();
	String filename ="JSonFile/meme.json";
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void readJSONfile()
	{
		
		Map<String, String> memesMap=null;
		try {
			memesMap = mSort.readMemeFromJSonFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(memesMap);
		
	}
	
	@Test
	public void validateFileSize() {
		Boolean size = mSort.checkFileSize(filename);	
		assertEquals(size, true);
	}
	
	@Test
	public void negvalidateFileSize() {
		Boolean size = mSort.checkFileSize(filename);	
		assertEquals(size, false);
	}
	
	

}
