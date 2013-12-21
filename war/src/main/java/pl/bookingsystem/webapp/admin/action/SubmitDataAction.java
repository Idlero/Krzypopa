package pl.bookingsystem.webapp.admin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.bookingsystem.db.entity.Client;

import java.io.InputStream;

/**
 * Author: thx-
 * Date: 20.12.13 @  19:54
 */
@ParentPackage("json-default")
@Namespace("")
public class SubmitDataAction extends ActionSupport {


    private InputStream message;

    public InputStream getMessage() {
        return message;
    }

    private Client client;
    private String data;

    @Action(value = "reservation-add", results = {
            @Result(name = "success", type = "json"),
            @Result(name = "error", type = "json")
    })
    public String reservationAdd() {
        try {

            JSONObject obj = new JSONObject();
            JSONParser parser = new JSONParser();

            try {
                String s = jasonConvert(data);
                Object object = parser.parse(s);
                JSONObject jsonObject = (JSONObject) object;
                String name = (String) jsonObject.get("first_name");

                System.out.println(name);
            } catch (ParseException pe) {
                System.out.println("position: " + pe.getPosition());
                System.out.println(pe);


            }


            System.out.println(data);

            // ClientDAO clientManager = new ClientDAOImpl();
            // clientManager.save(data);
            // message = new ByteArrayInputStream("Data has been saved".getBytes());
            return SUCCESS;

        } catch (Exception e) {

            //  message = new ByteArrayInputStream("Data hasn't been saved".getBytes());
            return ERROR;
        }

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String jasonConvert(String serialize) {
        String conv = "{\"" + serialize + "\"}";
        conv = conv.replaceAll("=", "\":\"");
        conv = conv.replaceAll("&", "\",\"");
        System.out.println(conv);
        return conv;
    }


}



