package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysConnectorDto {

    private String qty;
    private List<HardSysConnector> details;

    public HardSysConnectorDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysConnector> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysConnector> details) {
        this.details = details;
    }

    public void addConnector(HardSysConnector connector) {
        this.details.add(connector);
    }

    public String toString() {
        return "HardSysConnectorDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysConnector {

        private String type;
        private String source;
        private String description;

        public HardSysConnector() {}

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public String toString() {
            return "HardSysConnectorDto[" +
                    "type=" + type +
                    ", source=" + source +
                    ", description=" + description +
                    "]";
        }

    }
}
