/**
 * 
 */
package com.trial.employeebackend.model;

/**
 * 
 */
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

/**
 * @author ARGSAHA
 *
 */
@Entity
@Embeddable
@ApiModel(description="Contains the detailed address of an employee")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressPrimaryKey;
	private int houseNumber;
	/**
	 * @return the addressPrimaryKey
	 */
	public int getAddressPrimaryKey() {
		return addressPrimaryKey;
	}

	/**
	 * @param addressPrimaryKey the addressPrimaryKey to set
	 */
	public void setAddressPrimaryKey(int addressPrimaryKey) {
		this.addressPrimaryKey = addressPrimaryKey;
	}

	private String lane;
	private String district;
	private String locality;
	private String state;
	private long pinCode;

	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * @return the lane
	 */
	public String getLane() {
		return lane;
	}

	/**
	 * @param lane the lane to set
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * @param locality the locality to set
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pinCode
	 */
	public long getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", lane=" + lane + ", district=" + district + ", locality="
				+ locality + ", state=" + state + ", pinCode=" + pinCode + "]";
	}

}
