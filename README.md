# spring-boot-2-keycloak
Demo project for Spring Boot with Keycloak 11 and Kotlin

### Project Setup

- Run 'docker-compose up', to start Postgres and Keycloak in a docker container.
- Enter in 'http://localhost:8080/auth/' and click in 'Administration Console'.
- Enter with user name 'admin' and password '123456'. Does not set this password in production environment.

##### Create a new Realm instance:
- Name the Realm as 'company_master'.

##### Create a Realm Client:
- Name the Client as 'backend-api'.
- Set the Client Protocol as 'openid-connect'.
- Set the Access Type as 'confidential'.
- Set the Authorization Enabled to 'ON'.
- Set the Root URL to 'http://localhost:8090'.
- In Credentials Tab, copy the Secret id, and replace in application.properties in field 'keycloak.credentials.secret'.
- In the Roles Tab, create the roles: company and branch_office.

##### Create the Roles:
- Create the role named as 'company', and set the Composite Roles to 'ON'. In Client Roles, select the 'backend-api', and in Available Roles, select the 'company' to Add Selected.
- Create the role named as 'branch_office', and set the Composite Roles to 'ON'. In Client Roles, select the 'backend-api', and in Available Roles, select the 'branch_office' to Add Selected.

##### Create the Users:
- Create the user branch_office_1 and branch_office_2. In Credentials Tab, set the password to '123456' and set Temporary to 'OFF'. In Role Mappings Tab, in Available Roles, select the 'branch_office' to Add Selected.
- Create the user company_1. In Credentials Tab, set the password to '123456' and set Temporary to 'OFF'. In Role Mappings Tab, in Available Roles, select the 'company' to Add Selected.

##### Start the application
- Start with maven clean install.

##### Authenticate to Get the Access Token
- By Postman you can authenticate with a POST to: http://localhost:8080/auth/realms/company_master/protocol/openid-connect/token
- In the Body select the x-www-form-urlencoded format, and send this keys and values:

| KEY           | VALUE                                |
| ------------- | ------------------------------------ |
| username      | branch_office_1                      |
| password      | 123456                               |
| grant_type    | password                             |
| client_id     | backend-api                          |
| client_secret | 1b5c82ed-00b2-4f37-852a-cbf3990fb372 |

- The value of client_secret, you must see the Secret id of the Realm Client generated in your Keycloak.
- After authenticate, get the 'access_token' generated in the response of the above request.
- Now you can do a GET in 'http://localhost:8090/v1/product' passing in the Header the KEY(Authorization), and the VALUE(Bearer access_token).
