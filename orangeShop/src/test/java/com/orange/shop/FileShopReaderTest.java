package com.orange.shop;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.orange.shop.entities.Line;
import com.orange.shop.services.FileShopReader;


public class FileShopReaderTest {

	@Test
	public void testName() throws Exception {
		
		FileShopReader fileReader = new FileShopReader();
		List<Line> setAllLine = fileReader.setAllLine();

		assertEquals(setAllLine.size(), 226);
		assertEquals(String.valueOf(setAllLine.get(0).getLongitude()),  "-1.51815");
		assertEquals(String.valueOf(setAllLine.get(0).getLatitude()),  "43.49507");
		assertEquals(setAllLine.get(0).getShopDescription(), "[Orange] 64 Anglet (Avenue Belle Marion)");
		assertEquals(setAllLine.get(0).getSunusng(),5);
		assertEquals(setAllLine.get(0).getIpom(), 7);
		assertEquals(setAllLine.get(0).getWeiwei(), 10);

	}
}
