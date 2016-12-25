package com.restro.assignment.service;

import java.io.IOException;

import com.restro.assignment.model.RestroModel;
import com.restro.assignment.util.DBException;

public interface SearchService {

  public RestroModel receivedAmount(int amount) throws DBException, IOException;
  
  

  
 

}
