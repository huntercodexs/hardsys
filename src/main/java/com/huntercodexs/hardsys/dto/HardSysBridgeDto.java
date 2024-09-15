package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysBridgeDto {

    private String qty;
    private List<HardSysBridge> details;

    public HardSysBridgeDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysBridge> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysBridge> details) {
        this.details = details;
    }

    public void addBridge(HardSysBridge bridge) {
        this.details.add(bridge);
    }

    public String toString() {
        return "HardSysBridgeDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysBridge {

        private String id;
        private String name;
        private String type;
        private String vendor;
        private String source;
        private String description;
        private List<String> features;

        public HardSysBridge() {}

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
            return "HardSysBridge[" +
                    "id=" + id +
                    ", name=" + name +
                    ", type=" + type +
                    ", vendor=" + vendor +
                    ", source=" + source +
                    ", description=" + description +
                    ", features=" + features +
                    "]";
        }
    }
}
