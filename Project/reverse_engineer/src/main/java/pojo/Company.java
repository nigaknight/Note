package pojo;

public class Company {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_company.company
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    private String company;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_company.company_id
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    private Integer companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_company.phone
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    private String phone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_company.company
     *
     * @return the value of tbl_company.company
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_company.company
     *
     * @param company the value for tbl_company.company
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_company.company_id
     *
     * @return the value of tbl_company.company_id
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_company.company_id
     *
     * @param companyId the value for tbl_company.company_id
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_company.phone
     *
     * @return the value of tbl_company.phone
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_company.phone
     *
     * @param phone the value for tbl_company.phone
     *
     * @mbg.generated Wed Jun 26 11:13:44 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}