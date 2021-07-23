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

@Service
public class WatchListServiceImpl implements WatchListService {

	@Autowired
	private WatchListRepository watchListRepository;

	@Override
	public WatchList createWatchList(String userName, String place, int infections, int deaths) {
		List<WatchList> list = getAllWatchList();

		if (list != null) {

			for (WatchList uf : list) {
				if (userName.equals(uf.getUserName())) {
					List<Map> addto = uf.getWatchListArray();

					Map items = new HashMap();
					items.put("place", place);
					items.put("infections", infections);
					items.put("deaths", deaths);
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
		items.put("place", place);
		items.put("infections", infections);
		items.put("deaths", deaths);
		List<Map> addto = new ArrayList<Map>();
		addto.add(items);
		watch.setWatchListArray(addto);
		watchListRepository.save(watch);

		return watch;
	}

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
					if (item.get("place").equals(place)) {
						Map deletedItem = new HashMap();
						deletedItem.put("place", item.get("place"));
						deletedItem.put("infections", item.get("infections"));
						deletedItem.put("deaths", item.get("deaths"));
						items.remove(item);
						uf.setWatchListArray(items);
						;
						watchListRepository.save(uf);
						return deletedItem;
					}
				}
			}

		}

		return (Map) new HashMap().put("ErrorMessage", "NO company exist with that Name");
	}

	@Override
	public List<WatchList> getAllWatchList() {
		return watchListRepository.findAll();
	}

	@Override
	public List<WatchList> findByName(String userName) {
		List<WatchList> nameList = watchListRepository.findAll();
		List<Map> watchListMap;
		for (WatchList watchList : nameList) {
			if (watchList.getUserName().equals(userName)) {
				nameList.add(watchList);
			}
		}
		return nameList;
	}

}
