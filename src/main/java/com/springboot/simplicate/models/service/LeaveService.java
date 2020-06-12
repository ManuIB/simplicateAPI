package com.springboot.simplicate.models.service;

import com.springboot.simplicate.models.Item;

public interface LeaveService {

	public Item findAllLeaveBalance();

	public Item findLeavePerEmployee(String employeeId);
}
