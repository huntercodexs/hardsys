package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysHubDto {

    private String qty;
    private List<HardSysHub> details;

    public HardSysHubDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysHub> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysHub> details) {
        this.details = details;
    }

    public void addHub(HardSysHub hub) {
        this.details.add(hub);
    }

    public String toString() {
        return "HardSysHubDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysHub {

        private String id;
        private String name;
        private String ports;
        private String speed;
        private String source;
        private String vendor;
        private String description;
        private List<String> features;

        public HardSysHub() {}

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

        public String getPorts() {
            return ports;
        }

        public void setPorts(String ports) {
            this.ports = ports;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
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
            return "HardSysHub[" +
                    "id=" + id +
                    ", name=" + name +
                    ", ports=" + ports +
                    ", speed=" + speed +
                    ", source=" + source +
                    ", vendor=" + vendor +
                    ", description=" + description +
                    ", features=" + features +
                    "]";
        }
    }
}
