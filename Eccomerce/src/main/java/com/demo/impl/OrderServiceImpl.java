package com.demo.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.OrderDao;
import com.demo.entity.Order;
import com.demo.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public @NotNull Iterable<Order> getAllOrders() {
		return this.orderDao.findAll();
	}

	@Override
	public Order create(@NotNull(message = "The order cannot be null.") @Valid Order order) {
		return this.orderDao.save(order);
	}

	@Override
	public void update(@NotNull(message = "The order cannot be null.") @Valid Order order) {
		this.orderDao.save(order);
		
	}

}