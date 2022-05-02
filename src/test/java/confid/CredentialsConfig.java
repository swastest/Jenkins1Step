package confid;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/config.properties") //путь к секретной папке
public interface CredentialsConfig extends Config { // обрати внимание как прописан метод!!!
    String login();
    String password();
    String url();


}
