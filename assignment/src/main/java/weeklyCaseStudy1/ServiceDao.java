package weeklyCaseStudy1;

import java.util.List;

public class ServiceDao {

    private UserDao userDao = new UserDao();
    private PaymentDao paymentDao = new PaymentDao();
    private OrderDao orderDao = new OrderDao();

    public void registerUser(User u) {
        userDao.saveUser(u);
    }

    public void addOrderToUser(long id, List<PurchaseOrder> orders) {

        User u = userDao.findUser(id);

        u.getPurchaseOrder().addAll(orders);

        userDao.updateUser(u);
    }

    public void addPayment(Payment p) {
        paymentDao.savePayment(p);
    }

    public User getUser(long id) {
        return userDao.findUser(id);
    }

    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    public void updateOrderAmount(long id, double amount) {

        PurchaseOrder o = orderDao.findOrder(id);
        o.setTotalAmount(amount);

        orderDao.updateOrder(o);
    }
}
