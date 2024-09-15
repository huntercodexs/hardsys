package com.huntercodexs.hardsys.dto;

import java.util.ArrayList;
import java.util.List;

public class HardSysSensorsDto {

    private String qty;
    private List<HardSysSensors> details;

    public HardSysSensorsDto() {
        this.details = new ArrayList<>();
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<HardSysSensors> getDetails() {
        return details;
    }

    public void setDetails(List<HardSysSensors> details) {
        this.details = details;
    }

    public void addSensor(HardSysSensors sensor) {
        this.details.add(sensor);
    }

    public String toString() {
        return "HardSysSensorsDto[" +
                "qty=" + qty +
                ", details=" + details +
                "]";
    }

    public static class HardSysSensors {

        private String id;
        private String name;
        private String type;
        private String mobo;
        private String speed;
        private String temperature;
        private String source;
        private String driver;
        private String description;
        private List<String> features;

        public HardSysSensors() {}

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMobo() {
            return mobo;
        }

        public void setMobo(String mobo) {
            this.mobo = mobo;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
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
            return "HardSysSensors[" +
                    "id=" + id +
                    ", name=" + name +
                    ", temperature=" + temperature +
                    ", speed=" + speed +
                    ", type=" + type +
                    ", mobo=" + mobo +
                    ", source=" + source +
                    ", driver=" + driver +
                    ", description=" + description +
                    ", features=" + features +
                    "]";
        }
    }
}
