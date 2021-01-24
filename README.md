# ca-employee


-[x] authorization
-[x] data access
-[x] validation
-[x] Business logic: 
  * show only JAN-month data
  * show only FEB-month data

Default Fetch type in case of the below annotations.

@OneToOne – Default fetch type is EAGER
@ManyToOne – Default fetch type is EAGER.
@OneToMany – Default fetch type is LAZY.
@ManyToMany – Default fetch type is LAZY.
@ElementCollection – Default fetch type is EAGER.

FetchType.LAZY = Doesn’t load the relationships unless explicitly “asked for” via getter
FetchType.EAGER = Loads ALL relationships

The way I like to put it is like this:

EAGER: Convenient, but slow
LAZY: More coding, but much more efficient

https://howtoprogramwithjava.com/hibernate-eager-vs-lazy-fetch-type/



https://www.javacodemonk.com/n-1-problem-in-hibernate-spring-data-jpa-894097b9


#Application Start
> mvn spring-boot:run

# one interface implements multi -impl.
-[x] @Primay
-[x] @Qualifier


@Service
@Primary
class MyServiceB implements MyServiceInterface {}

Benefices of manifest file and var file

    reference: https://docs.cloudfoundry.org/devguide/deploy-apps/manifest-attributes.html

In addition, using variables enables you to store sensitive data in a separate file that the app manifest would reference, making the security sensitive data easier to manage and keep secure.

disk_quota

    Use the disk_quota attribute to allocate the disk space for your app instance. This attribute requires a unit of measurement: M, MB, G, or GB, in upper case or lower case.

Application Referene
    
     https://slf4me.com/post/spring-boot/mybatis-h2-problem/
     https://stackoverflow.com/questions/35317118/repository-tag-under-distributionmanagement-vs-repositories
     https://theburningmonk.com/2015/05/a-consistent-approach-to-track-correlation-ids-through-microservices/
     https://medium.com/@walkingtreetech/logs-monitoring-in-microservices-using-elk-316bf9c049c4
     https://www.researchgate.net/figure/Microservice-architecture-of-body-weight-management-system_fig5_317423158
     
Logging:
        
        https://reflectoring.io/tracing-with-spring-cloud-sleuth/
        https://www.javatpoint.com/introduction-to-distributed-tracing
             
Maven
    
    mvn clean install -P quality-checks
         
    git commit --amend --author="chandrakumar <osaimar19@gmail.com>"
    git rebase --continue

    git filter-branch -f --env-filter "GIT_AUTHOR_NAME='chandrakumar'; GIT_AUTHOR_EMAIL='osaimar19@gmail.com'; GIT_COMMITTER_NAME='covanan'; GIT_COMMITTER_EMAIL='demo.covanan@chandra.com';" HEAD;
    :wq
    
Error Message:
    
       {
        "error": "auth-0001",
        "message": "Incorrect username and password",
        "detail": "Ensure that the username and password included in the request are correct",
        "help": "https://example.com/help/error/auth-0001"
    	}    
    	
 OncePerRequestFilter
 
        https://stackoverflow.com/questions/25433258/what-is-the-x-request-id-http-header
        
 When you're operating a webservice that is accessed by clients, it might be difficult to correlate requests (that a client can see) with server logs (that the server can see).
 
 The idea of the X-Request-ID is that a client can create some random ID and pass it to the server. The server then include that ID in every log statement that it creates. If a client receives an error it can include the ID in a bug report, allowing the server operator to look up the corresponding log statements (without having to rely on timestamps, IPs, etc).
 
 As this ID is generated (randomly) by the client it does not contain any sensitive information, and should thus not violate the user's privacy. As a unique ID is created per request it does also not help with tracking users.
 
         X-Request-ID,
         X-Correlation-ID
         Correlates HTTP requests between a client and server.	
         X-Request-ID: f058ebd6-02f7-4d3f-942e-904344e8cde


https://jaxenter.com/spring-boot-tutorial-microservices-kubernetes-part-2-135518.html
https://cloud.spring.io/spring-cloud-kubernetes/spring-cloud-kubernetes-examples/kubernetes-circuitbreaker-ribbon-example/
https://help.skytap.com/template-cloud-foundry-v2.html
http://dummy.restapiexample.com/

1.status 404 reading

Applications with Services called something like AccountService, UserService, PaymentService are much easier to deal with than those with DatabaseService, ValidationService, CalculationService etc

    * YAGNI
    * DRY Code
    * KISS
    * SOLID
    * Tell, Don’t Ask


If you have not heard about SOLID, here is the quick break down:

        SRP: The Single Responsibility Principle(High Cohesion)
        OCP: The Open-Closed Principle
        LSP: The Liskov Substitution Principle('extends':: Parent/Child relationship)
        ISP: The Interface Segregation Principle('implements'::
        DIP: The Dependency Inversion Principle(

####Single Responsibility
Every module or class should have responsibility 
over a single part of the functionality
 Example -
 
        Login package should deal with the user login code,
        It should not deal with user signup

        
        Write code in a way so that your classes/methods are -
        Open for extension, but closed for modification
        
https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-developing-auto-configuration
https://www.e4developer.com/2018/07/14/discovering-clean-architecture-with-uncle-bob/ 

###Couping and Cohesion
    Couping is foucs on Complexitiy between a MODULE and other module 
    Example:  
        Params Calcualation
         
    Cohesion is foucs on Complexitiy WITH IN MODULE
    Example: 
        Cohesion is represent the clarity of responsibility WITH IN MODULE
###Couping: 
    * Loosely Couping(Use Interface)
    * Tightly Couping

###Cohesion: 
    * Low Cohesion
    * High Cohesion
###Advantage:
  * flexible
  * maintainable
  * re-usable 
          
In essence, 
* High cohesion means keeping parts of a code base that are related to each other in a single place. 
* Low coupling, at the same time, is about separating unrelated parts of the code base as much as possible
 
        'Extracting the class specific method'
 
######Recommendations:   'Loosely couping and High Cohesion'

   Example:
      
      | Low Cohesion                       | High Cohesion                                  |
      | -----------------------------------| ---------------------------------------------- |
      |   Class A {                        |    Class A{                                    |
      |      checkEmail();                 |      checkEmail(); }                           |
      |      validateEmail();              |   Class B {                                    |         
      |      sendEmail();                  |      validateEmail();  }                       |
      |      printLetter();                |   Class C {                                    |
      |      printAddress();               |        sendEmail(); }                          |
      |   }                                |  Class D {                                     | 
      |                                    |        printLetter(); }                        |
      |1.Low cohesion is when you have     |1.High cohesion is when you have                |
      |  a class that does not a well      |a class that does a well defined                |
      |  defined job                       |job                                             |


##Test this endpoints
    GET http://localhost:8080/v1/products