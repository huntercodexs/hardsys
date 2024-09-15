package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysBatteryDto {

    private String qty;
    private List<HardSysBattery> details;

    public HardSysBatteryDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysBattery> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysBattery> details) {
        this.details = details;
    }

    public void addBattery(HardSysBattery battery) {
        this.details.add(battery);
    }

    public String toString() {
        return "HardSysBatteryDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysBattery {

        private String id;
        private String name;
        private String type;
        private String vendor;
        private String source;
        private String serial;
        private String version;
        private String product;
        private String charge;
        private String status;
        private String condition;
        private String description;
        private String manufacturer;
        private List<String> features;

        public HardSysBattery() {}

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public List<String> getFeatures() {
            return features;
        }

        public void setFeatures(List<String> features) {
            this.features = features;
        }

        public String toString() {
            return "HardSysBattery[" +
                    "id=" + id +
                    ", name=" + name +
                    ", type=" + type +
                    ", vendor=" + vendor +
                    ", source=" + source +
                    ", serial=" + serial +
                    ", version=" + version +
                    ", product=" + product +
                    ", charge=" + charge +
                    ", status=" + status +
                    ", condition=" + condition +
                    ", description=" + description +
                    ", manufacturer=" + manufacturer +
                    ", features=" + features +
                    "]";
        }
    }
}
