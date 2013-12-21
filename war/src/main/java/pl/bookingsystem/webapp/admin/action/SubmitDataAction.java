package pl.bookingsystem.webapp.admin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
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


    private String data;

    @Action(value = "reservation-add", results = {
            @Result(name = "success", type = "json"),
            @Result(name = "error", type = "json")
    })
    public String reservationAdd() {
        try {

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
}
