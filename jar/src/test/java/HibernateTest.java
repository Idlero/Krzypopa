import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bookingsystem.db.dao.ClientDAO;
import pl.bookingsystem.db.dao.impl.ClientDAOImpl;
import pl.bookingsystem.db.entity.Client;


public class HibernateTest {

    private ClientDAO clientManager;
    private Client client;

    @Before
    public void init() {
        clientManager = new ClientDAOImpl();
        client = new Client("Zenon", "Breszka", "zbreszka@dupa.pl", "dupablada1");
    }

    @Test
    public void shouldAddNewClientToDatabase() {

        //given

        //when
        clientManager.save(client);

        //then
        Client expected = clientManager.selectByID(Client.class, client.getId());
        Assert.assertEquals(expected.getId(), client.getId());
        Assert.assertEquals(expected.getPesel(), client.getPesel());
    }

    @Test
    public void shouldReturnClientWithIdEqualsOneFromDatabase() {
        //given

        //when
         Client expected = clientManager.selectByID(Client.class, 1);

        //then
        // Assert.assertEquals(expected.getId(), 1);

    }

    @After
    public void cleanUp() {
        clientManager.delete(client);
        client = null;
    }

}
