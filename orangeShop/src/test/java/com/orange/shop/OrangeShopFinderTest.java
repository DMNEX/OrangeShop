package com.orange.shop;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

import com.orange.shop.entities.Line;
import com.orange.shop.services.FileShopReader;
import com.orange.shop.services.implementation.OrangeShopFinderImpl;

public class OrangeShopFinderTest {

	@Test
	public void testAvailibilitySunusng() {
		FileShopReader fileShopReader = new FileShopReader();
		OrangeShopFinderImpl finderImpl = new OrangeShopFinderImpl();
		List<Line> listExistStock = finderImpl.existStock(fileShopReader.setAllLine(), "sunusng");
		assertEquals(205, listExistStock.size());
	}

	@Test
	public void testAvailibilityIpom() {
		FileShopReader fileShopReader = new FileShopReader();
		OrangeShopFinderImpl finderImpl = new OrangeShopFinderImpl();
		List<Line> listExistStock = finderImpl.existStock(fileShopReader.setAllLine(), "ipom");
		assertEquals(209, listExistStock.size());
	}

	@Test
	public void testAvailibilityWeiwei() {
		FileShopReader fileShopReader = new FileShopReader();
		OrangeShopFinderImpl finderImpl = new OrangeShopFinderImpl();
		List<Line> listExistStock = finderImpl.existStock(fileShopReader.setAllLine(), "weiwei");
		assertEquals(203, listExistStock.size());
	}

	@Test
	public void testCalculateDistance() {
		Line line = new Line(-3.16566, 48.56226, "[Orange] 22 Guingamp", 0, 0, 1);
		OrangeShopFinderImpl finderImpl = new OrangeShopFinderImpl();
		double distanceCalculated = finderImpl.distance(48.56226, line.getLatitude(), -3.16566, line.getLongitude());
		assertEquals(0.0, distanceCalculated, 0);
	}

	@Test
	public void testFindOrangeShopWithMobileAvailable() {
		OrangeShopFinderImpl finderImpl = new OrangeShopFinderImpl();

		String lineFound = finderImpl.findOrangeShopWithMobileAvailable(-0.96144, 45.93549, "ipom");

		assertEquals("[Orange] 17 Rochefort (53 Avenue Charles de Gaulle)", lineFound);
	}
}
