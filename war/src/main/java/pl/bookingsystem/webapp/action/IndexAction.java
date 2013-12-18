package pl.bookingsystem.webapp.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ResultPath(value="/")
@Result(name="success", location="/modules/login/pages/login.jsp")
public class IndexAction extends ActionSupport{
}