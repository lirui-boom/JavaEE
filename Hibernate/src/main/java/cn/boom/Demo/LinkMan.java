package cn.boom.Demo;

public class LinkMan {
    private Integer l_id;
    private Integer c_id;
    private String l_name;
    private String l_phone;
    private String l_address;

    private Customer customer;

    public LinkMan() {
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "l_id=" + l_id +
                ", c_id=" + c_id +
                ", l_name='" + l_name + '\'' +
                ", l_phone='" + l_phone + '\'' +
                ", l_address='" + l_address + '\'' +
                '}';
    }

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getL_phone() {
        return l_phone;
    }

    public void setL_phone(String l_phone) {
        this.l_phone = l_phone;
    }

    public String getL_address() {
        return l_address;
    }

    public void setL_address(String l_address) {
        this.l_address = l_address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LinkMan(Integer l_id, Integer c_id, String l_name, String l_phone, String l_address, Customer customer) {

        this.l_id = l_id;
        this.c_id = c_id;
        this.l_name = l_name;
        this.l_phone = l_phone;
        this.l_address = l_address;
        this.customer = customer;
    }
}
