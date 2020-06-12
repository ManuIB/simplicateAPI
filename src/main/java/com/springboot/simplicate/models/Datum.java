package com.springboot.simplicate.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {

	private String id;
	private Employee employee;
	private Leavetype leavetype;
	private String created;
	private String modified;
	private String created_at;
	private String updated_at;
	private String year;
	private Integer hours;
	private String description;
	@JsonProperty("start_date")
	private String startDate;
	private String end_date;
	private Boolean is_user;
	private List<Team> teams = null;
	private Supervisor supervisor;
	private Person person;
	private Status status;
	private String person_id;
	private String name;
	private String bank_account;
	private String function;
	private Type type;
	private String employment_status;
	private CivilStatus civil_status;
	private String work_phone;
	private String work_mobile;
	private String work_email;
	private String hourly_sales_tariff;
	private String hourly_cost_tariff;
	private Avatar avatar;
	private List<CustomField> custom_fields = null;
	private String simplicate_url;
	private String timeline_email_address;
	private Integer balance;
	private String first_change;
	private String last_change;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Leavetype getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(Leavetype leavetype) {
		this.leavetype = leavetype;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Boolean getIs_user() {
		return is_user;
	}

	public void setIs_user(Boolean is_user) {
		this.is_user = is_user;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getEmployment_status() {
		return employment_status;
	}

	public void setEmployment_status(String employment_status) {
		this.employment_status = employment_status;
	}

	public CivilStatus getCivil_status() {
		return civil_status;
	}

	public void setCivil_status(CivilStatus civil_status) {
		this.civil_status = civil_status;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String work_phone) {
		this.work_phone = work_phone;
	}

	public String getWork_mobile() {
		return work_mobile;
	}

	public void setWork_mobile(String work_mobile) {
		this.work_mobile = work_mobile;
	}

	public String getWork_email() {
		return work_email;
	}

	public void setWork_email(String work_email) {
		this.work_email = work_email;
	}

	public String getHourly_sales_tariff() {
		return hourly_sales_tariff;
	}

	public void setHourly_sales_tariff(String hourly_sales_tariff) {
		this.hourly_sales_tariff = hourly_sales_tariff;
	}

	public String getHourly_cost_tariff() {
		return hourly_cost_tariff;
	}

	public void setHourly_cost_tariff(String hourly_cost_tariff) {
		this.hourly_cost_tariff = hourly_cost_tariff;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<CustomField> getCustom_fields() {
		return custom_fields;
	}

	public void setCustom_fields(List<CustomField> custom_fields) {
		this.custom_fields = custom_fields;
	}

	public String getSimplicate_url() {
		return simplicate_url;
	}

	public void setSimplicate_url(String simplicate_url) {
		this.simplicate_url = simplicate_url;
	}

	public String getTimeline_email_address() {
		return timeline_email_address;
	}

	public void setTimeline_email_address(String timeline_email_address) {
		this.timeline_email_address = timeline_email_address;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getFirst_change() {
		return first_change;
	}

	public void setFirst_change(String first_change) {
		this.first_change = first_change;
	}

	public String getLast_change() {
		return last_change;
	}

	public void setLast_change(String last_change) {
		this.last_change = last_change;
	}
}
