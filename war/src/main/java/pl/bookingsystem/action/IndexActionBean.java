package pl.bookingsystem.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


@UrlBinding("/")
public class IndexActionBean extends BaseActionBean{

    @DefaultHandler
    public Resolution view()
    {
        return new ForwardResolution(ListClientsActionBean.class);
    }
}
