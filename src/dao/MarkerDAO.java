package dao;

import dto.MarkerDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MarkerDAO {
    private List<MarkerDTO> markerList;

    public MarkerDAO() {
        this.markerList = new ArrayList<>();
    }

    public int addMarkerDetails(MarkerDTO dto) {
        markerList.add(dto);
        return markerList.size();
    }

    public List<MarkerDTO> displayMarkerList() {
        return markerList;
    }

    public boolean removeMarkerById(int mId) {
        try {
            Iterator<MarkerDTO> iterator = markerList.listIterator();
            MarkerDTO marker = iterator.next();
            if (marker.getMarkerId() == mId) {
                iterator.remove();
                return true;
            }
        }catch (NoSuchElementException n){
            System.err.println("Id :"+mId+"\nNo Element Found...");
        }
        return false;
    }

    public boolean updateMarkerById(int mId, MarkerDTO updateMarker) {
        for (MarkerDTO marker : markerList) {
            if (marker.getMarkerId() == mId) {
                marker.setMarkerCompany(updateMarker.getMarkerCompany());
                marker.setMarkerColor(updateMarker.getMarkerColor());
                marker.setMarkerPrice(updateMarker.getMarkerPrice());
                return true;
            }
        }
        return false;
    }
}
