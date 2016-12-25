package com.restro.assignment.util;

public class Constants {
	
	public static final String QUERY = "select * from user where email LIKE ?";
	 public static final String INSIDESEARCH = "INSIDE_CONTROLLER";
	 public static final String RESTRO_URL = "/restro";
	 public static final String SUCESSSTATUS = "SUCESS";
	 
	 public static final String FAILSTATUS = "FAIL";
	 
	 public static final String FAILMESSAGE = "Sorry given amount dish not available,please enter another amount";
	 public static final String RECEIVED_AMOUNT = "/amount/{amount}";
	 public static final String AMOUNT = "amount";
	 public static final String INSIDE_SERVICE = "Inside_SERVICE";
	 public static final String ERROR_MESSAGE = "UserName should not be null and empty";
	 public static final String ERROR_LESSTHENTHREE = "Search Criteria should not be less then three char";
	 public static final int ERROR_CODE_ZERO = 0;
	 public static final String ERROR_CODE_ONE = "1";
	 public static final String ERROR = "error";
	 public static final String SUCCESS = "sucess";
	 public static final String SUCESSMESSAGE = "Total Time taken by Gordon Ramsey is";
	 
	 public static final String ERROR_VALIDUSER = "Please enter valid user";
	 public static final String ERROR_USERNOTPRESENT = "Username name is not present";
	 public static final String CACHE_URL = "http://10.252.63.180:8081/chat/userSearchCached";
	 public static final String ERROR_EMPTYRECORD = "Seach Record is not available";
	 public static final String LOGINSIDECACHEURL = "INSIDE getCacheUser METHOD";
	 public static final String APPLICATION_STARTED = "Application Started";
	 public static final String ERROR_SERVERMESSAGE ="Unfortunately, the application cannot process your request at this time";
	 public static final int ERROR_SERVER = 500;
	 public static final String LOG_INSIDEHANDLE= "inside handleValidationException()";
	 public static final String LOG_Invalid_PARAMATER = "Invalid request parameter. user is not valid";
	 public static final String LOG_EXITING_EXCEPTION = "Exiting handleValidationException";
	 public static final int ERROR_USERNOTEMPTY = 4002;
	 public static final int ERROR_VALIDATEERROR = 4001;
	 public static final int ERROR_LENGTH = 4002;
	 public static final int ERROR_RECORDEMPTY = 4002;
	 public static final String LOG_INSIDEVALIDATE = "--------Inside Validate Method-------;";
	 public static final String LOG_USERTPCPMTACTADATOR = "::::::: Returning Contact from  UserToContactAdaptor :::::::";
	 public static final String LOG_ENDUSERADAPTER = "::::::: END OF Returning Contact from  UserToContactAdaptor :::::::";
	 

}
