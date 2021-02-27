

JPA Cascade Types
The cascade types supported by the Java Persistence Architecture are as below:

-[x] CascadeType.PERSIST : cascade type presist means that save() or persist() operations cascade to related entities.
-[x] CascadeType.MERGE : cascade type merge means that related entities are merged when the owning entity is merged.
-[x] CascadeType.REFRESH : cascade type refresh does the same thing for the refresh() operation.
-[x] CascadeType.REMOVE : cascade type remove removes all related entities association with this setting when the owning entity is deleted.
-[x] CascadeType.DETACH : cascade type detach detaches all related entities if a “manual detach” occurs.
-[x] CascadeType.ALL : cascade type all is shorthand for all of the above cascade operations.

There is no default cascade type in JPA. By default no operations are cascaded.

### N+1 problem in Hibernate & Spring Data JPA
Example: 
        
        @Entity
        @Table(name = "t_users")
        public class User {
        
            @Id
            @GeneratedValue(strategy=GenerationType.AUTO)
            private Long id;
            private String name;
        
            @ManyToMany(fetch = FetchType.LAZY) //1                  
            private Set<Role> roles;
            //Getter and Setters removed for brevity
         }
        
        @Entity
        @Table(name = "t_roles")
        public class Role {
        
            @Id
            @GeneratedValue(strategy= GenerationType.AUTO)
            private Long id;
        
            private String name;
            //Getter and Setters removed for brevity
         }
      
      A user can have many roles. Roles are loaded Lazily.
    
    UserRepository with findAllBy method
    public interface UserRepository extends CrudRepository<User, Long> {
    
        List<User> findAllBy();
    }
    Equivalent SQL queries executed by ORM will be:
    
First Get All User (1)
    
    Select * from t_users;

Then get roles for each user executed N times (where N is number of users)
    
    Select * from t_user_roles where userid = <userid>;
    
So we need one select for User and N additional selects for fetching roles 
for each user, where N is total number of users. 
This is a classic N+1 problem in ORM

* Spring Data JPA Approach
If we are using Spring Data JPA, then we have two options to achieve this - using EntityGraph or using select query with fetch join.


        public interface UserRepository extends CrudRepository<User, Long> {
        
            List<User> findAllBy();             
        
            @Query("SELECT p FROM User p LEFT JOIN FETCH p.roles")  
            List<User> findWithoutNPlusOne();
        
            @EntityGraph(attributePaths = {"roles"})                
            List<User> findAll();
        }
        
N+1 queries are issued at database level
using left join fetch, we resolve the N+1 problem
using attributePaths, Spring Data JPA avoids N+1 problem

   
   * https://codete.com/blog/jpa-n-plus-1-select-problem/
   * https://www.javacodemonk.com/n-1-problem-in-hibernate-spring-data-jpa-894097b9

Refer:
https://notes.kartashov.com/2016/06/16/getting-started-with-spring-data-envers/
https://sunitc.dev/2020/01/21/spring-boot-how-to-add-jpa-hibernate-envers-auditing/
#### Hibernate envers
Error: hbm.xml JAXBContext

### THE BEST
  * https://www.javadevjournal.com/spring-boot/spring-boot-with-hibernate/
  