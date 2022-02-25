package com.orange.shop.services.implementation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.orange.shop.entities.Line;
import com.orange.shop.services.FileShopReader;
import com.orange.shop.services.OrangeShopFinder;

public class OrangeShopFinderImpl implements OrangeShopFinder{

	FileShopReader fileShopReader;
	
	@Override
	public String findOrangeShopWithMobileAvailable(double longitude, double latitude, String nameMobile) {
		String shopFound;
		fileShopReader = new FileShopReader();
		List<Line> listShop = fileShopReader.setAllLine();
		List<Line> listExistStock = existStock(listShop, nameMobile);
		listExistStock.forEach(line -> line
				.setCalculatedDistance(distance(latitude, line.getLatitude(), longitude, line.getLongitude()))

		);

		shopFound = listExistStock.stream().sorted(Comparator.comparing(Line::getCalculatedDistance))
				.collect(Collectors.toList()).get(0).getShopDescription();
		return shopFound;
	}

	@Override
	public double distance(double lat1, double lat2, double lon1, double lon2) {
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers. Use 3956
		// for miles
		double r = 6371;

		// calculate the result
		return (c * r);
	}

	@Override
	public List<Line> existStock(List<Line> listShop, String nameMobile) {
		List<Line> existStock = listShop.stream().filter(line -> {
			if (nameMobile.equals("sunusng")) {
				return line.getSunusng() > 0;
			} else if (nameMobile.equals("ipom")) {
				return line.getIpom() > 0;
			} else if (nameMobile.equals("weiwei")) {
				return line.getWeiwei() > 0;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
		return existStock;
	}

	
}
