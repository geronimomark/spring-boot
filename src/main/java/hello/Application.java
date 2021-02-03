package hello;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  @RequestMapping(value="/", produces={"application/json"})
  public String home() {
    Date d1 = new Date();
    SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YYYY");
    String formattedDate = df1.format(d1);

    Date d2 = new Date();
    SimpleDateFormat df2 = new SimpleDateFormat("HH:mm a");
    String formattedTime = df2.format(d2);

    TimeZone zone = TimeZone.getDefault();
    String tzString = zone.getDisplayName();
    
    return "{ server_date: '" + formattedDate + "', server_time: '" + formattedTime + "', time_zone: '" + tzString + "' }";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
