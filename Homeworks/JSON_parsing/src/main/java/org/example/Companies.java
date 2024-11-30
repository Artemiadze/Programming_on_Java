package org.example;

public class Companies {
    private int id;
    private String name;
    private String address;
    private String zip;
    private String country;
    private int employeeCount;
    private String industry;
    private int marketCap;
    private String domain;
    private String logo;
    private String ceoName;

    public Companies(int id, String string_name, String string_address, String string_zip, String string_country,
                     int employeeCount, String string_industry, int marketCap, String string_domain,
                     String string_logo, String string_ceoName) {
        this.id = id;
        this.name = string_name;
        this.address = string_address;
        this.zip = string_zip;
        this.country = string_country;
        this.employeeCount = employeeCount;
        this.industry = string_industry;
        this.marketCap = marketCap;
        this.domain = string_domain;
        this.logo = string_logo;
        this.ceoName = string_ceoName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(int marketCap) {
        this.marketCap = marketCap;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    @Override
    public String toString() {
        return "Companies {" + '\n' +
                " id = " + id +'\n' +
                " name = '" + name + "'\n" +
                " address = '" + address + "'\n" +
                " zip = '" + zip + "'\n" +
                " country = '" + country + "'\n" +
                " employeeCount = '" + employeeCount + "'\n" +
                " industry = '" + industry + "'\n" +
                " marketCap = '" + marketCap + "'\n" +
                " domain = '" + domain + "'\n" +
                " logo = '" + logo + "'\n" +
                " ceoName = '" + ceoName + "'\n" +
                '}';
    }
}
