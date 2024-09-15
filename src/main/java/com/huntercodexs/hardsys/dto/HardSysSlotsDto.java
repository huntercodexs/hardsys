package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysSlotsDto {

    private String qty;
    private List<HardSysSlots> details;

    public HardSysSlotsDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysSlots> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysSlots> details) {
        this.details = details;
    }

    public void addSlot(HardSysSlots slots) {
        this.details.add(slots);
    }

    public String toString() {
        return "HardSysSlotsDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysSlots {

        private String id;
        private String name;
        private String type;
        private String vendor;
        private String device;
        private String serial;
        private String location;
        private String description;
        private String manufacturer;
        private List<String> features;

        public HardSysSlots() {}

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

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
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
            return "HardSysSlots[" +
                    "id=" + id +
                    ", name=" + name +
                    ", type=" + type +
                    ", vendor=" + vendor +
                    ", device=" + device +
                    ", serial=" + serial +
                    ", location=" + location +
                    ", description=" + description +
                    ", manufacturer=" + manufacturer +
                    ", features=" + features +
                    "]";
        }
    }
}
