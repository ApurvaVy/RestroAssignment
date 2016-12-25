package com.restro.assignment.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.restro.assignment.model.RestroModel;
import com.restro.assignment.util.Constants;
import com.restro.assignment.util.DBException;

@Service
public class SearchServiceImpl implements SearchService {

	
	int amount = 0;
	int time = 0;

	public SearchServiceImpl() {
	}

	Logger log = Logger.getLogger(SearchServiceImpl.class);

	@Override
	public RestroModel receivedAmount(int amount) throws DBException, IOException {
		RestroModel restroModel = new RestroModel();
		if(amount>0){
			Map<Integer, Integer> restroMap = readFile();
			restroModel = getTime(amount, restroMap);
			if(restroModel.getStatus().equals(Constants.SUCESSSTATUS)){
			restroModel.setMessage(Constants.SUCESSMESSAGE);
			}
			// TODO Auto-generated method stub
			
		}else{
			restroModel.setStatus(Constants.FAILSTATUS);
			restroModel.setMessage(Constants.FAILMESSAGE);
		}
		return restroModel;
	}

	private Map<Integer, Integer> readFile() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

		// Creating ArrayList to hold Student objects
		Map<Integer, Integer> restroMap = new HashMap<Integer, Integer>();

		// Reading Student records one by one

		String currentLine = reader.readLine();

		while (currentLine != null) {
			String[] studentDetail = currentLine.split(" ");

			int amount = Integer.valueOf(studentDetail[0]);

			int time = Integer.valueOf(studentDetail[1]);

			restroMap.put(amount, time);

			currentLine = reader.readLine();
		}

		// TODO Auto-generated method stub
		return restroMap;

	}

	private RestroModel getTime(int rAmount, Map<Integer, Integer> amountMap) throws IOException {

		RestroModel restro = new RestroModel();
		if(amountMap.get(rAmount)!=null){
			int minute = amountMap.get(rAmount);
			int hours = (int) Math.floor(minute / 60);
			int minutes = minute % 60;
			String completeTime = String.valueOf(hours) + ":" + String.valueOf(minutes);
			restro.setAmount(rAmount);
			restro.setTime(completeTime);
			restro.setStatus(Constants.SUCESSSTATUS);
			
		}else{
			restro.setStatus(Constants.FAILSTATUS);
			restro.setMessage(Constants.FAILMESSAGE);
		}
		

		return restro;

	}

}
