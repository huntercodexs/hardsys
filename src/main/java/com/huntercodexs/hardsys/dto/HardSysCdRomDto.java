package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysCdRomDto {

    private String qty;
    private List<HardSysCdRom> details;

    public HardSysCdRomDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysCdRom> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysCdRom> details) {
        this.details = details;
    }

    public void addCdRom(HardSysCdRom cdrom) {
        this.details.add(cdrom);
    }

    public String toString() {
        return "HardSysCdRomDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysCdRom {

        private String id;
        private String name;
        private String type;
        private String vendor;
        private String driver;
        private String serial;
        private String source;
        private String manufacture;
        private String description;
        private List<String> features;

        public HardSysCdRom() {}

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

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getManufacture() {
            return manufacture;
        }

        public void setManufacture(String manufacture) {
            this.manufacture = manufacture;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getFeatures() {
            return features;
        }

        public void setFeatures(List<String> features) {
            this.features = features;
        }

        public String toString() {
            return "HardSysCdRom[" +
                    "id=" + id +
                    ", name=" + name +
                    ", type=" + type +
                    ", vendor=" + vendor +
                    ", driver=" + driver +
                    ", serial=" + serial +
                    ", source=" + source +
                    ", manufacture=" + manufacture +
                    ", description=" + description +
                    ", features=" + features +
                    "]";
        }
    }
}
