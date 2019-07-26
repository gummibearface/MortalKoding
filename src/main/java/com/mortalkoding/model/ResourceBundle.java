package com.mortalkoding.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.mortalkoding.enums.ResourceType;

public class ResourceBundle {

	Logger logger = Logger.getGlobal();
	Map<ResourceType, Integer> resourceAllocation = new HashMap<>();
	
	
	public void addResourceCount(ResourceType resourceType, Integer count)
	{
		Integer currentCount = resourceAllocation.getOrDefault(resourceType, 0);
		currentCount += count;
		resourceAllocation.put(resourceType, currentCount);
	}
	
	
	public void removeResourceCount(ResourceType resourceType, Integer count) throws Exception
	{
		Integer currentCount = resourceAllocation.getOrDefault(resourceType, 0);
		if (currentCount <= count)
		{
			logger.info("Not enough resources");
			throw new Exception("Not enough resources to remove this resource count");
		}
		currentCount -= count;
		resourceAllocation.put(resourceType, currentCount);
	}


	public int getTotalNumberOfResources() {
		//resourceAllocation.values().stream().mapToInt(Integer::intValue).sum();
		return resourceAllocation.values().stream().reduce(0, Integer::sum);
	}
}
