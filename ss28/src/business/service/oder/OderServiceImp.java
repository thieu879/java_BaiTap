package business.service.oder;

import business.dao.Oder.OderDao;
import business.dao.Oder.OrderDaoImp;

public class OderServiceImp implements OderService {
    private final OderDao odderDao;

    public OderServiceImp() {
        odderDao = new OrderDaoImp();
    }

    @Override
    public void createOrderWithDetails(String customerName, String orderDate, String productName, String quantity) {
        odderDao.createOrderWithDetails(customerName,orderDate,productName,quantity);
    }
}
