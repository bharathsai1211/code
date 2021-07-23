package com.stackroute.watchlistservice.watchList.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.watchlistservice.watchList.model.WatchList;
import com.stackroute.watchlistservice.watchList.repository.WatchListRepository;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class WatchListServiceImpl implements WatchListService {


	private WatchListRepository watchListRepository;
	/**
	 * Autowired is used in dependency injection
	 */
	@Autowired
	public WatchListServiceImpl(WatchListRepository watchListRepository) {
		this.watchListRepository = watchListRepository;
	}

	/**
	 * The method is define a interface(watchListService)
	 *
	 */
	@Override
	public WatchList createWatchList(String userName, String city, int totalInfections, int totalDeaths) {
		List<WatchList> list = getAllWatchList();

		if (list != null) {

			for (WatchList uf : list) {
				if (userName.equals(uf.getUserName())) {
					List<Map> addto = uf.getWatchListArray();

					Map items = new HashMap();
					items.put("city", city);
					items.put("totalInfections", totalInfections);
					items.put("totalDeaths", totalDeaths);
					addto.add(items);
					uf.setWatchListArray(addto);
					watchListRepository.save(uf);

					return uf;
				}

			}
		}
		WatchList watch = new WatchList();
		watch.setCreatedAt(LocalDateTime.now());
		watch.setUserName(userName);

		Map items = new HashMap();
		items.put("city", city);
		items.put("totalInfections", totalInfections);
		items.put("totalDeaths", totalDeaths);
		List<Map> addto = new ArrayList<Map>();
		addto.add(items);
		watch.setWatchListArray(addto);
		watchListRepository.save(watch);

		return watch;
	}
	/**
	 * The method is define a interface(WatchListService)
	 *
	 */
	@Override
	public Map deleteWatchList(String userName, String place) {

		List<WatchList> list = getAllWatchList();
		if (list == null) {
			Map errorMessage = new HashMap();
			errorMessage.put("Message", "There is nothing to delete");
			return errorMessage;

		}
		for (WatchList uf : list) {
			if (userName.equals(uf.getUserName())) {
				List<Map> items = uf.getWatchListArray();

				for (Map item : items) {
					if (item.get("city").equals(place)) {
						Map deletedItem = new HashMap();
						deletedItem.put("city", item.get("city"));
						deletedItem.put("totalInfections", item.get("totalInfections"));
						deletedItem.put("totalDeaths", item.get("totalDeaths"));
						items.remove(item);
						uf.setWatchListArray(items);;
						watchListRepository.save(uf);
						return deletedItem;
					}
				}
			}

		}

		return (Map) new HashMap().put("ErrorMessage", "NO city exist with that Name");
	}

	@Override
	public List<WatchList> getAllWatchList() {
		return watchListRepository.findAll();
	}

	@Override
	public List<Map> getWatchListBasedOnUserName(String userName) {
		// TODO Auto-generated method stub

		List<WatchList> list = watchListRepository.findAll();
		for (WatchList watchList1 : list) {
			if (userName.equals(watchList1.getUserName())) {

				List<Map> watchList = watchList1.getWatchListArray();

				return  watchList;

			}

		}

		return null;
	}


}
