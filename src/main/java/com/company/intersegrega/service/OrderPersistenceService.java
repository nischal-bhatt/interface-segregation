package com.company.intersegrega.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.intersegrega.entity.Order;

public class OrderPersistenceService implements PersistenceService<Order>{

	private static final Map<Long,Order> ORDERS = new HashMap<>();
	
	@Override
	public void save(Order entity) {
		// TODO Auto-generated method stub
		synchronized(ORDERS) {
			ORDERS.put(entity.getId(), entity);
		}
		
	}

	@Override
	public void delete(Order entity) {
		synchronized(ORDERS) {
			ORDERS.remove(entity.getId());
		}
		
	}

	@Override
	public Order findById(Long id) {
		synchronized(ORDERS) {
			return ORDERS.get(id);
		}
	}

	
	// now the order persistence service is not forced to provide the findByName!

}
