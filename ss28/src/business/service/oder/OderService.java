package business.service.oder;

import business.service.AppService;

public interface OderService extends AppService {
    void createOrderWithDetails(String customerName,String orderDate,String productName,String quantity);
}
