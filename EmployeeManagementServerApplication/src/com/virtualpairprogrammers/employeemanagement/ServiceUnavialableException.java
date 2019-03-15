package com.virtualpairprogrammers.employeemanagement;

import javax.ejb.ApplicationException;

//Here we are forcing the transaction to be rolled back 
//by setting property on the ServiceUnavialableException directly
//but we should make sure we should always need to rollback when 
//this exception occurs as this will not give customize which transactions
//needs to be rolled back and which are not.
@ApplicationException(rollback=true)
public class ServiceUnavialableException extends Exception {

}
