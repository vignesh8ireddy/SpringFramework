## Spring Core

* Container is a special software program that manages the whole life cycle of the given component/bean (A reusable java class).

> The following are the life cycle operations done by a container on a bean
> 1. Loading the class
> 2. Creating the object
> 3. Managing the object
> 4. Raising other specific life cycle events and life cycle methods of the object
> 5. Destroying the object

* The famous containers in advanced Java are Catalina(Servlet container) and Jasper(JSP container)
* Container runs on top of the JVM
* The container of spring framework is called IOC Container i.e Inversion of Control container (The 
name explains the control take over of container from programmer over the spring components/beans).

> The two famous IOC containers of spring framework are:
> 1. BeanFactory Container (It is Basic IOC container)
> 2. ApplicationContext Container (It is Advanced IOC container)
    ApplicationContext container is built on top of BeanFactory container

* A Spring Bean can be pre-defined class, user-defined class, or third party supplied java class.
* Obviously an abstract class and an interface cannot be a Spring Bean 

* We can also use private constructors in spring bean java class because the IOC container can access private constructor while creating objects for the spring beans
* Can we make a private java class as a spring bean? - No, and moreover senseless

> Two major functions of IOC Container are:
> 1. Spring Bean Life Cycle Management
> 2. Dependency Management among the Spring Beans
>    * Dependency Lookup
>    * Dependency Injection (Bean Wiring): Injecting dependant Spring Bean Object to target Spring Bean Object.

* Creating Spring beans in spring framework:
  1. XML approach (can create both user-defined and pre-defined spring beans)
  2. XML (for pre-defined beans) + Java Annotations (for user-defined beans) approach
  3. Java Annotations (for creating both user-defined and pre-defined spring beans)
  * For creating user-defined spring beans using java annotations use @Component("bean_id").
  * For creating pre-defined classes as spring beans using java annotations use @Configuation, @ComponentScan(basePackages="parent_directory") and @Bean(name="bean_id")
  * Use @Autowired in user-defined spring bean for injecting any spring bean(user-defined/pre-defined) into it.

* To create a SpringFramework application, create a maven application and include spring-context-support dependency in the pom.xml file
   which gets other dependencies (spring-context,spring core, spring beans, spring aop, spring jcl, spring expression)
  <br> 
  Or you can include all the above 7 jar files in a normal java application to make it as a spring framework application

* Creating IOC container in spring framework:
```java
AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigClass.class);
/*
The above piece of code creates IOC container(applicationContext)
After, control goes to @Configuration class, scans for @Component classes in entire package and its sub packages of 
    basePackage mentioned in @ComponentScan() and creates objects for the component classes
Then, creates objects for the classes returned by @Bean methods in the configuration class
As all spring beans are ready and available now (as key-value pairs, in cache maintained by IOC container), IOC container performs dependency injection whenever necessary.
 */
ComponentClass bean = applicationContext.getBean("bean_id",ComponentClass.class);
//The above line return ComponentClass object with all the necessary dependency injections performed.
```

> 1. @Component class: makes the java class as a spring bean
> 2. @Bean method: makes the object return by the method as a spring bean
> 3. @Configuration class: makes the java class as a configuration class and also a spring bean
> 4. @ComponentScan: makes the IOC container to find for @Component and other stereo annotations typed classes to make them as spring beans
> 5. @Autowired: makes the IOC container to perform dependency injection of spring beans based upon HAS-A property
> 6. @Qualifier: used with @Autowired when multiple components qualify for injection, autowiring happens based upon the id given in @Qualifier annotation.
> <br> If @Qualifier is not used then IOC container throws NoUniqueBeanDefinitionException
> <br> @Qualifier is field level and parameter level annotation
> 7. @Primary: used with @Component/@Bean making the component high priority for injection just in case of other some components also qualified
> <br> Instead of using @Qualifier, @Primary, use can also match the bean_id of the dependant component with the bean_id of target component to make it primary
> <br> @Primary is class level and method level annotation

* Default bean id for the beans created using @Component is class name with first letter as lowercase.
* Default bean id for the beans created using @Bean in Configuration class is method name with first letter as lowercase.

* Different ways of Dependency Injection
  1. Field Injection (Best, without any constraints)
  2. Constructor Injection (Fast, because happens while creating object itself)
  <br>
  Note: At a time, @Autowired can be placed on only one parameterised constructor.
  <br>
  3. Setter Injection (IOC container calls it, you don't have worry, but need write multiple setter methods for multiple injections)
  4. Arbitrary Method Injection (it is similar to setter injection but can have custom name,and likewise IOC container calls it with the dependant bean object)

* Scope of a Spring Bean
    * singleton (bydefault), prototype, request, session, application & websocket 
    * singleton and prototype scopes can be used in both standalone and web applications.
    * Obviously, request, session, application and websocket scopes can be used in only web applications.
    > @Scope annotation is used to specify scope of a bean.
    > It is class level annotation (used with @Component) and method level annotation (used with @Bean)
    * singleton scope does not make the spring bean class as singleton java class, it makes the 
        IOC container to create single object for the spring bean with respect to the bean id 
        (just mimicking sigleton design pattern style not actually implementing it)
    * If a real singleton java class is made as a spring bean then if we configure the same class with multiple
        spring bean ids by enabling constructor based creation then the singleton design pattern can be broken, if we
        enable factory method based instantiation then the singleton design pattern cannot be broken.
    * singleton scope of the spring bean will be continued only when factory method based spring bean instantiation is enabled.
    * singleton scope is recommended when object of a spring bean class doesn't have any state or data i.e no properties, or fixed state or data i.e
        final declared properties.
    * prototype scope is recommended when state of the spring bean object changes time to time, so that for every state/data change one new object would be created
        for the spring bean.
    * Unlike singleton scope, the IOC container creates separate object for every applicationContext.getBean() method.
    * Spring beans of prototype scope are not placed in the internal cache of IOC container rather created on the spot whenever needed.
    * If we make the IOC container to create a real singleton java class bean by accessing private constructor then the prototype scope will be continued i.e
       IOC container creates multiple objects for real singleton java class for multiple getBean() method calls.
    * Spring bean objects of request scope are created for every new request where bean id would be used as request attribute 
       name and spring bean class object would be used as request attribute value.
    * Spring bean objects of session scope are created for every new session of user/browser/client
    * Eager-instantiation or Pre-instantiation of a spring bean: Creating object for a spring bean while start-up of the IOC container itself.
    * Lazy-instantiation or Lazy loading of a spring bean: Creating object for a spring bean while running of the IOC container.
    * Only singleton scope spring beans supports eager-instantiation and beans of other scopes won't this because, once the objects of singleton scope beans have created
         they are not created again or not wasted, they are placed in the internal cache and reused every time.
    * @Lazy(true) along with @Component disables the eager-instantiation of the singleton scope beans

* Stereotype annotations in Spring framework
  * @Component, @Service, @Repository, @Controller, @Configuration
  * These annotations make java classes as spring beans (components) and also some special classes specific to those annotations

* Working with .properties file
  * @PropertySource(value="path_of_properties_file") used along with @Component
    * the address present value is searched inside src/main/resources directory
  * @Value("${key}"/$"os.name"/"$Path") : field level annotation to inject values into variable like @Autowired
  * Environment is spring bean class whose object get info from the configured properties file, system properties
     and this Environment object can be injected to other spring beans using @Autowired, can be created using applicationContext.getEnvironment();
  * getProperty() of Environment class
  * @ImportResource("path_of_applicationContext.xml") used with @Configuration
    * the path_of_applicationContext.xml is searched inside src/main/resources directory
  
* Dependency Lookup

* The Spring Bean Life Cycle
  * @PostConstruct configures a java method as spring bean init life cycle method
  * @PreDestroy configures a java method as spring bean destroy life cycle method
  * @PostConstruct and @PreDestroy are given by javax.annotation.api (jakarta.annotation.api)
  > 1. Bean class Loading
  > 2. Instantiation
  > 3. Dependency Injections
  > 4. PostConstruct
  > 5. Business methods
  > 6. PreDestroy
  > 7. DeInstantiation (Garbage Collection)
  > 8. Bean class Unloading