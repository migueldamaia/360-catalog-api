package com.webapi.catalogfunnelapi.models.offer;

import com.webapi.catalogfunnelapi.models.servicetype.ServiceType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity= OfferLine.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private List<OfferLine> offerLines;

    public Offer() {

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < offerLines.size(); i++) {
            stringBuilder.append(
            "Service: " + offerLines.get(i).getServiceType().getName() +
                    " Price: " + offerLines.get(i).getPrice() + "  " +
              offerLines.get(i).getServiceType().getDescription() + "  || ");
        }

        return stringBuilder.toString();
    }



    public List<OfferLine> getOfferLines() {
        return offerLines;
    }

    public void setOfferLines(List<OfferLine> offerLines) {
        this.offerLines = offerLines;
    }



}
