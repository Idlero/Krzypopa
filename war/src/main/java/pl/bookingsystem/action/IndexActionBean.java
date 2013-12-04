package pl.bookingsystem.action;

import net.sourceforge.stripes.action.*;

@UrlBinding("/index.action")
public class IndexActionBean implements ActionBean {

    private ActionBeanContext context;

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    @DefaultHandler
    public Resolution getListMessages() {
        return new ForwardResolution(ListMessagesActionBean.class);
    }

}