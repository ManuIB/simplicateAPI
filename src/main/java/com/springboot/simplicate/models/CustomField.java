package com.springboot.simplicate.models;

import java.util.List;

public class CustomField {

	private String id;
	private String name;
	private String label;
	private String value;
	private String type;
	private String render_type;
	private Integer position;
	private Boolean filterable;
	private Boolean searchable;
	private String value_type;
	private CustomFieldGroup custom_field_group;
	private List<Option> options = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRender_type() {
		return render_type;
	}

	public void setRender_type(String render_type) {
		this.render_type = render_type;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getFilterable() {
		return filterable;
	}

	public void setFilterable(Boolean filterable) {
		this.filterable = filterable;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	public String getValue_type() {
		return value_type;
	}

	public void setValue_type(String value_type) {
		this.value_type = value_type;
	}

	public CustomFieldGroup getCustom_field_group() {
		return custom_field_group;
	}

	public void setCustom_field_group(CustomFieldGroup custom_field_group) {
		this.custom_field_group = custom_field_group;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
}
