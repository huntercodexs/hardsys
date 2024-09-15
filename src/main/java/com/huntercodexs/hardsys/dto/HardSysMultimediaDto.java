package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysMultimediaDto {

    private String qty;
    private List<HardSysMultimedia> details;

    public HardSysMultimediaDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysMultimedia> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysMultimedia> details) {
        this.details = details;
    }

    public void addMultimedia(HardSysMultimedia multimedia) {
        this.details.add(multimedia);
    }

    public String toString() {
        return "HardSysMultimediaDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysMultimedia {

        private String id;
        private String name;
        private String source;
        private String description;

        public HardSysMultimedia() {
        }

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String toString() {
            return "HardSysMultimedia[" +
                    "id=" + id +
                    ", name=" + name +
                    ", source=" + source +
                    ", description=" + description +
                    "]";
        }
    }
}
