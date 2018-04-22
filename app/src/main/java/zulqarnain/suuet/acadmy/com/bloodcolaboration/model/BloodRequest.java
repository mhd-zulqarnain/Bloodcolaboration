package zulqarnain.suuet.acadmy.com.bloodcolaboration.model;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 4/22/2018.
 */

public class BloodRequest {
    public BloodRequest() {
    }

    String donerId;
    String requestId;
    String status;
    ArrayList<Comment> comment;
    String spinner_blood_group;
    String  spinner_urgency;
    String spinner_country;
    String  spinner_state;
    String spinner_city;
    String spinner_hospital;
    String spinner_relation;
    String ed_num_unit;
    String ed_contact;
    String ed_additonal_info;

    public String getDonerId() {
        return donerId;
    }

    public void setDonerId(String donerId) {
        this.donerId = donerId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }

    public String getSpinner_blood_group() {
        return spinner_blood_group;
    }

    public void setSpinner_blood_group(String spinner_blood_group) {
        this.spinner_blood_group = spinner_blood_group;
    }

    public String getSpinner_urgency() {
        return spinner_urgency;
    }

    public void setSpinner_urgency(String spinner_urgency) {
        this.spinner_urgency = spinner_urgency;
    }

    public String getSpinner_country() {
        return spinner_country;
    }

    public void setSpinner_country(String spinner_country) {
        this.spinner_country = spinner_country;
    }

    public String getSpinner_state() {
        return spinner_state;
    }

    public void setSpinner_state(String spinner_state) {
        this.spinner_state = spinner_state;
    }

    public String getSpinner_city() {
        return spinner_city;
    }

    public void setSpinner_city(String spinner_city) {
        this.spinner_city = spinner_city;
    }

    public String getSpinner_hospital() {
        return spinner_hospital;
    }

    public void setSpinner_hospital(String spinner_hospital) {
        this.spinner_hospital = spinner_hospital;
    }

    public String getSpinner_relation() {
        return spinner_relation;
    }

    public void setSpinner_relation(String spinner_relation) {
        this.spinner_relation = spinner_relation;
    }

    public String getEd_num_unit() {
        return ed_num_unit;
    }

    public void setEd_num_unit(String ed_num_unit) {
        this.ed_num_unit = ed_num_unit;
    }

    public String getEd_contact() {
        return ed_contact;
    }

    public void setEd_contact(String ed_contact) {
        this.ed_contact = ed_contact;
    }

    public String getEd_additonal_info() {
        return ed_additonal_info;
    }

    public void setEd_additonal_info(String ed_additonal_info) {
        this.ed_additonal_info = ed_additonal_info;
    }

    public BloodRequest(String donerId, String requestId, String status, ArrayList<Comment> comment, String spinner_blood_group, String spinner_urgency, String spinner_country, String spinner_state, String spinner_city, String spinner_hospital, String spinner_relation, String ed_num_unit, String ed_contact, String ed_additonal_info) {

        this.donerId = donerId;
        this.requestId = requestId;
        this.status = status;
        this.comment = comment;
        this.spinner_blood_group = spinner_blood_group;
        this.spinner_urgency = spinner_urgency;
        this.spinner_country = spinner_country;
        this.spinner_state = spinner_state;
        this.spinner_city = spinner_city;
        this.spinner_hospital = spinner_hospital;
        this.spinner_relation = spinner_relation;
        this.ed_num_unit = ed_num_unit;
        this.ed_contact = ed_contact;
        this.ed_additonal_info = ed_additonal_info;
    }
}
