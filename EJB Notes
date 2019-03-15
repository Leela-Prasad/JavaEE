EJB Provides following features
1. Transactional support on the methods of ejb class
2. Database Integration 
3. Security
4. Method invocation through remoting

@Remote on the EJB Interface tells us that the service can be connected by external clients.
@Local on the EJB Interface tells us that the service is connected by other EJBs within our application. 

@Stateless tells to the server that the class is an EJB.

During an EJB invocation it can return an object that exist on the server, in order to transfer that object from server to client through network we need make that domain object as Serializable


JNDI(Java Naming and Directory Interface)
This will be used to lookup service side resources(like database connection, MQ, EJBS) through a alias name.

EJB will be automatically registered in JNDI
java:global/EmployeeManagementServerApplication/EmployeeManagementServiceImpl!com.virtualpairprogrammers.employeemanagement.EmployeeManagementService
java:app/EmployeeManagementServerApplication/EmployeeManagementServiceImpl!com.virtualpairprogrammers.employeemanagement.EmployeeManagementService
java:module/EmployeeManagementServiceImpl!com.virtualpairprogrammers.employeemanagement.EmployeeManagementService
java:jboss/exported/EmployeeManagementServerApplication/EmployeeManagementServiceImpl!com.virtualpairprogrammers.employeemanagement.EmployeeManagementService

java:global/EmployeeManagementServerApplication/EmployeeManagementServiceImpl
java:app/EmployeeManagementServerApplication/EmployeeManagementServiceImpl
java:module/EmployeeManagementServiceImpl


Here java:global, java:app, java:module friendly names are used for internal EJB Invocation means one EJB in the server can interact with another EJB using these names.

But java:jboss/exported friendly name should be used when we are invoking EJB from Outside of applicantion.



EJB Types:
Session Beans - since client will be connecting to the server(through a session) for performing certain operations this will be called as session beans.
Entity Beans - these beans are replaced by Entity Beans.


Until Java EE5 if you want to define an EJB then we have to define an interface stating that it will be local or remote
But from Java EE6 interface is optional ONLY FOR LOCAL EJBS.
if your local EJB has only one implementation then we can get rid of interface.


Session Beans:
1. Stateless 
 This bean will not have any client data to execute an operation. so the same object can be reused to another client to serve that operation again
So there will not be destroy method executed for stateless objects in normal conditions.
These beans are useful to scale up and scale down in busy and free conditions respectively.
Generally Application Server will create a pool of EJBs at the startup.


2. Stateful 
These beans will store state of the client so same object cannot be used for other object.

** In a stateful bean we should define a method with @Remove annotation so when that method execution completes Application Server will remove this EJB Instance from the server.

Disadvantage of Stateful beans are it cannot scale. In a busy system we need to create lot of Stateful beans to serve more clients.

** we can do this by creating a stateless beans which will store client state in a database. so when it need the state it can retrieve from database.




CDI (Context and Dependency Injection):
Upto Java EE5 if we want to inject an EJB we used
@EJB annotation but this have a problem that it can only inject EJB ONLY.

If you want to inject any java class it is not possible.
From Java EE6 a new annotation is used for both EJB and plain java class injection
@Inject

So it is better to use @Inject annotation even for EJB also as it has more capabilities.


Suppose in our application if we have more than one implementation then we can resolve dependency Injection in following ways.

1. Define @Default and @Alternative Annotations on the Implementation.
@Default will be picked up by default for injection.

If we want to inject Alternate Version then we need to define an xml file (beans.xml) in src/META-INF/beans.xml
and declare alternate bean definition.


2. Using Custom Annotations as Qualifiers
and use that Annotation along with @Inject annotation.

eg: 

This will take implementation with Default Annoation
@Inject
private EmployeeDataAccess dao;


This will take Testing Version Impl class
@Inject
@TestingDao
private EmployeeDataAccess dao;

This will take Production Version Impl class
@Inject
@ProductionDao
private EmployeeDataAccess dao;




Transactions:
*** Any Method defined in EJB will become transactional

*** When an EJB is calling another EJB then Application server will not start another transaction in EJB2 by default and it will reuse the transaction that is present in EJB1.


Transaction Types
1. Required
2. Supports
3. Requires New
4. Not Supported
5. Mandatory
6. Never


1. Required
If  there is a transaction from the caller then it will be reused else it will start a new transaction.
This is the default Transaction Type in EJBs.

2. Supports
This will never start a transaction, and it will execute in a  transaction or not depends on the caller, if the caller is having transaction then it will execute in transaction mode, else it will not be executed in transaction.
This is also one of the most used transaction types.

3. Requires New
In this it will start brand new transaction and the caller transaction is suspended until the method gets executed in the new transaction.
** Suspending a transaction is a costly operation so make sure if you are using this type of transaction.

4. Not Supported
In this it will suspend the caller transaction and gets executed in NON Transaction mode.
** Suspending a transaction is a costly operation so make sure if you are using this type of transaction.
Generally this use case is rare and we can check “Supports” type is fitting into our requirement.

5. Mandatory
In this it should be executed in a transaction started by the caller, if caller doesn’t have transaction then it will throw exception.

6. Never
In this it should not be executed in a transaction, if caller has transaction it will throw exception.


Rollbacks:
*** Transactions are automatically Rolled back for “UNCHECKED EXCEPTIONS”

*** Transactions are NOT rolled back for CHECKED EXCEPTIONS, because it is clear that the code can take a alternative approach and not do a roll back.

We can force a rollback by setting this property in the catch block
@Resource
private SessionContext wildfly;



//Here we are forcing the transaction to be rolled back 
//by setting property wildfly.setrollbackonly()
try {
   payrollService.enrollEmployee(employee);
}catch(ServiceUnavialableException e) {
   wildfly.setRollbackOnly();
  throw e;
}


(or)
we can define this property directly on the Exception itself, this will be useful when you are sure that we definetly needs to do a rollback when this type of Exception occurs.
but this approach will not give customize which transactions needs to be rolled back and which are not.


@ApplicationException(rollback=true)
public class ServiceUnavialableException extends Exception {

}
