package business.dao.Oder;

import business.dao.AppDao;

import java.time.LocalDate;

public interface OderDao extends AppDao {
    void createOrderWithDetails(String customerName, String orderDate, String productName, String quantity);
}
