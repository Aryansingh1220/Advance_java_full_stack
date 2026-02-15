package assignmentCaseStudy1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import weeklyCaseStudy1.Payment;
import weeklyCaseStudy1.Profile;
import weeklyCaseStudy1.PurchaseOrder;
import weeklyCaseStudy1.ServiceDao;
import weeklyCaseStudy1.User;

public class AssignmentCase1Test {

    private ServiceDao service = new ServiceDao();

    @Test
    public void testOneToOne() {

        Profile p = new Profile();
        p.setId(1L);
        p.setPhone("9876543321");
        p.setAddress("Punjab");

        User u = new User();
        u.setId(1L);
        u.setName("Aryan");
        u.setEmail("aryan@gmail.com");
        u.setProfile(p);

        service.registerUser(u);

        User fetch = service.getUser(1L);

        assertNotNull(fetch.getProfile());
    }

    @Test
    public void testOneToMany() {

        PurchaseOrder o1 = new PurchaseOrder();
        o1.setId(101);
        o1.setOrderDate("2026-01-01");
        o1.setTotalAmount(1000);

        PurchaseOrder o2 = new PurchaseOrder();
        o2.setId(102);
        o2.setOrderDate("2000-09-01");
        o2.setTotalAmount(2000);

     
        service.addOrderToUser(1L, Arrays.asList(o1, o2));

        User u = service.getUser(1L);

        assertEquals(2, u.getPurchaseOrder().size());
    }

    @Test
    public void testManyToOne() {

        PurchaseOrder order =
                service.getUser(1L).getPurchaseOrder().get(0);

        Payment p = new Payment();
        p.setId(500L);
        p.setMode("UPI");
        p.setAmount(order.getTotalAmount());
        p.setPurchaseOrder(order);

        service.addPayment(p);

        assertEquals(order.getTotalAmount(), p.getAmount());
    }
}
