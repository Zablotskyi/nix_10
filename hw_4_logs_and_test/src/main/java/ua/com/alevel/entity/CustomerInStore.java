package ua.com.alevel.entity;

public class CustomerInStore {

    Customer customer = new Customer();
    Store store = new Store();

    private Long customerId = customer.getId();
    private String storeId = store.getId();

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "CustomerInStore{" +
                "Id покупателя: " + customerId + '\'' +
                " Id магазина: " + storeId + '\'' +
                '}';
    }
}