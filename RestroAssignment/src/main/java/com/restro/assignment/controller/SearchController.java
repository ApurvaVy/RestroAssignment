package com.restro.assignment.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restro.assignment.model.RestroModel;
import com.restro.assignment.service.SearchService;
import com.restro.assignment.util.Constants;
import com.restro.assignment.util.DBException;
import com.restro.assignment.util.WebServiceError;


@RestController
@RequestMapping(value = Constants.RESTRO_URL)
@CrossOrigin
public class SearchController {

	@Autowired 
	SearchService searchService;
	
	Logger log = Logger.getLogger(SearchController.class);
	
	public SearchController(){		 
	}
	
	public SearchController(SearchService searchService){
		this.searchService = searchService;
	}
	
	@RequestMapping(value = Constants.RECEIVED_AMOUNT, method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, Object> searchUser(@PathVariable(Constants.AMOUNT) int amount) throws IOException, IllegalStateException {
		log.info(Constants.INSIDESEARCH);
		RestroModel restoModel = searchService.receivedAmount(amount);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if(restoModel.getStatus().equals(Constants.FAILSTATUS)){
			response.put(Constants.FAILSTATUS,restoModel.getMessage());
			
		}else{
			response.put(restoModel.getMessage(),restoModel.getTime());	
		}
		
		
		return response;
	}
	
	@ExceptionHandler(DBException.class)
	@ResponseBody
	public ResponseEntity<WebServiceError> handleValidationException(DBException exception) {
		WebServiceError webServiceError = null;
		if(exception.getErrorCode() == WebServiceError.Type.VALIDATION_ERROR.getCode()){
			webServiceError = WebServiceError.build(WebServiceError.Type.VALIDATION_ERROR,
					exception.getErrorMessage());
		}else if(exception.getErrorCode() == WebServiceError.Type.INTERNAL_SERVER_ERROR.getCode()){
			webServiceError = WebServiceError.build(WebServiceError.Type.INTERNAL_SERVER_ERROR,
					exception.getErrorMessage());
		}else if(exception.getErrorCode() == WebServiceError.Type.BAD_REQUEST_ERROR.getCode()){
			webServiceError = WebServiceError.build(WebServiceError.Type.BAD_REQUEST_ERROR,
					exception.getErrorMessage());
		}else if(exception.getErrorCode() == WebServiceError.Type.SERVER_DOWN.getCode()){
			webServiceError = WebServiceError.build(WebServiceError.Type.SERVER_DOWN,
					exception.getErrorMessage());
		}
		log.error(Constants.LOG_INSIDEHANDLE);	
		log.error(Constants.LOG_Invalid_PARAMATER);
		
		
		log.info("Exiting handleValidationException");
		return new ResponseEntity<WebServiceError>(webServiceError, HttpStatus.BAD_REQUEST);
	}

	

}
