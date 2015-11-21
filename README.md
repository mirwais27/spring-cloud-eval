# spring-cloud-evaluation

This is a repository for evaluating spring cloud components like eureka-server, config-server, using feign and client-side load-balancing.
All components are build with spring boot 1.3 and spring cloud Brixton.M3. There right now the following maven modules:

- eureka-sever: Starts a simple eureka server
- config-server: Start a simple config-server without git. It reads only a database.yml file and propgates the properties for other services via AutoConfiguration annotations.
- fancy-server: A simple server which provides a rest controller for adding and fetching bookmarks of users.
- fancy-scif: Provides a inerfaces and pojo classes to access the rest endpoints of the fancy-server 
- fancy-client: A simple client which uses the fancy-server endpoints via feign (and automatically client-side load-balacing).
