package com.shop.tailors.dto;

public class MeasurementRequest {

    private Integer custId;
    private String notes;
    private ShirtMeasurements shirtMeasurements;
    private PantMeasurements pantMeasurements;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ShirtMeasurements getShirtMeasurements() {
        return shirtMeasurements;
    }

    public void setShirtMeasurements(ShirtMeasurements shirtMeasurements) {
        this.shirtMeasurements = shirtMeasurements;
    }

    public PantMeasurements getPantMeasurements() {
        return pantMeasurements;
    }

    public void setPantMeasurements(PantMeasurements pantMeasurements) {
        this.pantMeasurements = pantMeasurements;
    }

    public static class ShirtMeasurements {
        private Double length;
        private Double chest;
        private Double waist;
        private Double hip;
        private Double shoulder;
        private Double sleeve;
        private Double neck;
        private Double cuff;

        public Double getLength() { return length; }
        public void setLength(Double length) { this.length = length; }
        public Double getChest() { return chest; }
        public void setChest(Double chest) { this.chest = chest; }
        public Double getWaist() { return waist; }
        public void setWaist(Double waist) { this.waist = waist; }
        public Double getHip() { return hip; }
        public void setHip(Double hip) { this.hip = hip; }
        public Double getShoulder() { return shoulder; }
        public void setShoulder(Double shoulder) { this.shoulder = shoulder; }
        public Double getSleeve() { return sleeve; }
        public void setSleeve(Double sleeve) { this.sleeve = sleeve; }
        public Double getNeck() { return neck; }
        public void setNeck(Double neck) { this.neck = neck; }
        public Double getCuff() { return cuff; }
        public void setCuff(Double cuff) { this.cuff = cuff; }
    }

    public static class PantMeasurements {
        private Double length;
        private Double waist;
        private Double hip;
        private Double thigh;
        private Double knee;
        private Double calf;
        private Double bottom;

        public Double getLength() { return length; }
        public void setLength(Double length) { this.length = length; }
        public Double getWaist() { return waist; }
        public void setWaist(Double waist) { this.waist = waist; }
        public Double getHip() { return hip; }
        public void setHip(Double hip) { this.hip = hip; }
        public Double getThigh() { return thigh; }
        public void setThigh(Double thigh) { this.thigh = thigh; }
        public Double getKnee() { return knee; }
        public void setKnee(Double knee) { this.knee = knee; }
        public Double getCalf() { return calf; }
        public void setCalf(Double calf) { this.calf = calf; }
        public Double getBottom() { return bottom; }
        public void setBottom(Double bottom) { this.bottom = bottom; }
    }
}
