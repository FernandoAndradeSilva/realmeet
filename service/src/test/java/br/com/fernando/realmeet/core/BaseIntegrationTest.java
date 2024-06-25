package br.com.fernando.realmeet.core;

import java.net.MalformedURLException;
import java.net.URL;
import br.com.fernando.realmeet.Application;
import br.com.fernando.realmeet.api.ApiClient;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = "integration-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class ,
        properties = "spring.flyway.clean-disabled=false")
public abstract class BaseIntegrationTest {

    @Autowired
    private Flyway flyway;

    @LocalServerPort
    private int serverPort;


    @BeforeEach
    void setUp() throws Exception {
        setupFlyway();
        setupEach();
    }

    protected void setupEach() throws Exception{

    }

    protected void setLocalHostBasePath(ApiClient apiClient, String path) throws MalformedURLException {
        apiClient.setBasePath(new URL("http" , "localhost", serverPort , path ).toString());
    }

    private void setupFlyway (){
        flyway.clean();
        flyway.migrate();
    }


}
