package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysUnknownDto {

    private String qty;
    private List<HardSysUnknown> details;

    public HardSysUnknownDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysUnknown> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysUnknown> details) {
        this.details = details;
    }

    public void addUnknown(HardSysUnknown unknown) {
        this.details.add(unknown);
    }

    public String toString() {
        return "HardSysUnknownDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysUnknown {

        private String id;
        private String name;
        private String source;
        private String vendor;
        private String description;

        public HardSysUnknown() {}

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

        public String toString() {
            return "HardSysUnknown[" +
                    "id=" + id +
                    ", name=" + name +
                    ", source=" + source +
                    ", vendor=" + vendor +
                    ", description=" + description +
                    "]";
        }
    }
}
