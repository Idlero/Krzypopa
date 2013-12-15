package pl.bookingsystem.webapp.login.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/modules/login")
@ResultPath(value="/")
@Result(name="success",location="pages/login.jsp")
public class IndexAction extends ActionSupport{
}